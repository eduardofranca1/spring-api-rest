create table tb_address (
    cod_address bigint primary key not null auto_increment,
    address varchar(100),
    city varchar(100),
    state varchar(100),
    postal_code varchar(100),
    country varchar(60)
);