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


-- 테이블 kr.huny.user 구조 내보내기
CREATE TABLE IF NOT EXISTS `user` (
  `seq` bigint(20) DEFAULT NULL COMMENT '일련번호',
  `userid` varchar(50) NOT NULL COMMENT '아이디',
  `password` varchar(100) NOT NULL COMMENT '비밀번호',
  `name` varchar(50) NOT NULL COMMENT '닉네임',
  `reg_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '등록일'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 kr.huny.user:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
