-- Starting monolithic users table
DROP TABLE IF EXISTS users CASCADE;

CREATE TABLE users (
    id            BIGSERIAL PRIMARY KEY,
    email         VARCHAR(255) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    full_name     VARCHAR(255),
    phone         VARCHAR(30),
    dob           DATE,
    bio           TEXT,
    avatar_url    VARCHAR(500),
    created_at    TIMESTAMPTZ NOT NULL DEFAULT NOW()
);

INSERT INTO users (email, password_hash, full_name, phone, dob, bio, avatar_url)
VALUES
    ('sujal@example.com', 'hash1', 'Sujal Kumar', '+91-9000000001',
        '1998-05-10', 'Backend developer', 'https://cdn/x/1.png'),
    ('anita@example.com', 'hash2', 'Anita Sharma', '+91-9000000002',
        '1996-01-22', 'Data engineer',     'https://cdn/x/2.png');
