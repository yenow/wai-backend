create table user
(
    user_id         bigint       not null auto_increment,
    user_key        varchar(200) not null,
    email           varchar(200),
    password        varchar(200),
    nickname        varchar(50),
    is_member       bit         not null default 0,
    is_activated    bit         not null default 1,
    insert_date     datetime(6),
    insert_id       bigint,
    update_date     datetime(6),
    update_id       bigint,
    primary key (user_id)
) engine = InnoDB;

alter table user
    add constraint uk_USER_userKey unique (user_key);

alter table user
    add constraint uk_USER_email unique (email);