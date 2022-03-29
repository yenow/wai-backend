create table reply
(
    reply_id                bigint not null auto_increment,
    post_id                 bigint,
    user_id                 bigint,
    author                  varchar(200),
    author_enneagram_type   int,
    reply_content           varchar(300),
    parent_reply_id         bigint,
    parent_reply_user_id    bigint null,
    parent_author           varchar(200),
    is_deleted              bit default 0,
    is_reported             bit default 0,
    insert_date             datetime(6),
    insert_id               bigint,
    update_date             datetime(6),
    update_id               bigint,
    primary key (reply_id)
) engine = InnoDB;

alter table reply
    add constraint fk_REPLY_POST_postId foreign key (post_id) references post (post_id);
alter table reply
    add constraint fk_REPLY_POST_userId foreign key (user_id) references user (user_id);

