-- Legacy DB
CREATE TABLE IF NOT EXISTS customers (
    id         BIGSERIAL PRIMARY KEY,
    email      VARCHAR(255) NOT NULL UNIQUE,
    full_name  VARCHAR(255),
    phone      VARCHAR(30),
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);

-- Seed 5,000 rows for demo
INSERT INTO customers (email, full_name, phone)
SELECT
    'user' || g || '@legacy.example.com',
    'User '  || g,
    '+91-9' || LPAD(g::text, 9, '0')
FROM generate_series(1, 5000) g;
