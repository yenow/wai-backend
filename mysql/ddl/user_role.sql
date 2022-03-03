create table user_role (
    id              bigint not null auto_increment,
    role            varchar(200) not null,
    user_id         bigint,
    primary key (id)
);


alter table user_role
    add constraint fk_USER_ROLE_USER_user_id
        foreign key (user_id)
            references user (user_id);