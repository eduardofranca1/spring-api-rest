CREATE TABLE IF NOT EXISTS tb_users (
    cod_user VARCHAR(255) PRIMARY KEY,
    username VARCHAR(40) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    deleted BOOLEAN,
    created_at DATETIME default now(),
    updated_at DATETIME,

    unique key uk_username (username),
    unique key uk_email (email),

    fk_person VARCHAR(255) NOT NULL,
    FOREIGN KEY (fk_person) REFERENCES tb_persons(cod_person)
);