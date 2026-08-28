-- Move data from monolithic users -> accounts + profiles
BEGIN;

INSERT INTO accounts (id, email, password_hash, created_at)
SELECT id, email, password_hash, created_at
FROM users;

INSERT INTO profiles (account_id, full_name, phone, dob, bio, avatar_url)
SELECT id, full_name, phone, dob, bio, avatar_url
FROM users;

-- Keep BIGSERIAL sequence in sync with pre-existing ids
SELECT setval(
    pg_get_serial_sequence('accounts', 'id'),
    COALESCE((SELECT MAX(id) FROM accounts), 1)
);

COMMIT;
