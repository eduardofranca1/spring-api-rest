create table tb_persons (
    cod_person varchar(255) primary key,
    name varchar(255) not null,
    gender varchar(10) not null,
    birthday date not null,
    avatar varchar(255),
    created_at datetime default now(),
    updated_at datetime,

    fk_address varchar(255) not null,
    foreign key (fk_address) references tb_address(cod_address)
);