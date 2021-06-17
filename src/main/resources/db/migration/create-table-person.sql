create table tb_persons (
    cod_person bigint primary key not null auto_increment,
    name varchar(60) not null,
    gender varchar(10) not null,
    birthday date not null,

    cod_address bigint not null,
    foreign key(cod_address) references tb_address(cod_address)
);