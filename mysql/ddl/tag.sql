create table tag
(
    tag_id      bigint not null auto_increment,
    tag_name    varchar(255),
    post_id     bigint,
    insert_date datetime(6),
    insert_id   bigint,
    update_date datetime(6),
    update_id   bigint,
    primary key (tag_id)
) engine = InnoDB;

alter table tag
    add constraint fk_Tag_Post_postId foreign key (post_id) references post (post_id);