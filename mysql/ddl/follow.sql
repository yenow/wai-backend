create table follow
(
    id               bigint not null auto_increment,
    followee_user_id bigint,
    follower_user_id bigint,
    insert_date      datetime(6),
    insert_id        bigint,
    update_date      datetime(6),
    update_id        bigint,
    primary key (id)
) engine = InnoDB;

alter table follow
    add constraint fk_Follow_followeeUserId_User_userId foreign key (followee_user_id) references user (user_id);
alter table follow
    add constraint fk_Follow_followerUserId_User_userId foreign key (follower_user_id) references user (user_id);