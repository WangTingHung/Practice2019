CREATE DATABASE  IF NOT EXISTS `work` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */;
USE `work`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: work
-- ------------------------------------------------------
-- Server version	5.7.19-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `seq` int(10) NOT NULL AUTO_INCREMENT,
  `parent_seq` int(10) DEFAULT NULL,
  `name` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `status` tinyint(2) DEFAULT '1',
  PRIMARY KEY (`seq`),
  KEY `category_parent_FK_idx` (`parent_seq`),
  CONSTRAINT `category_parent_FK` FOREIGN KEY (`parent_seq`) REFERENCES `category` (`seq`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=152 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='工作類別';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `company` (
  `seq` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '公司名稱',
  `region_seq` int(10) DEFAULT NULL COMMENT '公司地區',
  `status` tinyint(2) DEFAULT '1',
  `update_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`seq`),
  KEY `company_region_FK_idx` (`region_seq`),
  CONSTRAINT `company_region_FK` FOREIGN KEY (`region_seq`) REFERENCES `region` (`seq`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1548 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='公司';
/*!40101 SET character_set_client = @saved_cs_client */;


DROP TABLE IF EXISTS `job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `job` (
  `seq` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `job_date` timestamp NULL DEFAULT '0000-00-00 00:00:00',
  `company_seq` int(10) DEFAULT NULL,
  `region_seq` int(10) DEFAULT NULL,
  `address` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `salary_height` int(10) DEFAULT '0',
  `salary_low` int(10) DEFAULT '0',
  `job_url` varchar(3072) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `experience` int(4) DEFAULT '0',
  `status` tinyint(2) DEFAULT '1',
  `update_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`seq`),
  KEY `jo_region_FK_idx` (`region_seq`),
  KEY `job_company_FK_idx` (`company_seq`),
  CONSTRAINT `job_company_FK` FOREIGN KEY (`company_seq`) REFERENCES `company` (`seq`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `job_region_FK` FOREIGN KEY (`region_seq`) REFERENCES `region` (`seq`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3549 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='職缺';
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `job_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `job_category` (
  `seq` int(10) NOT NULL AUTO_INCREMENT,
  `job_seq` int(10) NOT NULL,
  `category_seq` int(10) NOT NULL,
  PRIMARY KEY (`seq`),
  KEY `job_category_FK_idx` (`category_seq`),
  KEY `category_job_FK_idx` (`job_seq`),
  CONSTRAINT `category_job_FK` FOREIGN KEY (`job_seq`) REFERENCES `job` (`seq`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `job_category_FK` FOREIGN KEY (`category_seq`) REFERENCES `category` (`seq`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7696 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='職缺類別';
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `job_skill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `job_skill` (
  `seq` int(10) NOT NULL AUTO_INCREMENT,
  `job_seq` int(10) NOT NULL,
  `skill_seq` int(10) NOT NULL,
  PRIMARY KEY (`seq`),
  KEY `job_skill_FK_idx` (`skill_seq`),
  KEY `skill_job_FK_idx` (`job_seq`),
  CONSTRAINT `job_skill_FK` FOREIGN KEY (`skill_seq`) REFERENCES `skill` (`seq`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `skill_job_FK` FOREIGN KEY (`job_seq`) REFERENCES `job` (`seq`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=14205 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='職缺技術';
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `member` (
  `seq` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `phone` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`seq`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;


DROP TABLE IF EXISTS `member_job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `member_job` (
  `seq` int(10) NOT NULL AUTO_INCREMENT,
  `member_seq` int(10) DEFAULT NULL,
  `job_seq` int(10) DEFAULT NULL,
  PRIMARY KEY (`seq`),
  KEY `member_job_member_idx` (`member_seq`),
  KEY `member_job_job_FK_idx` (`job_seq`),
  CONSTRAINT `member_job_job_FK` FOREIGN KEY (`job_seq`) REFERENCES `job` (`seq`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `member_job_member_FK` FOREIGN KEY (`member_seq`) REFERENCES `member` (`seq`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `region`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `region` (
  `seq` int(5) NOT NULL AUTO_INCREMENT,
  `parent_seq` int(5) DEFAULT NULL,
  `region_type` tinyint(2) NOT NULL,
  `name` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `area_code` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `status` tinyint(2) NOT NULL,
  PRIMARY KEY (`seq`),
  KEY `region_parentSeq_idx` (`parent_seq`),
  CONSTRAINT `region_parentSeq` FOREIGN KEY (`parent_seq`) REFERENCES `region` (`seq`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=411 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `skill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `skill` (
  `seq` int(10) NOT NULL AUTO_INCREMENT,
  `parent_seq` int(10) DEFAULT NULL,
  `name` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `status` tinyint(2) DEFAULT '1',
  PRIMARY KEY (`seq`),
  KEY `skill_parent_FK_idx` (`parent_seq`),
  CONSTRAINT `skill_parent_FK` FOREIGN KEY (`parent_seq`) REFERENCES `skill` (`seq`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=298 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='技術';
/*!40101 SET character_set_client = @saved_cs_client */;


/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-10-31 17:02:42
