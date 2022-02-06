create table likey
(
    id                      bigint not null auto_increment,
    user_id                 bigint,
    post_id                 bigint,
    insert_date             datetime(6),
    insert_id               bigint,
    update_date             datetime(6),
    update_id               bigint,
    primary key (id)
) engine = InnoDB;

alter table likey
    add constraint fk_Likey_User_userId foreign key (user_id) references user (user_id);

alter table likey
    add constraint fk_Likey_Post_testId foreign key (post_id) references post (post_id);