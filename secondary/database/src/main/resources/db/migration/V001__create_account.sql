CREATE TABLE account
(
    id              BIGSERIAL    NOT NULL PRIMARY KEY,
    document_number VARCHAR(255) NOT NULL,
    UNIQUE (document_number)
);
