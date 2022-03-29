create table post_history
(
    id          bigint not null auto_increment,
    post_id     bigint,
    user_id     bigint,
    insert_date datetime(6),
    insert_id   bigint,
    update_date datetime(6),
    update_id   bigint,
    primary key (id)
) engine = InnoDB;


alter table post_history add constraint fk_POST_HISTORY_POST_postId foreign key (post_id) references post (post_id);
alter table post_history add constraint fk_POST_HISTORY_USER_postId foreign key (user_id) references user (user_id);