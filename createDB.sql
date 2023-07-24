CREATE DATABASE  IF NOT EXISTS `wastedb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `wastedb`;
-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: wastedb
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `reading`
--

DROP TABLE IF EXISTS `reading`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reading` (
  `Reading_Id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Distance` float NOT NULL,
  `Time` datetime NOT NULL,
  PRIMARY KEY (`Reading_Id`),
  UNIQUE KEY `Reading_Id_UNIQUE` (`Reading_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reading`
--

LOCK TABLES `reading` WRITE;
/*!40000 ALTER TABLE `reading` DISABLE KEYS */;
INSERT INTO `reading` VALUES ('061443b5-d017-473a-8c04-d4b514a75944',6.55857,'2023-07-19 21:00:02'),('0f3999f3-c60d-4c47-94c0-4349f88d5573',4.18963,'2023-07-19 19:46:11'),('139d818f-79e1-474f-85cf-ee3638df6f46',24.9578,'2023-07-21 23:00:02'),('148b150e-2894-44f9-bf1c-995dbe21a1bf',6.9268,'2023-07-20 20:30:02'),('1ab6f2e4-5869-4f8b-aa0e-540e8e0b32c4',6.43583,'2023-07-19 22:00:02'),('216ed3e1-9d04-4fb5-a9f4-f437f28d0f9f',11.8324,'2023-07-20 23:00:02'),('2a9816df-e06d-472a-bfce-b9b3563abe36',24.97,'2023-07-21 21:25:37'),('30edbc45-1b05-46a1-b406-4caa0916aaaa',6.93908,'2023-07-19 20:00:01'),('3890f4b6-74eb-4abd-8c6b-33a3ff5da597',11.8243,'2023-07-20 22:30:02'),('40df86cd-6320-4de1-8326-6b9fc3147046',5.51526,'2023-07-15 21:17:52'),('557c3f46-a250-4758-bec8-fafecccd98c5',4.31647,'2023-07-20 21:30:02'),('5872d1b7-cb50-4ff9-8a7a-75dd95edcb11',9,'2023-07-15 19:00:00'),('5e53c41b-d4b5-4bc4-a958-f1876a5920c7',6.55039,'2023-07-19 20:30:02'),('5f312a0e-6693-4270-b15a-31b822609321',6.42765,'2023-07-19 22:30:02'),('6f915142-911b-4fb1-b1b7-914288c7ae75',6.69768,'2023-07-20 22:00:02'),('7818aea1-f37a-42d3-84c1-33af651be6f4',4.18963,'2023-07-19 19:00:11'),('8e3ff1bf-dbc4-43f1-b898-f302f8612c5e',5,'2023-07-09 17:00:00'),('96120ca1-5abd-4dec-8356-dcb905bb7af8',4.16917,'2023-07-19 19:30:02'),('9f7cd7a3-f7fe-420f-bbf2-a0b61a3dd57e',25.0028,'2023-07-21 21:30:02'),('a4962ae0-ca15-4e76-b3e9-c5b8887e9614',24.925,'2023-07-22 00:00:02'),('a723b0ac-ddde-421f-b994-f1b4860f2c4c',6.91044,'2023-07-19 21:30:02'),('a7fa6740-9c2c-4625-bcbd-608077cd8980',6.93089,'2023-07-20 21:00:02'),('aab19228-9208-4703-8f04-6a5189d752b3',6.43174,'2023-07-19 23:00:02'),('afb33e34-75a7-4345-8f47-c4b05a474933',27.4249,'2023-07-24 17:30:01'),('b6bcb333-22db-464a-aa0b-3434f81959b2',8,'2023-07-14 19:00:00'),('b825b572-1eb1-4f78-aaee-9ad8d6fa518b',4.73788,'2023-07-21 01:00:01'),('cafcfec5-1728-4b98-9a13-4ab72edbf720',24.9619,'2023-07-21 23:30:02'),('d8fe093e-cce8-4f80-a0ae-5b0f8f9a5f01',24.9087,'2023-07-21 22:30:02'),('e23c2d4b-1161-483a-a3c7-fdbe616ef8b2',5.83439,'2023-07-21 00:30:02'),('e78c99a3-6c44-48ca-866d-47c8d61c0f80',24.9782,'2023-07-21 22:00:01'),('ea18a473-4268-49a3-8494-d568159a7cba',7.5,'2023-07-10 14:00:00'),('f30d4ebe-1bd2-4290-aed5-3bf6090179ec',11.7629,'2023-07-21 00:00:02'),('f901b50d-a9d6-4844-865a-aa5e99a6e141',4.18963,'2023-07-19 19:14:11'),('fc6e23b3-b939-4b6a-a512-85dbd13af4e4',11.8243,'2023-07-20 23:30:02');
/*!40000 ALTER TABLE `reading` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spring_session`
--

DROP TABLE IF EXISTS `spring_session`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spring_session` (
  `PRIMARY_ID` char(36) NOT NULL,
  `SESSION_ID` char(36) NOT NULL,
  `CREATION_TIME` bigint NOT NULL,
  `LAST_ACCESS_TIME` bigint NOT NULL,
  `MAX_INACTIVE_INTERVAL` int NOT NULL,
  `EXPIRY_TIME` bigint NOT NULL,
  `PRINCIPAL_NAME` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`PRIMARY_ID`),
  UNIQUE KEY `SPRING_SESSION_IX1` (`SESSION_ID`),
  KEY `SPRING_SESSION_IX2` (`EXPIRY_TIME`),
  KEY `SPRING_SESSION_IX3` (`PRINCIPAL_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spring_session`
--

LOCK TABLES `spring_session` WRITE;
/*!40000 ALTER TABLE `spring_session` DISABLE KEYS */;
/*!40000 ALTER TABLE `spring_session` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spring_session_attributes`
--

DROP TABLE IF EXISTS `spring_session_attributes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spring_session_attributes` (
  `SESSION_PRIMARY_ID` char(36) NOT NULL,
  `ATTRIBUTE_NAME` varchar(200) NOT NULL,
  `ATTRIBUTE_BYTES` blob NOT NULL,
  PRIMARY KEY (`SESSION_PRIMARY_ID`,`ATTRIBUTE_NAME`),
  CONSTRAINT `SPRING_SESSION_ATTRIBUTES_FK` FOREIGN KEY (`SESSION_PRIMARY_ID`) REFERENCES `spring_session` (`PRIMARY_ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spring_session_attributes`
--

LOCK TABLES `spring_session_attributes` WRITE;
/*!40000 ALTER TABLE `spring_session_attributes` DISABLE KEYS */;
/*!40000 ALTER TABLE `spring_session_attributes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `User_Id` varchar(40) NOT NULL,
  `Username` varchar(45) NOT NULL,
  `Monday_Pickup` tinyint(1) NOT NULL,
  `Tuesday_Pickup` tinyint(1) NOT NULL,
  `Wednesday_Pickup` tinyint(1) NOT NULL,
  `Thursday_Pickup` tinyint(1) NOT NULL,
  `Friday_Pickup` tinyint(1) NOT NULL,
  `Saturday_Pickup` tinyint(1) NOT NULL,
  `Sunday_Pickup` tinyint(1) NOT NULL,
  PRIMARY KEY (`User_Id`),
  UNIQUE KEY `User_Id_UNIQUE` (`User_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('4828a776-824b-4ca1-8714-6edd245ee016','John_Arbuckle',1,1,1,1,1,0,0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-07-24 17:44:52
