create table user
(
    user_id      bigint       not null auto_increment,
    birth_day    varchar(50),
    email        varchar(200),
    gender       varchar(10),
    nickname     varchar(50),
    password     varchar(200),
    phone_number varchar(13),
    user_key     varchar(200) not null,
    insert_date  datetime(6),
    insert_id    bigint,
    update_date  datetime(6),
    update_id    bigint,
    primary key (user_id)
) engine = InnoDB;

alter table user
    add constraint uk_User_userKey unique (user_key);