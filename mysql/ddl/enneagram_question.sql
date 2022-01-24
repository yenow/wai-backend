create table enneagram_question
(
    id                 bigint not null auto_increment,
    test_type               varchar(100),
    question_number         integer,
    question                varchar(4000),
    enneagram_type          integer,
    unique_string           varchar(1),
    primary key (id)
) engine = InnoDB;


