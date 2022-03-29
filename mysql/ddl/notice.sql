create table notice
(
    notice_id         bigint not null auto_increment,
    giver_user_id     bigint,
    recipient_user_id bigint,
    target_post_id    bigint,
    target_reply_id   bigint,

    notice_type       varchar(100)  null,
    content           varchar(4000),
    is_read           bit bit default 0 not null,

    insert_date       datetime(6),
    insert_id         bigint,
    update_date       datetime(6),
    update_id         bigint,
    primary key (notice_id)
) engine = InnoDB;

alter table notice add constraint FK_NOTICE_USER_giver_user_id foreign key (giver_user_id) references user (user_id);
alter table notice add constraint FK_NOTICE_USER_recipient_user_id foreign key (recipient_user_id) references user (user_id);
alter table notice add constraint FK_NOTICE_POST_target_post_id foreign key (target_post_id) references post (post_id);
alter table notice add constraint FK_NOTICE_REPLY_target_reply_id foreign key (target_reply_id) references reply (reply_id);