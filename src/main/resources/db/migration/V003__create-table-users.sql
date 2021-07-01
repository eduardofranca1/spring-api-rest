create table tb_users (
    cod_user varchar(255) primary key not null,
    username varchar(40) not null,
    email varchar(255) not null,
    password varchar(255) not null,
    deleted boolean,
    created_at timestamp default now(),
    updated_at timestamp default now(),

    unique key uk_username (username),
    unique key uk_email (email),

    fk_person varchar(255) not null,
    foreign key(fk_person) references tb_persons(cod_person)
);