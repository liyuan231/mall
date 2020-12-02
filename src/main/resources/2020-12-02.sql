-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: mall
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `mall_ad`
--

DROP TABLE IF EXISTS `mall_ad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mall_ad` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `link` varchar(200) DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL,
  `position` int DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=159 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mall_ad`
--

LOCK TABLES `mall_ad` WRITE;
/*!40000 ALTER TABLE `mall_ad` DISABLE KEYS */;
INSERT INTO `mall_ad` VALUES (6,'标题100','link1001','url100',-11,'内容1001','2020-12-04 08:58:59','2020-12-10 08:58:59'),(7,'标题100','link100','url100',-1,'内容100','2020-11-21 08:59:42','2020-11-21 08:59:42'),(8,'标题100','link100','url100',-1,'内容100','2020-11-21 09:00:19','2020-11-21 09:00:19'),(9,'标题100','link100','url100',-1,'内容100','2020-11-21 09:01:06','2020-11-21 09:01:06'),(10,'标题','link','url',1,'content',NULL,NULL),(11,'标题','link','url',1,'content',NULL,NULL),(12,'标题100','link100','url100',-1,'内容100','2020-11-21 09:04:05','2020-11-21 09:04:05'),(13,'标题100','link100','url100',-1,'内容100','2020-11-21 09:06:29','2020-11-21 09:06:29'),(14,'标题100','link100','url100',-1,'内容100','2020-11-21 09:09:02','2020-11-21 09:09:02'),(15,'标题101','link101','url101',-1,'内容101','2020-11-21 09:09:03','2020-11-21 09:09:03'),(16,'标题102','link102','url102',-1,'内容102','2020-11-21 09:09:03','2020-11-21 09:09:03'),(17,'标题103','link103','url103',-1,'内容103','2020-11-21 09:09:03','2020-11-21 09:09:03'),(18,'标题104','link104','url104',-1,'内容104','2020-11-21 09:09:03','2020-11-21 09:09:03'),(19,'标题105','link105','url105',-1,'内容105','2020-11-21 09:09:03','2020-11-21 09:09:03'),(20,'标题106','link106','url106',-1,'内容106','2020-11-21 09:09:03','2020-11-21 09:09:03'),(21,'标题107','link107','url107',-1,'内容107','2020-11-21 09:09:03','2020-11-21 09:09:03'),(22,'标题108','link108','url108',-1,'内容108','2020-11-21 09:09:04','2020-11-21 09:09:04'),(23,'标题109','link109','url109',-1,'内容109','2020-11-21 09:09:04','2020-11-21 09:09:04'),(24,'标题110','link110','url110',-1,'内容110','2020-11-21 09:09:04','2020-11-21 09:09:04'),(25,'标题111','link111','url111',-1,'内容111','2020-11-21 09:09:04','2020-11-21 09:09:04'),(26,'标题112','link112','url112',-1,'内容112','2020-11-21 09:09:04','2020-11-21 09:09:04'),(27,'标题113','link113','url113',-1,'内容113','2020-11-21 09:09:04','2020-11-21 09:09:04'),(28,'标题114','link114','url114',-1,'内容114','2020-11-21 09:09:04','2020-11-21 09:09:04'),(29,'标题115','link115','url115',-1,'内容115','2020-11-21 09:09:04','2020-11-21 09:09:04'),(30,'标题116','link116','url116',-1,'内容116','2020-11-21 09:09:05','2020-11-21 09:09:05'),(31,'标题117','link117','url117',-1,'内容117','2020-11-21 09:09:05','2020-11-21 09:09:05'),(32,'标题118','link118','url118',-1,'内容118','2020-11-21 09:09:05','2020-11-21 09:09:05'),(33,'标题119','link119','url119',-1,'内容119','2020-11-21 09:09:05','2020-11-21 09:09:05'),(34,'标题120','link120','url120',-1,'内容120','2020-11-21 09:09:05','2020-11-21 09:09:05'),(35,'标题121','link121','url121',-1,'内容121','2020-11-21 09:09:05','2020-11-21 09:09:05'),(36,'标题122','link122','url122',-1,'内容122','2020-11-21 09:09:05','2020-11-21 09:09:05'),(37,'标题123','link123','url123',-1,'内容123','2020-11-21 09:09:05','2020-11-21 09:09:05'),(38,'标题124','link124','url124',-1,'内容124','2020-11-21 09:09:05','2020-11-21 09:09:05'),(39,'标题125','link125','url125',-1,'内容125','2020-11-21 09:09:05','2020-11-21 09:09:05'),(40,'标题126','link126','url126',-1,'内容126','2020-11-21 09:09:05','2020-11-21 09:09:05'),(41,'标题127','link127','url127',-1,'内容127','2020-11-21 09:09:06','2020-11-21 09:09:06'),(42,'标题128','link128','url128',-1,'内容128','2020-11-21 09:09:06','2020-11-21 09:09:06'),(43,'标题129','link129','url129',-1,'内容129','2020-11-21 09:09:06','2020-11-21 09:09:06'),(44,'标题130','link130','url130',-1,'内容130','2020-11-21 09:09:06','2020-11-21 09:09:06'),(45,'标题131','link131','url131',-1,'内容131','2020-11-21 09:09:06','2020-11-21 09:09:06'),(46,'标题132','link132','url132',-1,'内容132','2020-11-21 09:09:06','2020-11-21 09:09:06'),(47,'标题133','link133','url133',-1,'内容133','2020-11-21 09:09:06','2020-11-21 09:09:06'),(48,'标题134','link134','url134',-1,'内容134','2020-11-21 09:09:06','2020-11-21 09:09:06'),(49,'标题135','link135','url135',-1,'内容135','2020-11-21 09:09:06','2020-11-21 09:09:06'),(50,'标题136','link136','url136',-1,'内容136','2020-11-21 09:09:07','2020-11-21 09:09:07'),(51,'标题137','link137','url137',-1,'内容137','2020-11-21 09:09:07','2020-11-21 09:09:07'),(52,'标题138','link138','url138',-1,'内容138','2020-11-21 09:09:07','2020-11-21 09:09:07'),(53,'标题139','link139','url139',-1,'内容139','2020-11-21 09:09:07','2020-11-21 09:09:07'),(54,'标题140','link140','url140',-1,'内容140','2020-11-21 09:09:07','2020-11-21 09:09:07'),(55,'标题141','link141','url141',-1,'内容141','2020-11-21 09:09:07','2020-11-21 09:09:07'),(56,'标题142','link142','url142',-1,'内容142','2020-11-21 09:09:07','2020-11-21 09:09:07'),(57,'标题143','link143','url143',-1,'内容143','2020-11-21 09:09:07','2020-11-21 09:09:07'),(58,'标题144','link144','url144',-1,'内容144','2020-11-21 09:09:07','2020-11-21 09:09:07'),(59,'标题145','link145','url145',-1,'内容145','2020-11-21 09:09:07','2020-11-21 09:09:07'),(60,'标题146','link146','url146',-1,'内容146','2020-11-21 09:09:08','2020-11-21 09:09:08'),(61,'标题147','link147','url147',-1,'内容147','2020-11-21 09:09:08','2020-11-21 09:09:08'),(62,'标题148','link148','url148',-1,'内容148','2020-11-21 09:09:08','2020-11-21 09:09:08'),(63,'标题149','link149','url149',-1,'内容149','2020-11-21 09:09:08','2020-11-21 09:09:08'),(64,'标题150','link150','url150',-1,'内容150','2020-11-21 09:09:08','2020-11-21 09:09:08'),(65,'标题151','link151','url151',-1,'内容151','2020-11-21 09:09:08','2020-11-21 09:09:08'),(66,'标题152','link152','url152',-1,'内容152','2020-11-21 09:09:08','2020-11-21 09:09:08'),(67,'标题153','link153','url153',-1,'内容153','2020-11-21 09:09:08','2020-11-21 09:09:08'),(68,'标题154','link154','url154',-1,'内容154','2020-11-21 09:09:08','2020-11-21 09:09:08'),(69,'标题155','link155','url155',-1,'内容155','2020-11-21 09:09:08','2020-11-21 09:09:08'),(70,'标题156','link156','url156',-1,'内容156','2020-11-21 09:09:09','2020-11-21 09:09:09'),(71,'标题157','link157','url157',-1,'内容157','2020-11-21 09:09:09','2020-11-21 09:09:09'),(72,'标题158','link158','url158',-1,'内容158','2020-11-21 09:09:09','2020-11-21 09:09:09'),(73,'标题159','link159','url159',-1,'内容159','2020-11-21 09:09:09','2020-11-21 09:09:09'),(74,'标题160','link160','url160',-1,'内容160','2020-11-21 09:09:09','2020-11-21 09:09:09'),(75,'标题161','link161','url161',-1,'内容161','2020-11-21 09:09:09','2020-11-21 09:09:09'),(76,'标题162','link162','url162',-1,'内容162','2020-11-21 09:09:09','2020-11-21 09:09:09'),(77,'标题163','link163','url163',-1,'内容163','2020-11-21 09:09:09','2020-11-21 09:09:09'),(78,'标题164','link164','url164',-1,'内容164','2020-11-21 09:09:09','2020-11-21 09:09:09'),(79,'标题165','link165','url165',-1,'内容165','2020-11-21 09:09:09','2020-11-21 09:09:09'),(80,'标题166','link166','url166',-1,'内容166','2020-11-21 09:09:09','2020-11-21 09:09:09'),(81,'标题167','link167','url167',-1,'内容167','2020-11-21 09:09:10','2020-11-21 09:09:10'),(82,'标题168','link168','url168',-1,'内容168','2020-11-21 09:09:10','2020-11-21 09:09:10'),(83,'标题169','link169','url169',-1,'内容169','2020-11-21 09:09:10','2020-11-21 09:09:10'),(84,'标题170','link170','url170',-1,'内容170','2020-11-21 09:09:10','2020-11-21 09:09:10'),(85,'标题171','link171','url171',-1,'内容171','2020-11-21 09:09:10','2020-11-21 09:09:10'),(86,'标题172','link172','url172',-1,'内容172','2020-11-21 09:09:10','2020-11-21 09:09:10'),(87,'标题173','link173','url173',-1,'内容173','2020-11-21 09:09:10','2020-11-21 09:09:10'),(88,'标题174','link174','url174',-1,'内容174','2020-11-21 09:09:10','2020-11-21 09:09:10'),(89,'标题175','link175','url175',-1,'内容175','2020-11-21 09:09:10','2020-11-21 09:09:10'),(90,'标题176','link176','url176',-1,'内容176','2020-11-21 09:09:10','2020-11-21 09:09:10'),(91,'标题177','link177','url177',-1,'内容177','2020-11-21 09:09:10','2020-11-21 09:09:10'),(92,'标题178','link178','url178',-1,'内容178','2020-11-21 09:09:11','2020-11-21 09:09:11'),(93,'标题179','link179','url179',-1,'内容179','2020-11-21 09:09:11','2020-11-21 09:09:11'),(94,'标题180','link180','url180',-1,'内容180','2020-11-21 09:09:11','2020-11-21 09:09:11'),(95,'标题181','link181','url181',-1,'内容181','2020-11-21 09:09:11','2020-11-21 09:09:11'),(96,'标题182','link182','url182',-1,'内容182','2020-11-21 09:09:11','2020-11-21 09:09:11'),(97,'标题183','link183','url183',-1,'内容183','2020-11-21 09:09:11','2020-11-21 09:09:11'),(98,'标题184','link184','url184',-1,'内容184','2020-11-21 09:09:11','2020-11-21 09:09:11'),(99,'标题185','link185','url185',-1,'内容185','2020-11-21 09:09:11','2020-11-21 09:09:11'),(100,'标题186','link186','url186',-1,'内容186','2020-11-21 09:09:11','2020-11-21 09:09:11'),(101,'标题187','link187','url187',-1,'内容187','2020-11-21 09:09:11','2020-11-21 09:09:11'),(102,'标题188','link188','url188',-1,'内容188','2020-11-21 09:09:11','2020-11-21 09:09:11'),(103,'标题189','link189','url189',-1,'内容189','2020-11-21 09:09:11','2020-11-21 09:09:11'),(104,'标题190','link190','url190',-1,'内容190','2020-11-21 09:09:12','2020-11-21 09:09:12'),(105,'标题191','link191','url191',-1,'内容191','2020-11-21 09:09:12','2020-11-21 09:09:12'),(106,'标题192','link192','url192',-1,'内容192','2020-11-21 09:09:12','2020-11-21 09:09:12'),(107,'标题193','link193','url193',-1,'内容193','2020-11-21 09:09:12','2020-11-21 09:09:12'),(108,'标题194','link194','url194',-1,'内容194','2020-11-21 09:09:12','2020-11-21 09:09:12'),(109,'标题195','link195','url195',-1,'内容195','2020-11-21 09:09:12','2020-11-21 09:09:12'),(110,'标题196','link196','url196',-1,'内容196','2020-11-21 09:09:12','2020-11-21 09:09:12'),(111,'标题197','link197','url197',-1,'内容197','2020-11-21 09:09:12','2020-11-21 09:09:12'),(112,'标题198','link198','url198',-1,'内容198','2020-11-21 09:09:12','2020-11-21 09:09:12'),(113,'标题199','link199','url199',-1,'内容199','2020-11-21 09:09:12','2020-11-21 09:09:12'),(114,'标题200','link200','url200',-1,'内容200','2020-11-21 09:09:13','2020-11-21 09:09:13'),(115,'标题201','link201','url201',-1,'内容201','2020-11-21 09:09:13','2020-11-21 09:09:13'),(116,'标题202','link202','url202',-1,'内容202','2020-11-21 09:09:13','2020-11-21 09:09:13'),(117,'标题203','link203','url203',-1,'内容203','2020-11-21 09:09:13','2020-11-21 09:09:13'),(118,'标题204','link204','url204',-1,'内容204','2020-11-21 09:09:13','2020-11-21 09:09:13'),(119,'标题205','link205','url205',-1,'内容205','2020-11-21 09:09:13','2020-11-21 09:09:13'),(120,'标题206','link206','url206',-1,'内容206','2020-11-21 09:09:13','2020-11-21 09:09:13'),(121,'标题207','link207','url207',-1,'内容207','2020-11-21 09:09:13','2020-11-21 09:09:13'),(122,'标题208','link208','url208',-1,'内容208','2020-11-21 09:09:13','2020-11-21 09:09:13'),(123,'标题209','link209','url209',-1,'内容209','2020-11-21 09:09:13','2020-11-21 09:09:13'),(124,'标题210','link210','url210',-1,'内容210','2020-11-21 09:09:13','2020-11-21 09:09:13'),(125,'标题211','link211','url211',-1,'内容211','2020-11-21 09:09:13','2020-11-21 09:09:13'),(126,'标题212','link212','url212',-1,'内容212','2020-11-21 09:09:14','2020-11-21 09:09:14'),(127,'标题213','link213','url213',-1,'内容213','2020-11-21 09:09:14','2020-11-21 09:09:14'),(128,'标题214','link214','url214',-1,'内容214','2020-11-21 09:09:14','2020-11-21 09:09:14'),(129,'标题215','link215','url215',-1,'内容215','2020-11-21 09:09:14','2020-11-21 09:09:14'),(130,'标题216','link216','url216',-1,'内容216','2020-11-21 09:09:14','2020-11-21 09:09:14'),(131,'标题217','link217','url217',-1,'内容217','2020-11-21 09:09:14','2020-11-21 09:09:14'),(132,'标题218','link218','url218',-1,'内容218','2020-11-21 09:09:14','2020-11-21 09:09:14'),(133,'标题219','link219','url219',-1,'内容219','2020-11-21 09:09:14','2020-11-21 09:09:14'),(134,'标题220','link220','url220',-1,'内容220','2020-11-21 09:09:14','2020-11-21 09:09:14'),(135,'标题221','link221','url221',-1,'内容221','2020-11-21 09:09:14','2020-11-21 09:09:14'),(136,'标题222','link222','url222',-1,'内容222','2020-11-21 09:09:14','2020-11-21 09:09:14'),(137,'标题223','link223','url223',-1,'内容223','2020-11-21 09:09:15','2020-11-21 09:09:15'),(138,'标题224','link224','url224',-1,'内容224','2020-11-21 09:09:15','2020-11-21 09:09:15'),(139,'标题225','link225','url225',-1,'内容225','2020-11-21 09:09:15','2020-11-21 09:09:15'),(140,'标题226','link226','url226',-1,'内容226','2020-11-21 09:09:15','2020-11-21 09:09:15'),(141,'标题227','link227','url227',-1,'内容227','2020-11-21 09:09:15','2020-11-21 09:09:15'),(142,'标题228','link228','url228',-1,'内容228','2020-11-21 09:09:15','2020-11-21 09:09:15'),(143,'标题229','link229','url229',-1,'内容229','2020-11-21 09:09:15','2020-11-21 09:09:15'),(144,'标题230','link230','url230',-1,'内容230','2020-11-21 09:09:15','2020-11-21 09:09:15'),(145,'标题231','link231','url231',-1,'内容231','2020-11-21 09:09:15','2020-11-21 09:09:15'),(146,'标题232','link232','url232',-1,'内容232','2020-11-21 09:09:15','2020-11-21 09:09:15'),(147,'标题233','link233','url233',-1,'内容233','2020-11-21 09:09:15','2020-11-21 09:09:15'),(148,'标题234','link234','url234',-1,'内容234','2020-11-21 09:09:16','2020-11-21 09:09:16'),(149,'标题235','link235','url235',-1,'内容235','2020-11-21 09:09:16','2020-11-21 09:09:16'),(150,'标题236','link236','url236',-1,'内容236','2020-11-21 09:09:16','2020-11-21 09:09:16'),(151,'标题237','link237','url237',-1,'内容237','2020-11-21 09:09:16','2020-11-21 09:09:16'),(152,'标题238','link238','url238',-1,'内容238','2020-11-21 09:09:16','2020-11-21 09:09:16'),(153,'标题239','link239','url239',-1,'内容239','2020-11-21 09:09:16','2020-11-21 09:09:16'),(154,'标题240','link240','url240',-1,'内容240','2020-11-21 09:09:16','2020-11-21 09:09:16'),(155,'标题241','link241','url241',-1,'内容241','2020-11-21 09:09:16','2020-11-21 09:09:16'),(156,'标题242','link242','url242',-1,'内容242','2020-11-21 09:09:16','2020-11-21 09:09:16'),(157,'标题243','link243','url243',-1,'内容243','2020-11-21 09:09:16','2020-11-21 09:09:16'),(158,'标题244','link244','url244',-1,'内容244','2020-11-21 09:09:17','2020-11-21 09:09:17');
/*!40000 ALTER TABLE `mall_ad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mall_address`
--

DROP TABLE IF EXISTS `mall_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mall_address` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `address_detail` varchar(200) DEFAULT NULL,
  `mobile` varchar(200) DEFAULT NULL,
  `name` varchar(200) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `mall_address_mall_user_id_fk` (`user_id`),
  CONSTRAINT `mall_address_mall_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `mall_user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=125 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mall_address`
