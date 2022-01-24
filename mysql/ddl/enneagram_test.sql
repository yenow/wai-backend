create table enneagram_test
(
    test_id                 bigint not null auto_increment,
    selected_enneagram_type integer,
    test_type               varchar(255),
    type1score              integer,
    type2score              integer,
    type3score              integer,
    type4score              integer,
    type5score              integer,
    type6score              integer,
    type7score              integer,
    type8score              integer,
    type9score              integer,
    insert_date             datetime(6),
    insert_id               bigint,
    update_date             datetime(6),
    update_id               bigint,
    primary key (test_id)
) engine = InnoDB;


