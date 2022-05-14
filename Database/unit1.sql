-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: May 14, 2022 at 07:45 AM
-- Server version: 5.7.36
-- PHP Version: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `unitmanage`
--

-- --------------------------------------------------------

--
-- Table structure for table `unit1`
--

DROP TABLE IF EXISTS `unit1`;
CREATE TABLE IF NOT EXISTS `unit1` (
  `uID` int(4) NOT NULL AUTO_INCREMENT,
  `uAccNo` varchar(40) NOT NULL,
  `uEmail` varchar(100) NOT NULL,
  `uTotalUnit` varchar(20) NOT NULL,
  `uAmount` varchar(20) NOT NULL,
  PRIMARY KEY (`uID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `unit1`
--

INSERT INTO `unit1` (`uID`, `uAccNo`, `uEmail`, `uTotalUnit`, `uAmount`) VALUES
(7, '12568', 'SS@gmail.com', '12', '120'),
(8, '789578', 'r@gmail.com', '35', '350'),
(9, '5555', 't@gmail.com', '78', '780'),
(10, '323212', 'w%2540gmail.com', '78', '500'),
(11, '666', 'g@gmail.com', '80', '800'),
(12, '55', 'h@gmail.com', '55', '550');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
