-- MySQL dump 10.13  Distrib 5.7.25, for Linux (x86_64)
--
-- Host: localhost    Database: helloworld_database
-- ------------------------------------------------------
-- Server version	5.7.25-0ubuntu0.18.04.2

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
-- Table structure for table `Users`
--

DROP TABLE IF EXISTS `Users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Users` (
  `first_name` char(255) DEFAULT NULL,
  `last_name` char(255) DEFAULT NULL,
  `registration_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Users`
--

LOCK TABLES `Users` WRITE;
/*!40000 ALTER TABLE `Users` DISABLE KEYS */;
INSERT INTO `Users` VALUES ('Nikita','Kholdobin','2019-03-13 17:02:12');
INSERT INTO `Users` VALUES ('New User','New','2019-03-13 17:22:16');
INSERT INTO `Users` VALUES ('User2','Qwerty','2019-03-13 17:36:44');
INSERT INTO `Users` VALUES ('User1','Qwerty','2019-03-13 17:37:20');
INSERT INTO `Users` VALUES ('Foo','Bar','2019-03-13 17:37:39');
INSERT INTO `Users` VALUES ('Foo','322','2019-03-13 17:39:17');
INSERT INTO `Users` VALUES ('Foo1','322','2019-03-13 17:39:25');
INSERT INTO `Users` VALUES ('','','2019-03-13 18:39:37');
INSERT INTO `Users` VALUES ('Ivan','Ivanov','2019-03-14 00:02:01');
INSERT INTO `Users` VALUES ('NewIvan','Ivanov','2019-03-14 00:02:33');
INSERT INTO `Users` VALUES ('1','2','2019-03-14 19:01:52');
INSERT INTO `Users` VALUES ('3','4','2019-03-14 19:03:52');
INSERT INTO `Users` VALUES ('35','6','2019-03-14 19:03:58');
INSERT INTO `Users` VALUES ('NikitaNew','User','2019-03-14 21:51:18');
INSERT INTO `Users` VALUES ('Nikita','User','2019-03-14 21:52:50');
/*!40000 ALTER TABLE `Users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-03-16 20:14:11
