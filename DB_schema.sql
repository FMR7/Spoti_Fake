-- MySQL dump 10.16  Distrib 10.1.9-MariaDB, for Win32 (AMD64)
--
-- Host: 127.0.0.1    Database: musica
-- ------------------------------------------------------
-- Server version	10.1.9-MariaDB

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
-- Table structure for table `autores`
--

DROP TABLE IF EXISTS `autores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `autores` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `autores_canciones`
--

DROP TABLE IF EXISTS `autores_canciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `autores_canciones` (
  `id_cancion` int(40) NOT NULL,
  `id_autor` int(40) NOT NULL,
  PRIMARY KEY (`id_cancion`,`id_autor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `canciones`
--

DROP TABLE IF EXISTS `canciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `canciones` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(40) NOT NULL,
  `id_disco` int(11) NOT NULL,
  `url` varchar(255) NOT NULL,
  `rating` int(11) DEFAULT NULL,
  `genero` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `discos`
--

DROP TABLE IF EXISTS `discos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `discos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(40) NOT NULL,
  `fecha` date DEFAULT NULL,
  `url_img` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `grupos`
--

DROP TABLE IF EXISTS `grupos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grupos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `grupos_autores`
--

DROP TABLE IF EXISTS `grupos_autores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grupos_autores` (
  `id_grupo` int(11) NOT NULL,
  `id_autor` int(40) NOT NULL,
  PRIMARY KEY (`id_grupo`,`id_autor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `grupos_discos`
--

DROP TABLE IF EXISTS `grupos_discos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grupos_discos` (
  `id_grupo` int(11) NOT NULL,
  `id_disco` int(40) NOT NULL,
  PRIMARY KEY (`id_grupo`,`id_disco`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Temporary table structure for view `v_autores_cancion`
--

DROP TABLE IF EXISTS `v_autores_cancion`;
/*!50001 DROP VIEW IF EXISTS `v_autores_cancion`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `v_autores_cancion` (
  `nombre` tinyint NOT NULL,
  `id_cancion` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `v_canciones_autor`
--

DROP TABLE IF EXISTS `v_canciones_autor`;
/*!50001 DROP VIEW IF EXISTS `v_canciones_autor`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `v_canciones_autor` (
  `id` tinyint NOT NULL,
  `nombre` tinyint NOT NULL,
  `id_disco` tinyint NOT NULL,
  `url` tinyint NOT NULL,
  `rating` tinyint NOT NULL,
  `genero` tinyint NOT NULL,
  `id_autor` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `v_canciones_disco`
--

DROP TABLE IF EXISTS `v_canciones_disco`;
/*!50001 DROP VIEW IF EXISTS `v_canciones_disco`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `v_canciones_disco` (
  `id` tinyint NOT NULL,
  `nombre` tinyint NOT NULL,
  `id_disco` tinyint NOT NULL,
  `url` tinyint NOT NULL,
  `rating` tinyint NOT NULL,
  `genero` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `v_canciones_genero`
--

DROP TABLE IF EXISTS `v_canciones_genero`;
/*!50001 DROP VIEW IF EXISTS `v_canciones_genero`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `v_canciones_genero` (
  `id` tinyint NOT NULL,
  `nombre` tinyint NOT NULL,
  `id_disco` tinyint NOT NULL,
  `url` tinyint NOT NULL,
  `rating` tinyint NOT NULL,
  `genero` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `v_disco_nombre`
--

DROP TABLE IF EXISTS `v_disco_nombre`;
/*!50001 DROP VIEW IF EXISTS `v_disco_nombre`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `v_disco_nombre` (
  `nombre` tinyint NOT NULL,
  `id_cancion` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `v_discos_grupo`
--

DROP TABLE IF EXISTS `v_discos_grupo`;
/*!50001 DROP VIEW IF EXISTS `v_discos_grupo`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `v_discos_grupo` (
  `id` tinyint NOT NULL,
  `nombre` tinyint NOT NULL,
  `fecha` tinyint NOT NULL,
  `url_img` tinyint NOT NULL,
  `id_grupo` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `v_grupo_cancion`
--

DROP TABLE IF EXISTS `v_grupo_cancion`;
/*!50001 DROP VIEW IF EXISTS `v_grupo_cancion`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `v_grupo_cancion` (
  `nombre` tinyint NOT NULL,
  `id_disco` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `v_autores_cancion`
--

/*!50001 DROP TABLE IF EXISTS `v_autores_cancion`*/;
/*!50001 DROP VIEW IF EXISTS `v_autores_cancion`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = latin1 */;
/*!50001 SET character_set_results     = latin1 */;
/*!50001 SET collation_connection      = latin1_swedish_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_autores_cancion` AS select `a`.`nombre` AS `nombre`,`c`.`id` AS `id_cancion` from ((`canciones` `c` join `autores_canciones` `ac` on((`c`.`id` = `ac`.`id_cancion`))) join `autores` `a` on((`ac`.`id_autor` = `a`.`id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_canciones_autor`
--

/*!50001 DROP TABLE IF EXISTS `v_canciones_autor`*/;
/*!50001 DROP VIEW IF EXISTS `v_canciones_autor`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = latin1 */;
/*!50001 SET character_set_results     = latin1 */;
/*!50001 SET collation_connection      = latin1_swedish_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_canciones_autor` AS select `c`.`id` AS `id`,`c`.`nombre` AS `nombre`,`c`.`id_disco` AS `id_disco`,`c`.`url` AS `url`,`c`.`rating` AS `rating`,`c`.`genero` AS `genero`,`a`.`id` AS `id_autor` from ((`autores_canciones` `ac` join `autores` `a` on((`ac`.`id_autor` = `a`.`id`))) join `canciones` `c` on((`ac`.`id_cancion` = `c`.`id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_canciones_disco`
--

/*!50001 DROP TABLE IF EXISTS `v_canciones_disco`*/;
/*!50001 DROP VIEW IF EXISTS `v_canciones_disco`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = latin1 */;
/*!50001 SET character_set_results     = latin1 */;
/*!50001 SET collation_connection      = latin1_swedish_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_canciones_disco` AS select `c`.`id` AS `id`,`c`.`nombre` AS `nombre`,`c`.`id_disco` AS `id_disco`,`c`.`url` AS `url`,`c`.`rating` AS `rating`,`c`.`genero` AS `genero` from (`discos` `d` join `canciones` `c` on((`d`.`id` = `c`.`id_disco`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_canciones_genero`
--

/*!50001 DROP TABLE IF EXISTS `v_canciones_genero`*/;
/*!50001 DROP VIEW IF EXISTS `v_canciones_genero`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = latin1 */;
/*!50001 SET character_set_results     = latin1 */;
/*!50001 SET collation_connection      = latin1_swedish_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_canciones_genero` AS select `c`.`id` AS `id`,`c`.`nombre` AS `nombre`,`c`.`id_disco` AS `id_disco`,`c`.`url` AS `url`,`c`.`rating` AS `rating`,`c`.`genero` AS `genero` from `canciones` `c` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_disco_nombre`
--

/*!50001 DROP TABLE IF EXISTS `v_disco_nombre`*/;
/*!50001 DROP VIEW IF EXISTS `v_disco_nombre`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = latin1 */;
/*!50001 SET character_set_results     = latin1 */;
/*!50001 SET collation_connection      = latin1_swedish_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_disco_nombre` AS select `d`.`nombre` AS `nombre`,`c`.`id` AS `id_cancion` from (`canciones` `c` join `discos` `d` on((`c`.`id_disco` = `d`.`id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_discos_grupo`
--

/*!50001 DROP TABLE IF EXISTS `v_discos_grupo`*/;
/*!50001 DROP VIEW IF EXISTS `v_discos_grupo`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = latin1 */;
/*!50001 SET character_set_results     = latin1 */;
/*!50001 SET collation_connection      = latin1_swedish_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_discos_grupo` AS select `d`.`id` AS `id`,`d`.`nombre` AS `nombre`,`d`.`fecha` AS `fecha`,`d`.`url_img` AS `url_img`,`g`.`id` AS `id_grupo` from ((`grupos_discos` `gd` join `grupos` `g` on((`gd`.`id_grupo` = `g`.`id`))) join `discos` `d` on((`gd`.`id_disco` = `d`.`id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_grupo_cancion`
--

/*!50001 DROP TABLE IF EXISTS `v_grupo_cancion`*/;
/*!50001 DROP VIEW IF EXISTS `v_grupo_cancion`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = latin1 */;
/*!50001 SET character_set_results     = latin1 */;
/*!50001 SET collation_connection      = latin1_swedish_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_grupo_cancion` AS select `g`.`nombre` AS `nombre`,`c`.`id_disco` AS `id_disco` from ((`canciones` `c` join `grupos_discos` `gd` on((`gd`.`id_disco` = `c`.`id_disco`))) join `grupos` `g` on((`g`.`id` = `gd`.`id_grupo`))) */;
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

-- Dump completed on 2016-04-23 17:37:27
