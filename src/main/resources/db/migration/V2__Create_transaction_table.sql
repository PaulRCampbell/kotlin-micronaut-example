CREATE TABLE transaction
(
    id          SERIAL      NOT NULL PRIMARY KEY,
    title       VARCHAR(100),
    description VARCHAR(200),
    value       NUMERIC(100, 2),
    created_at  TIMESTAMPTZ NOT NULL DEFAULT NOW()
);