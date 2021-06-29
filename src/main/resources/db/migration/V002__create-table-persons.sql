create table tb_persons (
    cod_person bigint primary key not null auto_increment,
    name varchar(100) not null,
    gender varchar(10) not null,
    birthday date not null,
    avatar varchar(255),
    created_at datetime default now(),
    updated_at datetime default now(),

    fk_address bigint not null,
    foreign key (fk_address) references tb_address(cod_address)
);