create table wise_saying
(
    id                  bigint not null auto_increment,
    user_id             bigint null,
    enneagram_type      int null,
    wise_saying         varchar(4000) not null,
    author              varchar(100),
    insert_date         datetime(6),
    insert_id           bigint,
    update_date         datetime(6),
    update_id           bigint,
    primary key (id)
) engine = InnoDB;

alter table wise_saying
    add constraint fk_WiseSaying_User_userId foreign key (user_id) references user (user_id);

alter table wise_saying
    add constraint fk_WiseSaying_Enneagram_enneagramType foreign key (enneagram_type) references enneagram (enneagram_type);
