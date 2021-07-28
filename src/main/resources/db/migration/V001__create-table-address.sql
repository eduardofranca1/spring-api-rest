CREATE TABLE IF NOT EXISTS tb_address (
    cod_address VARCHAR(255) PRIMARY KEY ,
    address VARCHAR(255) NOT NULL,
    city VARCHAR(255) NOT NULL,
    state VARCHAR(255) NOT NULL,
    postal_code VARCHAR(255) NOT NULL,
    country VARCHAR(255) NOT NULL,
    created_at DATETIME default now(),
    updated_at DATETIME
);