# Task 20.5 — Incremental Migration (Batches of 1,000)

Move customer records from a legacy PostgreSQL DB to a new microservice
PostgreSQL DB, **1,000 rows at a time**, resumable and idempotent.

```
   legacy_db.customers  --(batch=1000)-->  new_db.customers
```

## Key ideas
- **Keyset pagination** on `id` (avoids OFFSET slowdowns).
- **Idempotent upsert** on the destination (`ON CONFLICT DO UPDATE`) so a rerun
  after a crash is safe.
- Progress printed per batch; last successfully migrated `id` acts as the
  resume checkpoint.

## Files
- `sql/legacy_schema.sql`   — sample legacy `customers` table + seed data
- `sql/new_schema.sql`      — target `customers` table on the new service
- `src/main/java/com/example/migration/CustomerMigration.java` — the script

## Run
```
javac -cp postgresql.jar src/main/java/com/example/migration/CustomerMigration.java
java  -cp .:postgresql.jar com.example.migration.CustomerMigration
```
