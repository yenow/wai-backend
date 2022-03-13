create table report
(
    report_id               bigint not null auto_increment,
    post_id                 bigint null,
    reply_id                bigint null,
    report_status           varchar(100),
    reason                  varchar(4000),
    answer                  varchar(4000),
    insert_date             datetime(6),
    insert_id               bigint,
    update_date             datetime(6),
    update_id               bigint,
    primary key (report_id)
) engine = InnoDB;

alter table report
    add constraint fk_REPORT_POST_post_id
        foreign key (post_id)
            references Post (post_id);

alter table report
    add constraint fk_REPORT_REPLY_post_id
        foreign key (reply_id)
            references reply (reply_id);