create table tb_address (
    cod_address bigint primary key not null auto_increment,
    address varchar(200),
    city varchar(200),
    state varchar(200),
    postal_code varchar(200),
    country varchar(200),
    created_at datetime default now(),
    updated_at datetime default now()
);