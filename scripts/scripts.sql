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

CREATE TABLE IF NOT EXISTS `memberGrade` (
  `seq` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `desc` varchar(200) DEFAULT NULL,
  `grade` tinyint(4) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `regdate` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`seq`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--데이터 추가
INSERT INTO `memberGrade` (name`, `desc`, `grade`, `count`, `regdate`) VALUES
	('일반', '일반 회원', 10, 0, '2016-09-12 11:05:14'),
	('슈퍼관리자', '슈퍼관리자', 1, 0, '2016-09-12 11:06:31');

--로그인 시도 기록
CREATE TABLE `loginhistory` (
	`seq` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`userid` VARCHAR(50) NOT NULL DEFAULT '0',
	`remoteip` VARCHAR(23) NOT NULL DEFAULT '0' COMMENT 'ipv4/ipv6',
	`date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`result` VARCHAR(50) NULL DEFAULT NULL,
	`flag` TINYINT(1) NULL DEFAULT NULL COMMENT '1-사용자,2-관리자',
	PRIMARY KEY (`seq`),
	INDEX `userid` (`userid`),
	INDEX `userid_flag` (`userid`, `flag`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;



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
	`listSize` INT(11) NULL DEFAULT '1',
  `writer` varchar(50) DEFAULT NULL COMMENT '게시판 생성자 정보',
  `isArticleWriter` tinyint(1) DEFAULT '1' COMMENT '1 - 게시물 작성 가능, 0 -게시물 작성 불가',
  PRIMARY KEY (`seq`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--게시물 관리
CREATE TABLE `articles` (
	`seq` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`bm_seq` BIGINT(20) NOT NULL COMMENT '게시판 seq',
	`title` VARCHAR(200) NULL DEFAULT NULL,
	`contents` TEXT NULL,
	`writer` VARCHAR(50) NULL DEFAULT NULL,
	`createdate` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
	`modifydate` DATETIME NULL DEFAULT NULL,
	`deletedate` DATETIME NULL DEFAULT NULL,
	`isNotice` BIT(1) NOT NULL DEFAULT b'0' COMMENT '0-일반,1-공지',
	`isComment` BIT(1) NOT NULL DEFAULT b'0' COMMENT '0-댓글허용,1-댓글불가(게시물당선택가능)',
	`isDelete` BIT(1) NOT NULL DEFAULT b'0' COMMENT '0-미삭제,1-삭제',
	PRIMARY KEY (`seq`),
	UNIQUE INDEX `seq_bm_seq_isNotice_isComment_isDelete` (`seq`, `bm_seq`, `isNotice`, `isDelete`)
)
ENGINE=InnoDB
;

CREATE TABLE `attachments` (
	`seq` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`bm_seq` BIGINT(20) NOT NULL DEFAULT '0' COMMENT '게시판번호',
	`a_seq` BIGINT(20) NOT NULL DEFAULT '0' COMMENT '게시물번호',
	`filename` VARCHAR(255) NOT NULL DEFAULT '0',
	`filesize` BIGINT(20) NOT NULL DEFAULT '0',
	`download` INT(11) NULL DEFAULT NULL,
	`save_path` VARCHAR(255) NULL DEFAULT NULL,
	`save_name` VARCHAR(255) NULL DEFAULT NULL,
	`contentType` VARCHAR(255) NULL DEFAULT NULL,
	PRIMARY KEY (`seq`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;




