package com.example.migration;

import java.sql.*;

public class CustomerMigration {

    private static final int BATCH_SIZE = 1000;

    private static final String LEGACY_URL  = "jdbc:postgresql://localhost:5432/legacy_db";
    private static final String NEW_URL     = "jdbc:postgresql://localhost:5432/new_db";
    private static final String USER        = "postgres";
    private static final String PASS        = "postgres";

    private static final String SELECT_SQL =
            "SELECT id, email, full_name, phone " +
            "FROM customers " +
            "WHERE id > ? " +
            "ORDER BY id ASC " +
            "LIMIT ?";

    private static final String UPSERT_SQL =
            "INSERT INTO customers (id, email, full_name, phone) " +
            "VALUES (?, ?, ?, ?) " +
            "ON CONFLICT (id) DO UPDATE SET " +
            "  email = EXCLUDED.email, " +
            "  full_name = EXCLUDED.full_name, " +
            "  phone = EXCLUDED.phone";

    public static void main(String[] args) throws SQLException {
        try (Connection legacy = DriverManager.getConnection(LEGACY_URL, USER, PASS);
             Connection modern = DriverManager.getConnection(NEW_URL, USER, PASS)) {

            modern.setAutoCommit(false);

            long lastId = 0L;
            long totalMigrated = 0L;
            int batchNumber = 0;

            while (true) {
                int rowsInBatch = migrateOneBatch(legacy, modern, lastId);
                if (rowsInBatch == 0) break;

                batchNumber++;
                totalMigrated += rowsInBatch;
                lastId = readMaxIdSoFar(modern);

                System.out.printf("Batch %d: migrated %d rows (running total = %d, lastId = %d)%n",
                        batchNumber, rowsInBatch, totalMigrated, lastId);
            }

            System.out.printf("Done. Migrated %d rows in %d batches.%n",
                    totalMigrated, batchNumber);
        }
    }

    private static int migrateOneBatch(Connection legacy, Connection modern, long lastId)
            throws SQLException {

        try (PreparedStatement select = legacy.prepareStatement(SELECT_SQL);
             PreparedStatement upsert = modern.prepareStatement(UPSERT_SQL)) {

            select.setLong(1, lastId);
            select.setInt(2, BATCH_SIZE);

            int count = 0;
            try (ResultSet rs = select.executeQuery()) {
                while (rs.next()) {
                    upsert.setLong  (1, rs.getLong("id"));
                    upsert.setString(2, rs.getString("email"));
                    upsert.setString(3, rs.getString("full_name"));
                    upsert.setString(4, rs.getString("phone"));
                    upsert.addBatch();
                    count++;
                }
            }

            if (count > 0) {
                upsert.executeBatch();
                modern.commit();
            }
            return count;
        } catch (SQLException e) {
            modern.rollback();
            throw e;
        }
    }

    private static long readMaxIdSoFar(Connection modern) throws SQLException {
        try (Statement st = modern.createStatement();
             ResultSet rs = st.executeQuery("SELECT COALESCE(MAX(id), 0) FROM customers")) {
            rs.next();
            return rs.getLong(1);
        }
    }
}
