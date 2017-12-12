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
-- Table structure for table `jobseeker`
--

DROP TABLE IF EXISTS `jobseeker`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jobseeker` (
  `jobseekerid` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `phoneno` varchar(255) DEFAULT NULL,
  `qualification` varchar(255) DEFAULT NULL,
  `workexperience` int(11) NOT NULL,
  `address_addressid` int(11) DEFAULT NULL,
  `users_userid` int(11) DEFAULT NULL,
  PRIMARY KEY (`jobseekerid`),
  KEY `FK_bbefvjvxtemp1qru6jig32e3m` (`address_addressid`),
  KEY `FK_snj4uj9ot46fyoowscdc5yb1n` (`users_userid`),
  CONSTRAINT `FK_bbefvjvxtemp1qru6jig32e3m` FOREIGN KEY (`address_addressid`) REFERENCES `address` (`addressid`),
  CONSTRAINT `FK_snj4uj9ot46fyoowscdc5yb1n` FOREIGN KEY (`users_userid`) REFERENCES `users` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jobseeker`
--

LOCK TABLES `jobseeker` WRITE;
/*!40000 ALTER TABLE `jobseeker` DISABLE KEYS */;
INSERT INTO `jobseeker` VALUES (2,'amitabh','bachchan','6547893215','MS',35,3,4),(3,'amitabh','bachchan','6547893215','MS',35,5,8),(4,'amitabh','bachchan','6547893215','MS',35,7,10),(5,'amitabh','yes','6547893215','MS',35,12,15),(7,'jhjhj','ghgh','11265587895','mn',76,14,17),(8,'atul','Sharma','9874563212','ME',12,15,18),(9,'aaj','tak','9874563215','ba',15,17,20),(11,'yusuf','Khan','1234567890','MS',2,20,23),(12,'divya','sharma','2145789632','BE',21,21,24),(13,'mahendra','sharma','3214569871','LLB',27,23,26);
/*!40000 ALTER TABLE `jobseeker` ENABLE KEYS */;
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
