-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: webtoolsproject
-- ------------------------------------------------------
-- Server version	5.7.10-log

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
-- Table structure for table `jobapplied`
--

DROP TABLE IF EXISTS `jobapplied`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jobapplied` (
  `jobappliedid` int(11) NOT NULL AUTO_INCREMENT,
  `jobpost_jobpostid` int(11) DEFAULT NULL,
  `jobseeker_jobseekerid` int(11) DEFAULT NULL,
  PRIMARY KEY (`jobappliedid`),
  KEY `FK_n6s8rlvmxxtmfnjfdx8xiwenm` (`jobpost_jobpostid`),
  KEY `FK_aexexyxsnwwfnlpeu37upj194` (`jobseeker_jobseekerid`),
  CONSTRAINT `FK_aexexyxsnwwfnlpeu37upj194` FOREIGN KEY (`jobseeker_jobseekerid`) REFERENCES `jobseeker` (`jobseekerid`),
  CONSTRAINT `FK_n6s8rlvmxxtmfnjfdx8xiwenm` FOREIGN KEY (`jobpost_jobpostid`) REFERENCES `jobpost` (`jobpostid`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jobapplied`
--

LOCK TABLES `jobapplied` WRITE;
/*!40000 ALTER TABLE `jobapplied` DISABLE KEYS */;
INSERT INTO `jobapplied` VALUES (3,7,5),(4,11,8),(5,11,8),(6,11,NULL),(7,7,8),(8,7,8),(9,13,8),(10,13,8),(11,13,8),(12,13,8),(13,13,8),(14,13,8),(15,13,8),(16,13,8),(17,13,NULL),(18,13,NULL),(19,7,NULL),(20,11,NULL),(21,13,8),(22,7,8),(23,7,9),(24,11,9),(25,7,9),(26,14,9),(31,20,12),(35,24,13);
/*!40000 ALTER TABLE `jobapplied` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-04-26  4:14:26
