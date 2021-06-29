create table tb_users (
    cod_user bigint primary key not null auto_increment,
    username varchar(40) not null,
    email varchar(255) not null,
    password varchar(255) not null,
    deleted boolean,
    created_at datetime default now(),
    updated_at datetime default now(),

    unique key uk_username (username),
    unique key uk_email (email),

    fk_person bigint not null,
    foreign key(fk_person) references tb_persons(cod_person)
);