DROP TABLE IF EXISTS product;

CREATE TABLE product
(
    id     BIGINT       NOT NULL AUTO_INCREMENT,
    name   VARCHAR(255)      NOT NULL,
    price  BIGINT        NOT NULL,
    PRIMARY KEY (id)
);

DROP table IF EXISTS inquiry ;

CREATE TABLE inquiry
(
                           id bigint NOT NULL AUTO_INCREMENT,
                           user_id bigint NOT NULL,
                           type varchar(30) NOT NULL,
                           title varchar(100) NOT NULL,
                           contents text NOT NULL,
                           secret tinyint NOT NULL DEFAULT '1',
                           pw varchar(50) NULL,
                           response text NULL,
                           status varchar(30) NOT NULL DEFAULT 'PENDING',
                           created_date datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
                           responsed_date datetime NULL DEFAULT NULL,
                           PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
