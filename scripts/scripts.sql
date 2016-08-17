CREATE DATABASE `kr.huny.java` /*!40100 COLLATE 'utf8_general_ci' */;

CREATE TABLE `members` (
	`seq` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`userid` VARCHAR(50) NOT NULL DEFAULT '0',
	`userpwd` VARCHAR(100) NOT NULL DEFAULT '0',
	`nickname` VARCHAR(50) NOT NULL DEFAULT '0',
	`pwdfailcnt` TINYINT(4) NOT NULL DEFAULT '0',
	`regdate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`lastlogindate` TIMESTAMP NULL DEFAULT NULL,
	`isloginblock` TINYINT(4) NULL DEFAULT '0' COMMENT '0-허용,1-로그인 불가',
	PRIMARY KEY (`userid`),
	INDEX `seq` (`seq`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;
