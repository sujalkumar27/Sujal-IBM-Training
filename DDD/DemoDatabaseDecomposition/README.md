# Task 20.4 — Database Decomposition

Split a monolithic `users` table into two focused tables while keeping
foreign-key integrity:

```
   users (monolith)
   ┌──────────────────────────────────────┐
   │ id, email, password_hash,            │
   │ full_name, phone, dob, bio, avatar   │
   └──────────────────────────────────────┘

                    │  split
                    ▼

   accounts                     profiles
   ┌──────────────────────┐     ┌────────────────────────────────┐
   │ id (PK)              │◄──┐ │ account_id (PK & FK -> accounts)│
   │ email                │   │ │ full_name                      │
   │ password_hash        │   └─│ phone, dob, bio, avatar_url    │
   │ created_at           │     └────────────────────────────────┘
   └──────────────────────┘
```

Run the scripts in order.

## Files (PostgreSQL)
- `01_original_users.sql`      — starting schema + seed data
- `02_create_new_tables.sql`   — accounts + profiles with FK
- `03_migrate_data.sql`        — copy from users into new tables
- `04_verify_and_cleanup.sql`  — integrity checks; optional drop of old table
