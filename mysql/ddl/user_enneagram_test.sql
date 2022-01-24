create table user_enneagram_test
(
    id      bigint not null auto_increment,
    user_id bigint,
    test_id bigint,
    insert_date             datetime(6),
    insert_id               bigint,
    update_date             datetime(6),
    update_id               bigint,
    primary key (id)
) engine = InnoDB;

alter table user_enneagram_test
    add constraint fk_UserEnneagramTest_EnneagraTest_testId foreign key (test_id) references enneagram_test (test_id);

alter table user_enneagram_test
    add constraint fk_UserEnneagramTest_User_userId foreign key (user_id) references user (user_id);