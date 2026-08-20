-- New decomposed schema
DROP TABLE IF EXISTS profiles CASCADE;
DROP TABLE IF EXISTS accounts CASCADE;

CREATE TABLE accounts (
    id            BIGSERIAL PRIMARY KEY,
    email         VARCHAR(255) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    created_at    TIMESTAMPTZ NOT NULL DEFAULT NOW()
);

CREATE TABLE profiles (
    account_id  BIGINT PRIMARY KEY
                REFERENCES accounts(id)
                ON DELETE CASCADE
                ON UPDATE CASCADE,
    full_name   VARCHAR(255),
    phone       VARCHAR(30),
    dob         DATE,
    bio         TEXT,
    avatar_url  VARCHAR(500)
);
