CREATE DATABASE  IF NOT EXISTS `bookservicewebappdb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `bookservicewebappdb`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: localhost    Database: bookservicewebappdb
-- ------------------------------------------------------
-- Server version	5.6.21-log

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
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ISBN` varchar(45) NOT NULL,
  `subtitle` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `pages` int(11) DEFAULT NULL,
  `language` varchar(45) DEFAULT NULL,
  `publisherid` int(11) DEFAULT NULL,
  `title` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ISBN_UNIQUE` (`ISBN`),
  KEY `publisherid_idx` (`publisherid`),
  CONSTRAINT `publisherid` FOREIGN KEY (`publisherid`) REFERENCES `publisher` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,'123123','Game of Thrones','awesome',1200,'DE',NULL,NULL),(2,'1234',NULL,'asd',123,'asd',NULL,'asd'),(4,'123456',NULL,'asd',123,'asd',NULL,'asd'),(5,'1234556',NULL,'asd',123,'asd',NULL,'asd'),(6,'1234556666',NULL,'asd',123,'asd',NULL,'asd'),(7,'1351213','asd','asd',0,'asd',NULL,'asd'),(8,'5123512',NULL,'asd',123,NULL,NULL,NULL),(9,'12135','asd','asd',123,'asd',NULL,'asd'),(10,'12361231','asd','asd',213,'asd',4,'asd'),(11,'12361231231231','asd12','asd12',213,'asd12',5,'asd123'),(12,'12372626','asd','asd',1235,'asd',6,'asd'),(13,'8989-2232','deutsch','cool',1235,'deutsch',7,'Game of Thrones: Zeit der Krähen'),(14,'10-90-70','englisch','beste wo gibt',1234,'deutsch',8,'Herr der Fliegen'),(15,'12-21-23','keinen','cool',1232,'deutsch',9,'Herr der Ringe'),(16,'14-21-23','keinen','cool',1232,'deutsch',10,'Herr der Ringe'),(17,'123-21-23','keinen','cool',1232,'deutsch',11,'Herr der Ringe'),(18,'129-22-23','keinen','cool',1232,'deutsch',12,'Herr der Ringe'),(19,'129-242-23','keinen','cool',1232,'deutsch',13,'Herr der Ringe');
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-12-13 12:23:04
