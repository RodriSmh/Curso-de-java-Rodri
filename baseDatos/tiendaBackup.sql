-- MySQL dump 10.13  Distrib 8.0.42, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: tienda
-- ------------------------------------------------------
-- Server version	9.3.0

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
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categoria` (
  `idcategoria` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idcategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (1,'Bebidas con gas'),(2,'Aceites'),(3,'Detergentes'),(4,'Galletas'),(5,'Chocolates'),(6,'Frituras');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `codigobarras`
--

DROP TABLE IF EXISTS `codigobarras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `codigobarras` (
  `idCodigoBarras` int NOT NULL AUTO_INCREMENT,
  `serial` varchar(45) NOT NULL,
  `idProducto` int DEFAULT NULL,
  PRIMARY KEY (`idCodigoBarras`),
  KEY `idProducto_fk_idx` (`idProducto`),
  CONSTRAINT `idProducto_fk` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `codigobarras`
--

LOCK TABLES `codigobarras` WRITE;
/*!40000 ALTER TABLE `codigobarras` DISABLE KEYS */;
INSERT INTO `codigobarras` VALUES (1,'1234123423',1),(2,'1234125643',2),(3,'1244123423',3),(4,'1266434423',4),(5,'1266434424',5),(6,'1266434425',6),(7,'1266434426',7),(8,'1266434427',8),(9,'1266434428',9),(10,'1266434429',10),(11,'1266434430',11),(12,'1266434431',12),(13,'1266434432',13),(14,'1266434433',14),(15,'1266434434',15),(16,'1266434435',16),(17,'1266434436',17);
/*!40000 ALTER TABLE `codigobarras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto` (
  `idProducto` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `precio` decimal(10,2) NOT NULL,
  `fecha_venta` date DEFAULT NULL,
  `idCategoria` int DEFAULT NULL,
  `cantidad` int DEFAULT NULL,
  PRIMARY KEY (`idProducto`),
  KEY `idCategoria_fk_idx` (`idCategoria`),
  CONSTRAINT `idCategoria_fk` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idcategoria`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (1,'Gaseosa Coca cola',5.50,'2025-07-02',1,150),(2,'Gaseosa Inka cola',5.40,'2025-07-02',1,120),(3,'Cervesa Heineken',5.50,'2025-07-02',1,100),(4,'Aceite oliva',4.00,'2025-07-02',2,80),(5,'Aceite mineral',3.50,'2025-07-03',2,60),(6,'Aceite sintetico',3.50,'2025-07-03',2,50),(7,'Ace',1.40,'2025-07-03',3,200),(8,'Bolivar',1.50,'2025-07-03',3,180),(9,'Opal',1.50,'2025-07-03',3,150),(10,'Oreo',1.10,'2025-07-03',4,120),(11,'Emperador',1.50,'2025-07-03',4,100),(12,'Maria',1.20,'2025-07-03',4,90),(13,'Kit Kat',1.60,'2025-07-03',5,80),(14,'Carlos V',1.00,'2025-07-03',5,70),(15,'Bocadin',1.00,'2025-07-03',5,60),(16,'Lays',3.00,'2025-07-03',6,50),(17,'Pringles',4.00,'2025-07-03',6,40);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedores`
--

DROP TABLE IF EXISTS `proveedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveedores` (
  `idProveedores` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idProveedores`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedores`
--

LOCK TABLES `proveedores` WRITE;
/*!40000 ALTER TABLE `proveedores` DISABLE KEYS */;
/*!40000 ALTER TABLE `proveedores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `union_pp`
--

DROP TABLE IF EXISTS `union_pp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `union_pp` (
  `idUnion_pp` int NOT NULL AUTO_INCREMENT,
  `idProducto1` int NOT NULL,
  `idProveedor1` int NOT NULL,
  PRIMARY KEY (`idUnion_pp`),
  KEY `idProducto_fk_idx` (`idProducto1`),
  KEY `idProveedor_fk1_idx` (`idProveedor1`),
  CONSTRAINT `idProducto_fk1` FOREIGN KEY (`idProducto1`) REFERENCES `producto` (`idProducto`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `idProveedor_fk1` FOREIGN KEY (`idProveedor1`) REFERENCES `proveedores` (`idProveedores`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `union_pp`
--

LOCK TABLES `union_pp` WRITE;
/*!40000 ALTER TABLE `union_pp` DISABLE KEYS */;
/*!40000 ALTER TABLE `union_pp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `vista_producto_categoria`
--

DROP TABLE IF EXISTS `vista_producto_categoria`;
/*!50001 DROP VIEW IF EXISTS `vista_producto_categoria`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vista_producto_categoria` AS SELECT 
 1 AS `#`,
 1 AS `producto`,
 1 AS `precio`,
 1 AS `categoria`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `vista_producto_categoria`
--

/*!50001 DROP VIEW IF EXISTS `vista_producto_categoria`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vista_producto_categoria` AS select row_number() OVER (ORDER BY `p`.`nombre` )  AS `#`,`p`.`nombre` AS `producto`,`p`.`precio` AS `precio`,`c`.`nombre` AS `categoria` from (`producto` `p` join `categoria` `c` on((`p`.`idCategoria` = `c`.`idcategoria`))) where (`p`.`precio` > 3) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-07-05  5:54:50
