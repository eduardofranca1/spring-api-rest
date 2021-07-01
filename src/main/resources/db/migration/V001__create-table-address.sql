create table tb_address (
    cod_address varchar(255) primary key not null,
    address varchar(200),
    city varchar(200),
    state varchar(200),
    postal_code varchar(200),
    country varchar(200),
    created_at timestamp default now(),
    updated_at timestamp default now()
);