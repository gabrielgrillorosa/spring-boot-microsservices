CREATE TABLE application_user (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	username VARCHAR(50) NOT NULL,
	password VARCHAR(256) NOT NULL,
	role VARCHAR(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO application_user (id,username, password,role) VALUES (1,'gabriel', '$2a$10$32ODQSMnVDZiQvcZvIam7O0mRE3AsNfuerH9fuXFXWdKTTDpJjzwi','ADMIN');