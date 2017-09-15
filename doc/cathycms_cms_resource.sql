-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: 127.0.0.1    Database: cathycms
-- ------------------------------------------------------
-- Server version	5.7.19

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
-- Table structure for table `cms_resource`
--

DROP TABLE IF EXISTS `cms_resource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cms_resource` (
  `resource_id` int(11) NOT NULL AUTO_INCREMENT,
  `resource_name` varchar(50) DEFAULT NULL,
  `audit_flag` varchar(2) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `delete_flag` varchar(1) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `icon` varchar(512) DEFAULT NULL,
  `order_no` int(11) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`resource_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cms_resource`
--

LOCK TABLES `cms_resource` WRITE;
/*!40000 ALTER TABLE `cms_resource` DISABLE KEYS */;
INSERT INTO `cms_resource` VALUES (1,'修改密码',NULL,'2017-03-17 15:32:19','0','2017-03-17 15:32:19','',90,'module','/user/update_pwd',NULL),(2,'内容管理',NULL,'2017-03-17 15:37:16','0','2017-03-17 15:37:16','',30,'module','',NULL),(3,'栏目列表',NULL,'2017-03-17 15:41:21','0','2017-03-17 16:17:12','',31,'page','/cms/column/list',2),(4,'文章列表',NULL,'2017-03-17 15:42:31','0','2017-03-17 16:17:21','',32,'page','/cms/article/list',2),(5,'换肤管理',NULL,'2017-03-28 16:37:07','0','2017-03-28 16:37:07','',20,'module','/user/skin/list',NULL),(6,'权限管理',NULL,'2016-08-17 17:06:19','0','2016-10-28 17:02:57','',10,'module','/user/list',NULL),(7,'用户列表',NULL,'2016-09-07 15:15:58','0','2016-10-28 17:03:06','',11,'page','/user/list',6),(8,'角色列表',NULL,'2016-09-07 15:17:37','0','2016-10-28 17:03:13','',12,'page','/user/role_list',6),(9,'菜单列表',NULL,'2016-09-18 16:34:14','0','2016-10-28 17:03:19','icon-list-alt',13,'page','/menu/index',6);
/*!40000 ALTER TABLE `cms_resource` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-09-15 18:06:52
