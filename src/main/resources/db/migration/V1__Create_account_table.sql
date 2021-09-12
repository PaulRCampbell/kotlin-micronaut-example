CREATE TABLE account
(
    id           SERIAL      NOT NULL PRIMARY KEY,
    name      VARCHAR (100),
    description VARCHAR (200),
    created_at   TIMESTAMPTZ NOT NULL DEFAULT NOW()
);