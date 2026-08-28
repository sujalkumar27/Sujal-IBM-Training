-- New microservice DB
CREATE TABLE IF NOT EXISTS customers (
    id           BIGINT PRIMARY KEY,   -- reuse legacy id for traceability
    email        VARCHAR(255) NOT NULL UNIQUE,
    full_name    VARCHAR(255),
    phone        VARCHAR(30),
    migrated_at  TIMESTAMPTZ NOT NULL DEFAULT NOW()
);
