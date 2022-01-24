create table post
(
    post_id     bigint        not null auto_increment,
    user_id     bigint,
    author      varchar(200),
    click_count int default 0,
    content     varchar(4000) not null,
    is_delete   bit,
    title       varchar(300)  not null,
    insert_date datetime(6),
    insert_id   bigint,
    update_date datetime(6),
    update_id   bigint,
    primary key (post_id)
) engine = InnoDB;

alter table post
    add constraint fk_Post_User_userId foreign key (user_id) references user (user_id);