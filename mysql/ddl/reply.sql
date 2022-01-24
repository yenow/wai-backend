create table reply
(
    reply_id        bigint not null auto_increment,
    parent_reply_id bigint,
    post_id         bigint,
    user_id         bigint,
    reply_content   varchar(255),
    insert_date     datetime(6),
    insert_id       bigint,
    update_date     datetime(6),
    update_id       bigint,
    primary key (reply_id)
) engine = InnoDB;

alter table reply
    add constraint fk_Reply_Post_postId foreign key (post_id) references post (post_id);
alter table reply
    add constraint fk_Reply_User_userId foreign key (user_id) references user (user_id);