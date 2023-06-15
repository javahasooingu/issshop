DROP table IF EXISTS inquiry ;

CREATE TABLE inquiry
(
    id bigint NOT NULL AUTO_INCREMENT,
    user_id bigint NOT NULL,
    type varchar(30) NOT NULL,
    type_detail varchar2(30) NOT NULL,
    title varchar(100) NOT NULL,
    contents text NOT NULL,
    secret tinyint NOT NULL DEFAULT '1',
    pw varchar(60) NULL,
    response text NULL,
    status varchar(30) NOT NULL,
    created_date datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    responsed_date datetime NULL DEFAULT NULL,
    PRIMARY KEY (id)
);
