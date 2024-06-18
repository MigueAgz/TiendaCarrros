-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: tiendacarros
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `administrador`
--

DROP TABLE IF EXISTS `administrador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `administrador` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `correo` varchar(50) NOT NULL,
  `contraseña` varchar(300) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrador`
--

LOCK TABLES `administrador` WRITE;
/*!40000 ALTER TABLE `administrador` DISABLE KEYS */;
INSERT INTO `administrador` VALUES (1,'Jaime','Ortega','ortega@mail.com','W43yRjDjnctKtPyvKgOuuA=='),(6,'Isaac','Rosales','hola@mail.com','z4V9fQrzsRYJebs0xIBwn29laC03UNN2b3XDUAzrCL4=');
/*!40000 ALTER TABLE `administrador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `almacen`
--

DROP TABLE IF EXISTS `almacen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `almacen` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_auto` int NOT NULL,
  `cantidad` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `almacenado` (`id_auto`),
  CONSTRAINT `almacenado` FOREIGN KEY (`id_auto`) REFERENCES `autos` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=142 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `almacen`
--

LOCK TABLES `almacen` WRITE;
/*!40000 ALTER TABLE `almacen` DISABLE KEYS */;
INSERT INTO `almacen` VALUES (13,7,0),(14,8,2),(15,9,2),(16,10,2),(17,11,2),(18,12,2),(19,13,2),(20,14,2),(21,15,2),(22,16,2),(23,17,2),(24,18,2),(25,19,2),(26,20,2),(27,21,2),(28,22,2),(29,23,2),(30,24,2),(31,25,2),(32,26,2),(33,27,2),(34,28,2),(35,29,2),(36,30,2),(37,31,2),(38,32,2),(39,33,2),(40,34,2),(41,35,2),(42,36,2),(43,37,2),(44,38,2),(45,39,2),(46,40,2),(47,41,2),(48,42,2),(49,43,2),(50,44,2),(51,45,2),(52,46,2),(53,47,2),(54,48,2),(55,49,2),(56,50,2),(57,51,2),(58,52,2),(59,53,2),(60,54,2),(61,55,2),(62,56,2),(63,57,2),(64,58,2),(65,59,2),(66,60,2),(67,61,2),(68,62,2),(69,63,2),(70,64,2),(71,65,1),(72,66,2),(73,67,2),(74,68,2),(75,69,2),(76,70,2),(77,71,2),(78,72,2),(79,73,2),(80,74,2),(81,75,2),(82,76,2),(83,77,2),(84,78,2),(85,79,2),(86,80,2),(87,81,2),(88,82,2),(89,83,2),(90,84,2),(91,85,2),(92,86,2),(93,87,2),(94,88,2),(95,89,2),(96,90,2),(97,91,2),(98,92,2),(99,93,2),(100,94,2),(101,95,2),(102,96,2),(103,97,2),(104,98,2),(105,99,2),(106,100,2),(107,101,2),(108,102,2),(109,103,2),(110,104,2),(111,105,2),(112,106,2),(113,107,2),(114,108,2),(115,109,2),(116,110,2),(117,111,2),(118,112,2),(119,113,2),(120,114,2),(121,115,2),(122,116,2),(123,117,2),(124,118,2),(125,119,2),(126,120,2),(127,121,2),(128,122,2),(129,123,2),(130,124,2),(131,125,2),(132,126,2),(141,135,2);
/*!40000 ALTER TABLE `almacen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `autos`
--

DROP TABLE IF EXISTS `autos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `autos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `marca` varchar(30) NOT NULL,
  `modelo` varchar(30) NOT NULL,
  `precio` decimal(9,3) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=136 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `autos`
--

LOCK TABLES `autos` WRITE;
/*!40000 ALTER TABLE `autos` DISABLE KEYS */;
INSERT INTO `autos` VALUES (7,'Mercedes-Benz','C-Class',45000.000),(8,'Audi','A4',40000.000),(9,'Hyundai','Elantra',19000.000),(10,'Kia','Sportage',22000.000),(11,'Mazda','CX-5',28000.000),(12,'Nissan','Sentra',20000.000),(13,'Subaru','Impreza',23000.000),(14,'Volvo','XC60',50000.000),(15,'Lexus','RX',60000.000),(16,'Infiniti','Q50',38000.000),(17,'Toyota','Corolla',25000.000),(18,'Ford','Mustang',35000.000),(19,'Chevrolet','Camaro',40000.000),(20,'Honda','Civic',20000.000),(21,'Volkswagen','Golf',18000.000),(22,'BMW','X5',55000.000),(23,'Mercedes-Benz','C-Class',45000.000),(24,'Audi','A4',40000.000),(25,'Hyundai','Elantra',19000.000),(26,'Kia','Sportage',22000.000),(27,'Mazda','CX-5',28000.000),(28,'Nissan','Sentra',20000.000),(29,'Subaru','Impreza',23000.000),(30,'Volvo','XC6',50000.000),(31,'Lexus','RX',60000.000),(32,'Infiniti','Q50',38000.000),(33,'Toyota','Camry',28000.000),(34,'Ford','F-150',40000.000),(35,'Chevrolet','Silverado',45000.000),(36,'Honda','Accord',26000.000),(37,'Volkswagen','Jetta',21000.000),(38,'BMW','3 Series',47000.000),(39,'Mercedes-Benz','E-Class',55000.000),(40,'Audi','Q5',42000.000),(41,'Hyundai','Tucson',25000.000),(42,'Kia','Sorento',32000.000),(43,'Mazda','Mazda3',23000.000),(44,'Nissan','Altima',24000.000),(45,'Subaru','Outback',29000.000),(46,'Volvo','S60',46000.000),(47,'Lexus','ES',50000.000),(48,'Infiniti','QX60',42000.000),(49,'Toyota','Rav4',27000.000),(50,'Ford','Explorer',38000.000),(51,'Chevrolet','Equinox',30000.000),(52,'Honda','CR-V',29000.000),(53,'Volkswagen','Tiguan',26000.000),(54,'BMW','5 Series',59000.000),(55,'Mercedes-Benz','GLC',52000.000),(56,'Audi','A6',48000.000),(57,'Hyundai','Santa Fe',33000.000),(58,'Kia','Optima',28000.000),(59,'Mazda','CX-9',35000.000),(60,'Nissan','Rogue',25000.000),(61,'Subaru','Forester',31000.000),(62,'Volvo','XC90',60000.000),(63,'Lexus','NX',45000.000),(64,'Infiniti','QX50',40000.000),(65,'Toyota','Corolla',15000.000),(66,'Honda','Civic',18000.000),(67,'Ford','Mustang',25000.000),(68,'Chevrolet','Camaro',28000.000),(69,'Nissan','Sentra',12000.000),(70,'Hyundai','Elantra',14000.000),(71,'Kia','Optima',20000.000),(72,'Mazda','Mazda3',17000.000),(73,'Subaru','Impreza',22000.000),(74,'Volkswagen','Jetta',19000.000),(75,'Audi','A4',35000.000),(76,'BMW','3 Series',40000.000),(77,'Mercedes-Benz','C-Class',45000.000),(78,'Lexus','ES',42000.000),(79,'Tesla','Model S',80000.000),(80,'Porsche','911',100000.000),(81,'Ferrari','488 GTB',250000.000),(82,'Lamborghini','Huracan',300000.000),(83,'Bugatti','Chiron',500000.000),(84,'Rolls-Royce','Phantom',450000.000),(85,'Bentley','Continental GT',350000.000),(86,'McLaren','720S',300000.000),(87,'Aston Martin','DB11',250000.000),(88,'Lotus','Evora',80000.000),(89,'Maserati','Ghibli',60000.000),(90,'Alfa Romeo','Giulia',40000.000),(91,'Jaguar','XE',35000.000),(92,'Land Rover','Range Rover',90000.000),(93,'Jeep','Wrangler',30000.000),(94,'GMC','Sierra',40000.000),(95,'Ram','1500',35000.000),(96,'Chevrolet','Silverado',45000.000),(97,'Ford','F-150',50000.000),(98,'Toyota','Tundra',55000.000),(99,'Nissan','Titan',40000.000),(100,'Honda','Ridgeline',35000.000),(101,'Subaru','Outback',25000.000),(102,'Jeep','Grand Cherokee',40000.000),(103,'Ford','Explorer',35000.000),(104,'Chevrolet','Tahoe',45000.000),(105,'GMC','Yukon',50000.000),(106,'Nissan','Armada',40000.000),(107,'Toyota','Land Cruiser',85000.000),(108,'Lexus','LX',90000.000),(109,'Cadillac','Escalade',80000.000),(110,'Lincoln','Navigator',75000.000),(111,'Mercedes-Benz','G-Class',150000.000),(112,'Range Rover','Sport',100000.000),(113,'Porsche','Cayenne',80000.000),(114,'Maserati','Levante',70000.000),(115,'Audi','Q7',60000.000),(116,'BMW','X5',65000.000),(117,'Volvo','XC90',55000.000),(118,'Tesla','Model X',90000.000),(119,'Ford','Escape',25000.000),(120,'Chevrolet','Equinox',28000.000),(121,'Honda','CR-V',30000.000),(122,'Toyota','RAV4',32000.000),(123,'Nissan','Rogue',28000.000),(124,'Mazda','CX-5',27000.000),(125,'Subaru','Forester',29000.000),(126,'Jeep','Cherokee',28000.000),(135,'Nissan','Tsuru',4816.100);
/*!40000 ALTER TABLE `autos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Jaime','Ortega'),(2,'Isaac','Rosales'),(4,'Emiliano','Gonzales');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `direcciones`
--

DROP TABLE IF EXISTS `direcciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `direcciones` (
  `id` int NOT NULL AUTO_INCREMENT,
  `calle` varchar(50) NOT NULL,
  `numero` int NOT NULL,
  `ciudad` varchar(50) NOT NULL,
  `cp` int NOT NULL,
  `colonia` varchar(50) NOT NULL,
  `id_cliente` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `clienteD` (`id_cliente`),
  CONSTRAINT `clienteD` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `direcciones`
--

LOCK TABLES `direcciones` WRITE;
/*!40000 ALTER TABLE `direcciones` DISABLE KEYS */;
INSERT INTO `direcciones` VALUES (1,'Calleprueba',456,'Ciudadreal',52146,'Coloniachida',1),(4,'Coralillo',692,'Chapultepec',52244,'Santa Teresa',2),(5,'falsa',212,'si',12345,'dementiritas',4);
/*!40000 ALTER TABLE `direcciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registro`
--

DROP TABLE IF EXISTS `registro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `registro` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_administrador` int NOT NULL,
  `accion` varchar(50) NOT NULL,
  `id_auto` int DEFAULT NULL,
  `id_cliente` int DEFAULT NULL,
  `id_ventas` int DEFAULT NULL,
  `fecha` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `administrador` (`id_administrador`),
  KEY `auto_res` (`id_auto`),
  KEY `cliente_res` (`id_cliente`),
  KEY `ventas_res` (`id_ventas`),
  CONSTRAINT `administrador` FOREIGN KEY (`id_administrador`) REFERENCES `administrador` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `auto_res` FOREIGN KEY (`id_auto`) REFERENCES `autos` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `cliente_res` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `ventas_res` FOREIGN KEY (`id_ventas`) REFERENCES `ventas` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registro`
--

LOCK TABLES `registro` WRITE;
/*!40000 ALTER TABLE `registro` DISABLE KEYS */;
INSERT INTO `registro` VALUES (6,6,'Creo un auto',NULL,NULL,NULL,'2023-06-02 03:53:21'),(8,6,'elimino un auto',NULL,NULL,NULL,'2023-06-02 03:53:21'),(9,6,'Creo un auto',NULL,NULL,NULL,'2023-06-02 03:53:53'),(10,6,'elimino un auto',NULL,NULL,NULL,'2023-06-02 03:55:05'),(11,6,'Actualizo un auto',135,NULL,NULL,'2023-06-02 16:12:01'),(14,6,'Creo una venta',NULL,NULL,6,'2023-06-04 00:32:52');
/*!40000 ALTER TABLE `registro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tarjetas`
--

DROP TABLE IF EXISTS `tarjetas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tarjetas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `noTarjeta` varchar(255) NOT NULL,
  `id_cliente` int NOT NULL,
  `banco` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `clienteT` (`id_cliente`),
  CONSTRAINT `clienteT` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tarjetas`
--

LOCK TABLES `tarjetas` WRITE;
/*!40000 ALTER TABLE `tarjetas` DISABLE KEYS */;
INSERT INTO `tarjetas` VALUES (1,'3741937826394638',2,'Visaa'),(2,'3741937826394638',1,'Mastercard'),(4,'1523174512691416',4,'viso');
/*!40000 ALTER TABLE `tarjetas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ventas`
--

DROP TABLE IF EXISTS `ventas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ventas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_administrador` int NOT NULL,
  `id_cliente` int DEFAULT NULL,
  `id_auto` int DEFAULT NULL,
  `cantidad` int NOT NULL,
  `fecha` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `id_direccion` int DEFAULT NULL,
  `id_tarjeta` int DEFAULT NULL,
  `subtotal` decimal(9,1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `administradorV` (`id_administrador`),
  KEY `auto_ven` (`id_auto`),
  KEY `ciente_ven` (`id_cliente`),
  KEY `direccion_ven` (`id_direccion`),
  KEY `tarjeta_ven` (`id_tarjeta`),
  CONSTRAINT `administradorV` FOREIGN KEY (`id_administrador`) REFERENCES `administrador` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `auto_ven` FOREIGN KEY (`id_auto`) REFERENCES `autos` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `ciente_ven` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `direccion_ven` FOREIGN KEY (`id_direccion`) REFERENCES `direcciones` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `tarjeta_ven` FOREIGN KEY (`id_tarjeta`) REFERENCES `tarjetas` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ventas`
--

LOCK TABLES `ventas` WRITE;
/*!40000 ALTER TABLE `ventas` DISABLE KEYS */;
INSERT INTO `ventas` VALUES (1,6,2,NULL,2,NULL,4,1,40000.0),(2,6,1,NULL,1,NULL,1,2,25000.0),(3,6,1,NULL,1,NULL,1,2,35000.0),(4,6,2,65,1,NULL,4,1,15000.0),(5,6,4,8,0,'2023-06-04 00:16:27',5,4,0.0),(6,6,4,7,1,'2023-06-04 00:20:48',5,4,45000.0),(7,6,4,7,1,'2023-06-04 00:32:51',5,4,45000.0);
/*!40000 ALTER TABLE `ventas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-03 19:56:14
