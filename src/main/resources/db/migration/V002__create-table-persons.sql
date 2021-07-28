CREATE TABLE IF NOT EXISTS  tb_persons (
    cod_person VARCHAR(255) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    gender VARCHAR(10) NOT NULL,
    birthday DATE NOT NULL,
    avatar VARCHAR(255),
    created_at DATETIME default now(),
    updated_at DATETIME,

    fk_address VARCHAR(255) NOT NULL,
    FOREIGN KEY (fk_address) REFERENCES tb_address(cod_address)
);