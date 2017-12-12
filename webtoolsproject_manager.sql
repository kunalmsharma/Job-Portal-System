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
-- Table structure for table `manager`
--

DROP TABLE IF EXISTS `manager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `manager` (
  `managerid` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `address_addressid` int(11) DEFAULT NULL,
  `company_companyid` int(11) DEFAULT NULL,
  `users_userid` int(11) DEFAULT NULL,
  PRIMARY KEY (`managerid`),
  KEY `FK_3ka1mshsbapbwbkhjk283tbpa` (`address_addressid`),
  KEY `FK_lbevtf312v6woarh5jjjq8uwe` (`company_companyid`),
  KEY `FK_nk3re2xrwwj0og62igj3seo90` (`users_userid`),
  CONSTRAINT `FK_3ka1mshsbapbwbkhjk283tbpa` FOREIGN KEY (`address_addressid`) REFERENCES `address` (`addressid`),
  CONSTRAINT `FK_lbevtf312v6woarh5jjjq8uwe` FOREIGN KEY (`company_companyid`) REFERENCES `company` (`companyid`),
  CONSTRAINT `FK_nk3re2xrwwj0og62igj3seo90` FOREIGN KEY (`users_userid`) REFERENCES `users` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manager`
--

LOCK TABLES `manager` WRITE;
/*!40000 ALTER TABLE `manager` DISABLE KEYS */;
INSERT INTO `manager` VALUES (2,'dilini','shetty',4,2,6),(3,'divya','sharma',6,3,9),(4,'abc','xyz',8,4,11),(5,'a','a',9,5,12),(6,'sarabjit','kaur',10,6,13),(7,'avdhoot','shivanand',11,7,14),(8,'prashant','joshi',16,8,19),(9,'jenny','jones',19,9,22),(10,'yashoda','sharma',22,10,25),(11,'anand','kumar',24,11,27);
/*!40000 ALTER TABLE `manager` ENABLE KEYS */;
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
