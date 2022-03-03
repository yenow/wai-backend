create table post
(
    post_id                     bigint        not null auto_increment,
    user_id                     bigint,
    title                       varchar(300)  not null,
    author                      varchar(200),
    author_enneagram_type       int,
    content                     varchar(4000) not null,
    click_count                 int default 0 not null,
    is_deleted                  bit default 0 not null,
    is_reported                 bit default 0 not null,
    insert_date                 datetime(6),
    insert_id                   bigint,
    update_date                 datetime(6),
    update_id                   bigint,
    primary key (post_id)
) engine = InnoDB;

alter table post
    add constraint fk_POST_USER_userId foreign key (user_id) references user (user_id);