create table enneagram
(
    enneagram_type           int not null,
    animal_name              varchar(100),
    image_path               varchar(1000),
    sub_name                 varchar(1000),
    simple_explain           varchar(1000),
    simple_explain2          varchar(1000),
    primary key (enneagram_type)
) engine = InnoDB;
