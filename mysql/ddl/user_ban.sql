drop table ban_user;

create table ban_user
(
    id                      bigint not null auto_increment,
    user_id                 bigint null,
    ban_user_id             bigint null,
    insert_date             datetime(6),
    insert_id               bigint,
    update_date             datetime(6),
    update_id               bigint,
    primary key (id)
) engine = InnoDB;


alter table ban_user
    add constraint fk_USER_BAN_USER_userId foreign key (user_id) references user (user_id);

alter table ban_user
    add constraint fk_USER_BAN_USER_userBanId foreign key (ban_user_id) references user (user_id);