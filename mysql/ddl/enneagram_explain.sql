create table enneagram_explain
(
    enneagram_type               int not null,
    basic_explains               varchar(100),
    merits                       MEDIUMTEXT,
    demerits                     MEDIUMTEXT,
    human_relations              MEDIUMTEXT,
    surrounding_evaluations      MEDIUMTEXT,
    friend_ways                  MEDIUMTEXT,
    hard_works                   MEDIUMTEXT,
    comfort_sentences            MEDIUMTEXT,
    primary key (enneagram_type)
) engine = InnoDB;