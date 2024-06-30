CREATE DATABASE  IF NOT EXISTS `stocks` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `stocks`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: stocks
-- ------------------------------------------------------
-- Server version	8.4.0

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
-- Table structure for table `busqueda`
--

DROP TABLE IF EXISTS `busqueda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `busqueda` (
  `ID_Busqueda` int NOT NULL AUTO_INCREMENT,
  `ID_Usuario` int DEFAULT NULL,
  `Fecha_Hora` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `Criterio_Nombre` varchar(100) DEFAULT NULL,
  `Criterio_Categoria` varchar(50) DEFAULT NULL,
  `Criterio_Marca` varchar(50) DEFAULT NULL,
  `Criterio_Precio` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`ID_Busqueda`),
  KEY `ID_Usuario` (`ID_Usuario`),
  CONSTRAINT `busqueda_ibfk_1` FOREIGN KEY (`ID_Usuario`) REFERENCES `usuario` (`ID_Usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `busqueda`
--

LOCK TABLES `busqueda` WRITE;
/*!40000 ALTER TABLE `busqueda` DISABLE KEYS */;
INSERT INTO `busqueda` VALUES (2,2,'2024-06-29 21:21:20','Smartphone','Electrónica','Samsung',900.00);
/*!40000 ALTER TABLE `busqueda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resultado_busqueda`
--

DROP TABLE IF EXISTS `resultado_busqueda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `resultado_busqueda` (
  `ID_Resultado` int NOT NULL AUTO_INCREMENT,
  `ID_Busqueda` int DEFAULT NULL,
  `ID_Stock` int DEFAULT NULL,
  PRIMARY KEY (`ID_Resultado`),
  KEY `ID_Busqueda` (`ID_Busqueda`),
  KEY `ID_Stock` (`ID_Stock`),
  CONSTRAINT `resultado_busqueda_ibfk_1` FOREIGN KEY (`ID_Busqueda`) REFERENCES `busqueda` (`ID_Busqueda`),
  CONSTRAINT `resultado_busqueda_ibfk_2` FOREIGN KEY (`ID_Stock`) REFERENCES `stock` (`ID_Stock`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resultado_busqueda`
--

LOCK TABLES `resultado_busqueda` WRITE;
/*!40000 ALTER TABLE `resultado_busqueda` DISABLE KEYS */;
INSERT INTO `resultado_busqueda` VALUES (2,2,2);
/*!40000 ALTER TABLE `resultado_busqueda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock`
--

DROP TABLE IF EXISTS `stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stock` (
  `ID_Stock` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(100) NOT NULL,
  `Categoria` varchar(255) DEFAULT 'Sin categoría',
  `Marca` varchar(50) DEFAULT 'Sin marca',
  `Precio` decimal(10,2) NOT NULL,
  `Cantidad_Disponible` int NOT NULL,
  `Descripcion` text,
  PRIMARY KEY (`ID_Stock`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock`
--

LOCK TABLES `stock` WRITE;
/*!40000 ALTER TABLE `stock` DISABLE KEYS */;
INSERT INTO `stock` VALUES (2,'Jeans Levi\'s','Vestimenta','Levi\'s',60.00,30,'Jeans clásicos Levi\'s 501'),(3,'Chaqueta North Face','Vestimenta','The North Face',120.00,15,'Chaqueta impermeable para invierno'),(4,'Zapatos Adidas','Vestimenta','Adidas',80.00,40,'Zapatos deportivos Adidas Running'),(5,'Sombrero Fedora','Vestimenta','Generic',35.00,20,'Sombrero de ala ancha estilo Fedora'),(6,'Sueter','Sin categoría','Sin marca',5000.00,4,NULL),(7,'Jean wrangler','Sin categoría','Sin marca',70000.00,5,NULL);
/*!40000 ALTER TABLE `stock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `ID_Usuario` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(100) NOT NULL,
  `Correo_Electronico` varchar(100) NOT NULL,
  `Contrasena` varchar(255) NOT NULL,
  `Fecha_Creacion` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `tipo` enum('comprador','vendedor') DEFAULT NULL,
  PRIMARY KEY (`ID_Usuario`),
  UNIQUE KEY `Correo_Electronico` (`Correo_Electronico`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (2,'Maria Gomez','maria.gomez@example.com','hashed_password_2','2024-06-29 21:21:20',NULL),(3,'Carlos Lopez','carlos.lopez@example.com','hashed_password_3','2024-06-29 21:21:20',NULL),(4,'d','s@gmail.com','s','2024-06-30 01:33:55','comprador'),(5,'s','sjsj@gmail.com','d','2024-06-30 01:36:35','comprador'),(7,'Pedro','Gonzalez','','2024-06-30 01:39:13','vendedor'),(8,'Carlos','carlos@gmail.com','1234','2024-06-30 13:52:48','vendedor'),(9,'Nuevo vendedor','nicolas@gmail.com','1234','2024-06-30 14:52:43','vendedor');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-30 17:17:16
