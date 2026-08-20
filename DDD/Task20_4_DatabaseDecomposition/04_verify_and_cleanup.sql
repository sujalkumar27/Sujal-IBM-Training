-- Verify FK integrity: every profile must point to a real account
SELECT p.account_id
FROM profiles p
LEFT JOIN accounts a ON a.id = p.account_id
WHERE a.id IS NULL;   -- should return 0 rows

-- Row-count check
SELECT
    (SELECT COUNT(*) FROM users)    AS users_count,
    (SELECT COUNT(*) FROM accounts) AS accounts_count,
    (SELECT COUNT(*) FROM profiles) AS profiles_count;

-- Once the app writes to accounts+profiles only, drop the old table:
-- DROP TABLE users;
