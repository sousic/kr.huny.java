-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        10.1.13-MariaDB - mariadb.org binary distribution
-- 서버 OS:                        Win32
-- HeidiSQL 버전:                  9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- kr.huny 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `kr.huny` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `kr.huny`;


-- 테이블 kr.huny.article 구조 내보내기
CREATE TABLE `article` (
  `seq` bigint(20) NOT NULL AUTO_INCREMENT,
  `category` bigint(20) NOT NULL DEFAULT '0',
  `title` varchar(250) NOT NULL DEFAULT '0',
  `contents` mediumtext,
  PRIMARY KEY (`seq`,`category`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- 내보낼 데이터가 선택되어 있지 않습니다.


-- 테이블 kr.huny.category 구조 내보내기
CREATE TABLE `category` (
  `seq` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) NOT NULL COMMENT '카테고리 코드',
  `writable` tinyint(4) unsigned NOT NULL DEFAULT '1' COMMENT '게시물 작성 제어 : 1-가능,0-불가능',
  `enabled` tinyint(4) unsigned NOT NULL DEFAULT '1' COMMENT '카테고리사용 유무 : 1-사용,0-미사용 ( 삭제 기능 대용 )',
  `level` int(11) NOT NULL COMMENT '카테고리 레벨',
  `sortOrder` int(11) NOT NULL COMMENT '카테고리별 소팅 순서',
  `parentCode` varchar(20) DEFAULT NULL COMMENT '자식 카테고리의 경우 부모 카테고리 정보 저장',
  `createDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `lastUpdate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`code`),
  UNIQUE KEY `seq` (`seq`),
  KEY `parentCode` (`parentCode`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;



-- 내보낼 데이터가 선택되어 있지 않습니다.


-- 테이블 kr.huny.user 구조 내보내기
CREATE TABLE `user` (
  `seq` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '일련번호',
  `userid` varchar(50) NOT NULL COMMENT '아이디',
  `password` varchar(100) NOT NULL COMMENT '비밀번호',
  `name` varchar(50) NOT NULL COMMENT '닉네임',
  `reg_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '등록일',
  `grade` tinyint(4) unsigned DEFAULT '1' COMMENT '회원등급값',
  PRIMARY KEY (`seq`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;



CREATE TABLE `grade` (
  `gradeCode` tinyint(3) unsigned NOT NULL,
  `gradeName` varchar(50) DEFAULT NULL,
  `regdate` timestamp(6) NULL DEFAULT NULL,
  `desc` varchar(200) NOT NULL,
  PRIMARY KEY (`gradeCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- 내보낼 데이터가 선택되어 있지 않습니다.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
