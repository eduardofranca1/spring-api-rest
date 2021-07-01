create table tb_persons (
    cod_person varchar(255) primary key not null,
    name varchar(100) not null,
    gender varchar(10) not null,
    birthday date not null,
    avatar varchar(255),
    created_at timestamp default now(),
    updated_at timestamp default now(),

    fk_address varchar(255) not null,
    foreign key (fk_address) references tb_address(cod_address)
);