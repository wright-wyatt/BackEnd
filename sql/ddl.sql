DROP TABLE IF EXISTS USER_ACCOUNT_INFO CASCADE;

CREATE TABLE USER_ACCOUNT_INFO
(
	seqno int primary key auto_increment,
    id varchar(32) not null,
    password varchar(32) not null,
    user_grant varchar(1) default 'N'
) engine=InnoDB;