--

LOCK TABLES `mall_address` WRITE;
/*!40000 ALTER TABLE `mall_address` DISABLE KEYS */;
INSERT INTO `mall_address` VALUES (122,115,'广东省广州市番禺区','18719138325','元夕1','2020-12-01 21:26:46'),(124,115,'广东省广州市黄埔区','18719138325','李源','2020-12-01 21:50:20');
/*!40000 ALTER TABLE `mall_address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mall_admin`
--

DROP TABLE IF EXISTS `mall_admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mall_admin` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(200) DEFAULT NULL,
  `password` varchar(200) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `role` int DEFAULT NULL,
  `avatar` varchar(200) DEFAULT NULL,
  `last_login_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `mall_admin_mall_role_id_fk` (`role`),
  CONSTRAINT `mall_admin_mall_role_id_fk` FOREIGN KEY (`role`) REFERENCES `mall_role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mall_admin`
--

LOCK TABLES `mall_admin` WRITE;
/*!40000 ALTER TABLE `mall_admin` DISABLE KEYS */;
/*!40000 ALTER TABLE `mall_admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mall_cart`
--

DROP TABLE IF EXISTS `mall_cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mall_cart` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `brand_id` int DEFAULT NULL,
  `number` int DEFAULT NULL,
  `checked` tinyint(1) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `goods_id` int DEFAULT NULL,
  `finished` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `mall_cart_mall_user_id_fk` (`user_id`),
  KEY `mall_cart_mall_goods_id_fk` (`goods_id`),
  CONSTRAINT `mall_cart_mall_goods_id_fk` FOREIGN KEY (`goods_id`) REFERENCES `mall_goods` (`id`) ON DELETE CASCADE,
  CONSTRAINT `mall_cart_mall_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `mall_user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=372 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mall_cart`
--

LOCK TABLES `mall_cart` WRITE;
/*!40000 ALTER TABLE `mall_cart` DISABLE KEYS */;
INSERT INTO `mall_cart` VALUES (366,115,NULL,1,0,'2020-12-01 22:28:00',65,1),(367,115,NULL,1,0,'2020-12-01 22:28:00',61,1),(368,115,NULL,1,0,'2020-12-01 23:08:41',58,1),(369,115,NULL,1,0,'2020-12-01 23:15:19',60,1),(370,115,NULL,1,0,'2020-12-01 23:15:19',66,1),(371,115,115,1,0,'2020-12-01 23:25:00',65,0);
/*!40000 ALTER TABLE `mall_cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mall_category`
--

DROP TABLE IF EXISTS `mall_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mall_category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `pid` int DEFAULT NULL,
  `desc` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `keywords` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mall_category`
--

LOCK TABLES `mall_category` WRITE;
/*!40000 ALTER TABLE `mall_category` DISABLE KEYS */;
INSERT INTO `mall_category` VALUES (1,'衣服',-1,'desc','2020-11-23 12:27:56','关键字'),(2,'手机',-1,'desc','2020-11-23 12:27:57','关键字'),(3,'书籍',-1,'desc','2020-11-23 12:27:59','关键字');
/*!40000 ALTER TABLE `mall_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mall_feedback`
--

DROP TABLE IF EXISTS `mall_feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mall_feedback` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `title` varchar(200) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `content` text COMMENT '此处为富文本形式',
  PRIMARY KEY (`id`),
  KEY `mall_feedback_mall_user_id_fk` (`user_id`),
  CONSTRAINT `mall_feedback_mall_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `mall_user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mall_feedback`
--

LOCK TABLES `mall_feedback` WRITE;
/*!40000 ALTER TABLE `mall_feedback` DISABLE KEYS */;
INSERT INTO `mall_feedback` VALUES (1,36,'title0','2020-11-19 20:09:29','content0'),(2,33,'title1','2020-11-19 20:09:29','content1'),(3,28,'title2','2020-11-19 20:09:29','content2'),(4,71,'title3','2020-11-19 20:09:29','content3'),(5,78,'title4','2020-11-19 20:09:29','content4'),(6,44,'title5','2020-11-19 20:09:29','content5'),(7,37,'title6','2020-11-19 20:09:29','content6'),(8,61,'title7','2020-11-19 20:09:29','content7'),(9,65,'title8','2020-11-19 20:09:29','content8'),(10,111,'title9','2020-11-19 20:09:30','content9'),(11,56,'title10','2020-11-19 20:09:30','content10'),(12,52,'title11','2020-11-19 20:09:30','content11'),(13,81,'title12','2020-11-19 20:09:30','content12'),(14,29,'title13','2020-11-19 20:09:30','content13'),(15,41,'title14','2020-11-19 20:09:30','content14'),(16,39,'title15','2020-11-19 20:09:30','content15'),(17,70,'title16','2020-11-19 20:09:30','content16'),(18,66,'title17','2020-11-19 20:09:31','content17'),(19,86,'title18','2020-11-19 20:09:31','content18'),(20,38,'title19','2020-11-19 20:09:31','content19'),(21,60,'title20','2020-11-19 20:09:31','content20'),(22,95,'title21','2020-11-19 20:09:31','content21'),(23,96,'title22','2020-11-19 20:09:31','content22'),(24,58,'title23','2020-11-19 20:09:31','content23'),(25,59,'title24','2020-11-19 20:09:31','content24'),(26,59,'title25','2020-11-19 20:09:31','content25'),(27,102,'title26','2020-11-19 20:09:31','content26'),(28,60,'title27','2020-11-19 20:09:31','content27'),(29,72,'title28','2020-11-19 20:09:32','content28'),(30,53,'title29','2020-11-19 20:09:32','content29'),(31,61,'title30','2020-11-19 20:09:32','content30'),(32,70,'title31','2020-11-19 20:09:32','content31'),(33,86,'title32','2020-11-19 20:09:32','content32'),(34,37,'title33','2020-11-19 20:09:32','content33'),(35,32,'title34','2020-11-19 20:09:32','content34'),(36,37,'title35','2020-11-19 20:09:32','content35'),(37,60,'title36','2020-11-19 20:09:32','content36'),(38,48,'title37','2020-11-19 20:09:32','content37'),(39,75,'title38','2020-11-19 20:09:33','content38'),(40,91,'title39','2020-11-19 20:09:33','content39'),(41,94,'title40','2020-11-19 20:09:33','content40'),(42,85,'title41','2020-11-19 20:09:33','content41'),(43,79,'title42','2020-11-19 20:09:33','content42'),(44,53,'title43','2020-11-19 20:09:33','content43'),(45,68,'title44','2020-11-19 20:09:33','content44'),(46,102,'title45','2020-11-19 20:09:33','content45'),(47,41,'title46','2020-11-19 20:09:33','content46'),(48,78,'title47','2020-11-19 20:09:33','content47'),(49,111,'title48','2020-11-19 20:09:34','content48'),(50,32,'title49','2020-11-19 20:09:34','content49'),(51,63,'title50','2020-11-19 20:09:34','content50'),(52,78,'title51','2020-11-19 20:09:34','content51'),(53,88,'title52','2020-11-19 20:09:34','content52'),(54,90,'title53','2020-11-19 20:09:34','content53'),(55,42,'title54','2020-11-19 20:09:34','content54'),(56,80,'title55','2020-11-19 20:09:34','content55'),(57,62,'title56','2020-11-19 20:09:34','content56'),(58,57,'title57','2020-11-19 20:09:34','content57'),(59,80,'title58','2020-11-19 20:09:34','content58'),(60,63,'title59','2020-11-19 20:09:35','content59'),(61,99,'title60','2020-11-19 20:09:35','content60'),(62,99,'title61','2020-11-19 20:09:35','content61'),(63,66,'title62','2020-11-19 20:09:35','content62'),(64,66,'title63','2020-11-19 20:09:35','content63'),(65,90,'title64','2020-11-19 20:09:35','content64'),(66,84,'title65','2020-11-19 20:09:35','content65'),(67,25,'title66','2020-11-19 20:09:35','content66'),(68,65,'title67','2020-11-19 20:09:35','content67'),(69,44,'title68','2020-11-19 20:09:35','content68'),(70,74,'title69','2020-11-19 20:09:35','content69'),(71,66,'title70','2020-11-19 20:09:35','content70'),(72,31,'title71','2020-11-19 20:09:36','content71'),(73,58,'title72','2020-11-19 20:09:36','content72'),(74,32,'title73','2020-11-19 20:09:36','content73'),(75,35,'title74','2020-11-19 20:09:36','content74'),(76,108,'title75','2020-11-19 20:09:36','content75'),(77,96,'title76','2020-11-19 20:09:36','content76'),(78,52,'title77','2020-11-19 20:09:36','content77'),(79,38,'title78','2020-11-19 20:09:36','content78'),(80,60,'title79','2020-11-19 20:09:36','content79'),(81,63,'title80','2020-11-19 20:09:36','content80'),(82,71,'title81','2020-11-19 20:09:36','content81'),(83,110,'title82','2020-11-19 20:09:36','content82'),(84,51,'title83','2020-11-19 20:09:36','content83'),(85,88,'title84','2020-11-19 20:09:37','content84'),(86,91,'title85','2020-11-19 20:09:37','content85'),(87,76,'title86','2020-11-19 20:09:37','content86'),(88,48,'title87','2020-11-19 20:09:37','content87'),(89,99,'title88','2020-11-19 20:09:37','content88'),(90,94,'title89','2020-11-19 20:09:37','content89'),(91,53,'title90','2020-11-19 20:09:37','content90'),(92,77,'title91','2020-11-19 20:09:38','content91'),(93,81,'title92','2020-11-19 20:09:38','content92'),(94,93,'title93','2020-11-19 20:09:38','content93'),(95,48,'title94','2020-11-19 20:09:38','content94'),(96,74,'title95','2020-11-19 20:09:38','content95'),(97,75,'title96','2020-11-19 20:09:38','content96'),(98,96,'title97','2020-11-19 20:09:38','content97'),(99,66,'title98','2020-11-19 20:09:38','content98'),(100,83,'title99','2020-11-19 20:09:38','content99');
/*!40000 ALTER TABLE `mall_feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mall_goods`
--

DROP TABLE IF EXISTS `mall_goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mall_goods` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `primary_image` varchar(200) DEFAULT NULL,
  `brand_id` int DEFAULT NULL COMMENT '商家的id，也是用户的id\n',
  `keywords` varchar(200) DEFAULT NULL,
  `brief` varchar(255) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `detail` text,
  `update_time` datetime DEFAULT NULL,
  `category_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `mall_goods_mall_category_id_fk` (`category_id`),
  KEY `mall_goods_mall_user_id_fk` (`brand_id`),
  CONSTRAINT `mall_goods_mall_category_id_fk` FOREIGN KEY (`category_id`) REFERENCES `mall_category` (`id`),
  CONSTRAINT `mall_goods_mall_user_id_fk` FOREIGN KEY (`brand_id`) REFERENCES `mall_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mall_goods`
--

LOCK TABLES `mall_goods` WRITE;
/*!40000 ALTER TABLE `mall_goods` DISABLE KEYS */;
INSERT INTO `mall_goods` VALUES (57,'李源',NULL,115,'123','1234',1234,'<p>12334</p>\r\n<p>元夕</p>','2020-11-30 23:05:18',1),(58,'小米笔记本电脑',NULL,115,'电脑','小米笔记本',9000,'<p>小米笔记本就是好用！！！</p>','2020-12-01 12:56:38',2),(59,'1',NULL,115,'3','3',22,'','2020-12-01 12:57:34',1),(60,'李源','https://mall-1300780430.cos.ap-nanjing.myqcloud.com//images/1e1b3734-834c-46dd-b023-f9b43373fe0c.png',115,'123','1234',222,'<p>描述</p>','2020-12-01 12:59:31',3),(61,'zzz','https://mall-1300780430.cos.ap-nanjing.myqcloud.com//images/16645c6c-df0f-4dff-bf4c-4365d7140afd.png',115,'sss','ddd',22222,'<p>wwww</p>','2020-12-01 13:01:12',2),(65,'这不是小米笔记本','https://mall-1300780430.cos.ap-nanjing.myqcloud.com//images/af08a85d-4ec7-41c1-9129-6d4873d6d3e3.PNG',115,'笔记本','笔记本',900,'<p>小米笔记本就是好用，我喜欢！！也许喜欢吧！</p>','2020-12-01 18:10:41',2),(66,'111222','https://mall-1300780430.cos.ap-nanjing.myqcloud.com//images/40a10ff5-4edb-49ee-bb89-50b25b4a26c1.PNG',115,'222','333',444,'<p>5555</p>','2020-12-01 17:11:41',1);
/*!40000 ALTER TABLE `mall_goods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mall_issue`
--

DROP TABLE IF EXISTS `mall_issue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mall_issue` (
  `id` int NOT NULL AUTO_INCREMENT,
  `question` varchar(255) DEFAULT NULL,
  `answer` text,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mall_issue`
--

LOCK TABLES `mall_issue` WRITE;
/*!40000 ALTER TABLE `mall_issue` DISABLE KEYS */;
INSERT INTO `mall_issue` VALUES (1,'q1','<b>test</b>cccc','2020-11-25 14:35:43'),(2,'question1','answer1','2020-11-20 22:24:38'),(3,'question2','answer2','2020-11-20 22:24:38'),(4,'question3','answer3','2020-11-20 22:24:38'),(5,'question4','answer4','2020-11-20 22:24:38'),(6,'question5','answer5','2020-11-20 22:24:38'),(7,'question6','answer6','2020-11-20 22:24:39'),(8,'question7','answer7','2020-11-20 22:24:39'),(9,'question8','answer8','2020-11-20 22:24:39'),(10,'question9','answer9','2020-11-20 22:40:33'),(11,'question10','answer10','2020-11-20 22:24:39'),(12,'question11','answer11','2020-11-20 22:24:39'),(13,'question12','answer12','2020-11-20 22:24:39'),(14,'question13','answer13','2020-11-20 22:24:39'),(15,'question14','answer14','2020-11-20 22:24:39'),(16,'question15','answer15','2020-11-20 22:24:39'),(17,'question16','answer16','2020-11-20 22:24:39'),(18,'question17','answer17','2020-11-20 22:24:40'),(19,'question18','answer18','2020-11-20 22:24:40'),(20,'question19','answer19','2020-11-20 22:24:40'),(21,'question20','answer20','2020-11-20 22:24:40'),(22,'question21','answer21','2020-11-20 22:24:40'),(23,'question22','answer22','2020-11-20 22:24:40'),(24,'question23','answer23','2020-11-20 22:24:40'),(25,'question24','answer24','2020-11-20 22:24:41'),(26,'question25','answer25','2020-11-20 22:24:41'),(27,'question26','answer26','2020-11-20 22:24:41'),(28,'question27','answer27','2020-11-20 22:24:41'),(29,'question28','answer28','2020-11-20 22:24:41'),(30,'question29','answer29','2020-11-20 22:24:41'),(31,'question30','answer30','2020-11-20 22:24:42'),(32,'question31','answer31','2020-11-20 22:24:42'),(33,'question32','answer32','2020-11-20 22:24:42'),(34,'question33','answer33','2020-11-20 22:24:42'),(35,'question0','answer011','2020-11-20 22:37:09'),(36,'question0z','answer0z','2020-11-20 22:37:19'),(37,'question0z','answer0z','2020-11-20 22:37:35'),(38,'question0zssss','answer0zsss','2020-11-20 22:40:40');
/*!40000 ALTER TABLE `mall_issue` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mall_order`
--

DROP TABLE IF EXISTS `mall_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mall_order` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `order_status` int DEFAULT NULL,
  `aftersale_status` int DEFAULT NULL,
  `address_id` int DEFAULT NULL,
  `goods_price` float DEFAULT NULL,
  `pay_id` varchar(200) DEFAULT NULL,
  `pay_time` datetime DEFAULT NULL,
  `refund_amount` float DEFAULT NULL,
  `refund_type` int DEFAULT NULL,
  `refund_time` datetime DEFAULT NULL,
  `confirm_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `cart_ids` varchar(1023) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `mall_order_mall_user_id_fk` (`user_id`),
  KEY `mall_order_mall_address_id_fk` (`address_id`),
  CONSTRAINT `mall_order_mall_address_id_fk` FOREIGN KEY (`address_id`) REFERENCES `mall_address` (`id`) ON DELETE CASCADE,
  CONSTRAINT `mall_order_mall_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `mall_user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=95 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mall_order`
--

LOCK TABLES `mall_order` WRITE;
/*!40000 ALTER TABLE `mall_order` DISABLE KEYS */;
INSERT INTO `mall_order` VALUES (93,115,-1,-1,122,9000,NULL,NULL,NULL,NULL,NULL,NULL,'2020-12-01 23:08:41','[368]'),(94,115,-1,-1,122,666,NULL,NULL,NULL,NULL,NULL,NULL,'2020-12-01 23:15:19','[369,370]');
/*!40000 ALTER TABLE `mall_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mall_permission`
--

DROP TABLE IF EXISTS `mall_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mall_permission` (
  `id` int NOT NULL AUTO_INCREMENT,
  `role_id` int DEFAULT NULL,
  `permission` varchar(200) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `mall_permission_mall_user_role_fk` (`role_id`),
  CONSTRAINT `mall_permission_mall_user_role_fk` FOREIGN KEY (`role_id`) REFERENCES `mall_user` (`role`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mall_permission`
--

LOCK TABLES `mall_permission` WRITE;
/*!40000 ALTER TABLE `mall_permission` DISABLE KEYS */;
/*!40000 ALTER TABLE `mall_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mall_role`
--

DROP TABLE IF EXISTS `mall_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mall_role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `desc` text,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mall_role`
--

LOCK TABLES `mall_role` WRITE;
/*!40000 ALTER TABLE `mall_role` DISABLE KEYS */;
INSERT INTO `mall_role` VALUES (1,'ADMIN',NULL,NULL),(2,'USER',NULL,NULL);
/*!40000 ALTER TABLE `mall_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mall_search_history`
--

DROP TABLE IF EXISTS `mall_search_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mall_search_history` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `keyword` varchar(200) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `mall_search_history_mall_user_id_fk` (`user_id`),
  CONSTRAINT `mall_search_history_mall_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `mall_user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mall_search_history`
--

LOCK TABLES `mall_search_history` WRITE;
/*!40000 ALTER TABLE `mall_search_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `mall_search_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mall_storage`
--

DROP TABLE IF EXISTS `mall_storage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mall_storage` (
  `id` int NOT NULL AUTO_INCREMENT,
  `location` varchar(200) DEFAULT NULL COMMENT '对象存储相对位置',
  `type` int DEFAULT NULL,
  `target_id` int DEFAULT NULL COMMENT '目标的id，目标可以是商品...之类\n',
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `storage_user_fk` (`target_id`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mall_storage`
--

LOCK TABLES `mall_storage` WRITE;
/*!40000 ALTER TABLE `mall_storage` DISABLE KEYS */;
INSERT INTO `mall_storage` VALUES (46,'/images/1b2bb370-23ee-4767-8a9a-e214b8849e29.PNG',10,115,'2020-12-01 12:45:59'),(48,'/images/04f849d4-d715-49c0-b503-e111eb5be0da.PNG',10,-1,'2020-12-01 12:54:29'),(49,'/images/8636ef09-6742-4dcb-9330-c4b5127e0512.png',10,-1,'2020-12-01 12:56:23'),(50,'/images/29f8d764-59b9-4d29-b8c4-ca65af40be9a.png',10,-1,'2020-12-01 12:57:04'),(51,'/images/1e1b3734-834c-46dd-b023-f9b43373fe0c.png',10,-1,'2020-12-01 12:59:19'),(52,'/images/16645c6c-df0f-4dff-bf4c-4365d7140afd.png',10,-1,'2020-12-01 13:01:09'),(53,'/images/75467c58-836f-48fc-aa7b-206f63b7a159.png',10,-1,'2020-12-01 17:06:18'),(54,'/images/af08a85d-4ec7-41c1-9129-6d4873d6d3e3.PNG',10,-1,'2020-12-01 17:10:25'),(55,'/images/40a10ff5-4edb-49ee-bb89-50b25b4a26c1.PNG',10,-1,'2020-12-01 17:11:32');
/*!40000 ALTER TABLE `mall_storage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mall_system`
--

DROP TABLE IF EXISTS `mall_system`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mall_system` (
  `id` int NOT NULL AUTO_INCREMENT,
  `key` varchar(200) DEFAULT NULL,
  `value` varchar(200) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mall_system`
--

LOCK TABLES `mall_system` WRITE;
/*!40000 ALTER TABLE `mall_system` DISABLE KEYS */;
INSERT INTO `mall_system` VALUES (1,'111','111ac','2020-11-21 19:57:59'),(2,'222','222b','2020-11-21 19:58:03');
/*!40000 ALTER TABLE `mall_system` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mall_user`
--

DROP TABLE IF EXISTS `mall_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mall_user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(200) DEFAULT NULL,
  `mobile` varchar(200) DEFAULT NULL,
  `avatar` varchar(200) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `role` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `mall_user_username_uindex` (`username`),
  KEY `mall_user_mall_role_id_fk` (`role`),
  CONSTRAINT `mall_user_mall_role_id_fk` FOREIGN KEY (`role`) REFERENCES `mall_role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=116 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mall_user`
--

LOCK TABLES `mall_user` WRITE;
/*!40000 ALTER TABLE `mall_user` DISABLE KEYS */;
INSERT INTO `mall_user` VALUES (25,'12@qq.com',NULL,'1605753692050',NULL,'2020-11-19 10:41:32',2),(26,'13@qq.com',NULL,'1605753692147',NULL,'2020-11-19 10:41:32',2),(27,'14@qq.com',NULL,'1605753692208',NULL,'2020-11-19 10:41:32',2),(28,'15@qq.com',NULL,'1605753692281',NULL,'2020-11-19 10:41:32',2),(29,'16@qq.com',NULL,'1605753692360',NULL,'2020-11-19 10:41:32',2),(31,'18@qq.com',NULL,'1605753692517',NULL,'2020-11-19 10:41:33',2),(32,'19@qq.com',NULL,'1605753692581',NULL,'2020-11-19 10:41:33',2),(33,'20@qq.com',NULL,'1605753692659',NULL,'2020-11-19 10:41:33',2),(34,'21@qq.com',NULL,'1605753692751',NULL,'2020-11-19 10:41:33',2),(35,'22@qq.com',NULL,'1605753692825',NULL,'2020-11-19 10:41:33',2),(36,'23@qq.com',NULL,'1605753692880',NULL,'2020-11-19 10:41:33',2),(37,'24@qq.com',NULL,'1605753692943',NULL,'2020-11-19 10:41:33',2),(38,'25@qq.com',NULL,'1605753693024',NULL,'2020-11-19 10:41:33',2),(39,'26@qq.com',NULL,'1605753693098',NULL,'2020-11-19 10:41:33',2),(40,'27@qq.com',NULL,'1605753693158',NULL,'2020-11-19 10:41:33',2),(41,'28@qq.com',NULL,'1605753693239',NULL,'2020-11-19 10:41:33',2),(42,'29@qq.com',NULL,'1605753693683',NULL,'2020-11-19 10:41:34',2),(43,'30@qq.com',NULL,'1605753693834',NULL,'2020-11-19 10:41:34',2),(44,'31@qq.com',NULL,'1605753693939',NULL,'2020-11-19 10:41:34',2),(45,'32@qq.com',NULL,'1605753694039',NULL,'2020-11-19 10:41:34',2),(46,'33@qq.com',NULL,'1605753694109',NULL,'2020-11-19 10:41:34',2),(47,'34@qq.com',NULL,'1605753694189',NULL,'2020-11-19 10:41:34',2),(48,'35@qq.com',NULL,'1605753694283',NULL,'2020-11-19 10:41:34',2),(49,'36@qq.com',NULL,'1605753694364',NULL,'2020-11-19 10:41:34',2),(50,'37@qq.com',NULL,'1605753694455',NULL,'2020-11-19 10:41:34',2),(51,'38@qq.com',NULL,'1605753694555',NULL,'2020-11-19 10:41:35',2),(52,'39@qq.com',NULL,'1605753694655',NULL,'2020-11-19 10:41:35',2),(53,'40@qq.com',NULL,'1605753694733',NULL,'2020-11-19 10:41:35',2),(54,'41@qq.com',NULL,'1605753694797',NULL,'2020-11-19 10:41:35',2),(55,'42@qq.com',NULL,'1605753694869',NULL,'2020-11-19 10:41:35',2),(56,'43@qq.com',NULL,'1605753695008',NULL,'2020-11-19 10:41:35',2),(57,'44@qq.com',NULL,'1605753695089',NULL,'2020-11-19 10:41:35',2),(58,'45@qq.com',NULL,'1605753695169',NULL,'2020-11-19 10:41:35',2),(59,'46@qq.com',NULL,'1605753695240',NULL,'2020-11-19 10:41:35',2),(60,'47@qq.com',NULL,'1605753695495',NULL,'2020-11-19 10:41:35',2),(61,'48@qq.com',NULL,'1605753695698',NULL,'2020-11-19 10:41:36',2),(62,'49@qq.com',NULL,'1605753695762',NULL,'2020-11-19 10:41:36',2),(63,'50@qq.com',NULL,'1605753695856',NULL,'2020-11-19 10:41:36',2),(64,'51@qq.com',NULL,'1605753695927',NULL,'2020-11-19 10:41:36',2),(65,'52@qq.com',NULL,'1605753695988',NULL,'2020-11-19 10:41:36',2),(66,'53@qq.com',NULL,'1605753696069',NULL,'2020-11-19 10:41:36',2),(67,'54@qq.com',NULL,'1605753696140',NULL,'2020-11-19 10:41:36',2),(68,'55@qq.com',NULL,'1605753696215',NULL,'2020-11-19 10:41:36',2),(69,'56@qq.com',NULL,'1605753696281',NULL,'2020-11-19 10:41:36',2),(70,'57@qq.com',NULL,'1605753696360',NULL,'2020-11-19 10:41:36',2),(71,'58@qq.com',NULL,'1605753696455',NULL,'2020-11-19 10:41:36',2),(72,'59@qq.com',NULL,'1605753696527',NULL,'2020-11-19 10:41:37',2),(73,'60@qq.com',NULL,'1605753696589',NULL,'2020-11-19 10:41:37',2),(74,'61@qq.com',NULL,'1605753696661',NULL,'2020-11-19 10:41:37',2),(75,'62@qq.com',NULL,'1605753696756',NULL,'2020-11-19 10:41:37',2),(76,'63@qq.com',NULL,'1605753696827',NULL,'2020-11-19 10:41:37',2),(77,'64@qq.com',NULL,'1605753696889',NULL,'2020-11-19 10:41:37',2),(78,'65@qq.com',NULL,'1605753696961',NULL,'2020-11-19 10:41:37',2),(79,'66@qq.com',NULL,'1605753697038',NULL,'2020-11-19 10:41:37',2),(80,'67@qq.com',NULL,'1605753697127',NULL,'2020-11-19 10:41:37',2),(81,'68@qq.com',NULL,'1605753697189',NULL,'2020-11-19 10:41:37',2),(82,'69@qq.com',NULL,'1605753697306',NULL,'2020-11-19 10:41:37',2),(83,'70@qq.com',NULL,'1605753697380',NULL,'2020-11-19 10:41:37',2),(84,'71@qq.com',NULL,'1605753697453',NULL,'2020-11-19 10:41:37',2),(85,'72@qq.com',NULL,'1605753697545',NULL,'2020-11-19 10:41:38',2),(86,'73@qq.com',NULL,'1605753697625',NULL,'2020-11-19 10:41:38',2),(87,'74@qq.com',NULL,'1605753697689',NULL,'2020-11-19 10:41:38',2),(88,'75@qq.com',NULL,'1605753697762',NULL,'2020-11-19 10:41:38',2),(89,'76@qq.com',NULL,'1605753697855',NULL,'2020-11-19 10:41:38',2),(90,'77@qq.com',NULL,'1605753697927',NULL,'2020-11-19 10:41:38',2),(91,'78@qq.com',NULL,'1605753697988',NULL,'2020-11-19 10:41:38',2),(92,'79@qq.com',NULL,'1605753698069',NULL,'2020-11-19 10:41:38',2),(93,'80@qq.com',NULL,'1605753698157',NULL,'2020-11-19 10:41:38',2),(94,'81@qq.com',NULL,'1605753698227',NULL,'2020-11-19 10:41:38',2),(95,'82@qq.com',NULL,'1605753698279',NULL,'2020-11-19 10:41:38',2),(96,'83@qq.com',NULL,'1605753698352',NULL,'2020-11-19 10:41:38',2),(97,'84@qq.com',NULL,'1605753698438',NULL,'2020-11-19 10:41:38',2),(98,'85@qq.com',NULL,'1605753698510',NULL,'2020-11-19 10:41:39',2),(99,'86@qq.com',NULL,'1605753698580',NULL,'2020-11-19 10:41:39',2),(100,'87@qq.com',NULL,'1605753698644',NULL,'2020-11-19 10:41:39',2),(101,'88@qq.com',NULL,'1605753698739',NULL,'2020-11-19 10:41:39',2),(102,'89@qq.com',NULL,'1605753698802ccc',NULL,'2020-11-19 10:41:39',2),(103,'90@qq.com',NULL,'1605753698871',NULL,'2020-11-19 10:41:39',2),(104,'91@qq.com',NULL,'1605753698952',NULL,'2020-11-19 10:41:39',2),(105,'92@qq.com',NULL,'1605753699030',NULL,'2020-11-19 10:41:39',2),(106,'93@qq.com',NULL,'1605753699088',NULL,'2020-11-19 10:41:39',2),(108,'1@qq.com',NULL,'2',NULL,NULL,2),(109,'666@qq',NULL,'666',NULL,NULL,2),(110,'777@qq',NULL,'777',NULL,NULL,2),(111,'888',NULL,'888',NULL,NULL,2),(115,'123@qq.com','123',NULL,'/avatar/60d46b4a-d301-4bd0-8459-37eef6dccadc.PNG','2020-11-22 22:53:06',2);
/*!40000 ALTER TABLE `mall_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-02 14:35:16
