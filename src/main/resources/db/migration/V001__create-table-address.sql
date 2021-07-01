create table tb_address (
    cod_address varchar(255) primary key,
    address varchar(255) not null,
    city varchar(255) not null,
    state varchar(255) not null,
    postal_code varchar(255) not null,
    country varchar(255) not null,
    created_at datetime default now(),
    updated_at datetime
);