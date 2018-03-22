-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mer. 21 mars 2018 à 14:17
-- Version du serveur :  5.7.19
-- Version de PHP :  7.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `projet_java_imie`
--

-- --------------------------------------------------------

--
-- Structure de la table `server`
--

DROP TABLE IF EXISTS `server`;
CREATE TABLE IF NOT EXISTS `server` (
  `server_id` int(11) NOT NULL AUTO_INCREMENT,
  `memory_size` bigint(20) NOT NULL DEFAULT '0',
  `disk_size` bigint(20) NOT NULL DEFAULT '0',
  `server_name` varchar(100) NOT NULL,
  PRIMARY KEY (`server_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `server_monitoring`
--

DROP TABLE IF EXISTS `server_monitoring`;
CREATE TABLE IF NOT EXISTS `server_monitoring` (
  `monitoring_id` int(11) NOT NULL AUTO_INCREMENT,
  `time` bigint(20) NOT NULL,
  `traffic_in` int(11) NOT NULL DEFAULT '0',
  `traffic_out` int(11) NOT NULL DEFAULT '0',
  `memory_used` bigint(20) NOT NULL DEFAULT '0',
  `security_error` int(11) NOT NULL DEFAULT '0',
  `cpu0` decimal(8,6) NOT NULL DEFAULT '0.000000',
  `cpu1` decimal(8,6) NOT NULL DEFAULT '0.000000',
  `cpu2` decimal(8,6) NOT NULL DEFAULT '0.000000',
  `cpu3` decimal(8,6) NOT NULL DEFAULT '0.000000',
  `cpu4` decimal(8,6) NOT NULL DEFAULT '0.000000',
  `cpu5` decimal(8,6) NOT NULL DEFAULT '0.000000',
  `cpu6` decimal(8,6) NOT NULL DEFAULT '0.000000',
  `cpu7` decimal(8,6) NOT NULL DEFAULT '0.000000',
  `cpu8` decimal(8,6) NOT NULL DEFAULT '0.000000',
  `disk_used` bigint(20) NOT NULL DEFAULT '0',
  `server_ref` int(11) NOT NULL,
  PRIMARY KEY (`monitoring_id`),
  KEY `server_monitoring_server_fk` (`server_ref`)
) ENGINE=InnoDB AUTO_INCREMENT=49342 DEFAULT CHARSET=utf8;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `server_monitoring`
--
ALTER TABLE `server_monitoring`
  ADD CONSTRAINT `server_monitoring_server_fk` FOREIGN KEY (`server_ref`) REFERENCES `server` (`server_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
