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
	`grade` TINYINT(4) DEFAULT NULL DEFAULT '10',
	PRIMARY KEY (`userid`),
	INDEX `seq` (`seq`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;

CREATE TABLE IF NOT EXISTS `member_grade` (
  `seq` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `desc` varchar(200) DEFAULT NULL,
  `grade` tinyint(4) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `createdate` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`seq`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--데이터 추가
INSERT INTO `member_grade` (name`, `desc`, `grade`, `count`, `createdate`) VALUES
	('일반', '일반 회원', 10, 0, '2016-09-12 11:05:14'),
	('슈퍼관리자', '슈퍼관리자', 1, 0, '2016-09-12 11:06:31');

--게시판 관리 정보
CREATE TABLE `boardManager` (
  `seq` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  `totalArticle` bigint(20) DEFAULT '0',
  `createDate` datetime DEFAULT CURRENT_TIMESTAMP,
  `modifyDate` datetime DEFAULT NULL,
  `displayType` tinyint(1) DEFAULT '1' COMMENT '1-목록,2-썸네일,3-블로그형',
  `isComment` tinyint(1) DEFAULT '1' COMMENT '1-사용, 0 - 미사용',
  `writer` varchar(50) DEFAULT NULL COMMENT '게시판 생성자 정보',
  `isArticleWriter` tinyint(1) DEFAULT '1' COMMENT '1 - 게시물 작성 가능, 0 -게시물 작성 불가',
  PRIMARY KEY (`seq`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
