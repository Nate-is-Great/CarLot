-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 21, 2023 at 05:47 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `carlot`
--
CREATE DATABASE IF NOT EXISTS `carlot` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `carlot`;

-- --------------------------------------------------------

--
-- Table structure for table `car`
--

DROP TABLE IF EXISTS `car`;
CREATE TABLE `car` (
  `vin` char(17) NOT NULL,
  `year` smallint(5) UNSIGNED NOT NULL,
  `make` varchar(15) NOT NULL,
  `model` varchar(20) NOT NULL,
  `color` varchar(6) NOT NULL,
  `mileage` mediumint(8) UNSIGNED NOT NULL,
  `mpg` tinyint(4) NOT NULL,
  `salesPrice` float(8,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `car`
--

INSERT INTO `car` (`vin`, `year`, `make`, `model`, `color`, `mileage`, `mpg`, `salesPrice`) VALUES
('1N4AL2AP9CC137563', 2012, 'Nissan', 'Altima', 'Blue', 111000, 32, 12998.00),
('3LN6L5EC2HR618221', 2017, 'Lincoln', 'MKZ', 'Brown', 40000, 31, 24998.00),
('3N1CN7AP8GL819986', 2016, 'Nissan', 'Versa', 'Blue', 75000, 40, 14599.00),
('5FNRL5H68EB127236', 2014, 'Honda', 'Odyssey', 'White', 116000, 28, 18998.00),
('5XYPGDA55LG619686', 2020, 'Kia', 'Sorento', 'Grey', 24000, 26, 26998.00),
('JM1DE1KY4D0166118', 2013, 'Mazda', 'Mazda2', 'Blue', 118000, 34, 12599.00),
('JN1EV7AP2MM703855', 2021, 'Infiniti', 'Q50', 'Black', 24000, 29, 30998.00),
('KNDJT2A52D7496966', 2013, 'Kia', 'Soul', 'White', 93000, 30, 12599.00),
('SHHFK7G41KU218148', 2019, 'Honda', 'Civic', 'Grey', 35000, 36, 25998.00),
('WAUA7GFF2G1033202', 2016, 'Audi', 'A3', 'Silver', 47000, 28, 21998.00);

-- --------------------------------------------------------

--
-- Table structure for table `purchaseorder`
--

DROP TABLE IF EXISTS `purchaseorder`;
CREATE TABLE `purchaseorder` (
  `id` tinyint(3) UNSIGNED NOT NULL,
  `vin` char(17) NOT NULL,
  `datePurchased` date NOT NULL,
  `cost` float(8,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `purchaseorder`
--

INSERT INTO `purchaseorder` (`id`, `vin`, `datePurchased`, `cost`) VALUES
(1, '1N4AL2AP9CC137563', '2023-04-21', 10500.00),
(2, '3LN6L5EC2HR618221', '2023-04-18', 19800.00),
(3, '3N1CN7AP8GL819986', '2023-04-12', 12400.00),
(4, '5FNRL5H68EB127236', '2023-04-19', 14800.00),
(5, '5XYPGDA55LG619686', '2023-04-08', 20000.00),
(6, 'JM1DE1KY4D0166118', '2023-03-05', 9000.00),
(7, 'KNDJT2A52D7496966', '2023-03-18', 10000.00),
(8, 'WAUA7GFF2G1033202', '2023-03-21', 18600.00),
(9, 'SHHFK7G41KU218148', '2023-02-17', 18900.00),
(10, 'JN1EV7AP2MM703855', '2023-03-31', 26000.00);

-- --------------------------------------------------------

--
-- Table structure for table `salesorder`
--

DROP TABLE IF EXISTS `salesorder`;
CREATE TABLE `salesorder` (
  `id` tinyint(3) UNSIGNED NOT NULL,
  `vin` char(17) NOT NULL,
  `dateSold` date NOT NULL,
  `priceSold` float(8,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `salesorder`
--

INSERT INTO `salesorder` (`id`, `vin`, `dateSold`, `priceSold`) VALUES
(1, 'JM1DE1KY4D0166118', '2023-04-02', 11999.00),
(2, 'KNDJT2A52D7496966', '2023-04-04', 12399.00),
(3, 'WAUA7GFF2G1033202', '2023-04-20', 20999.00),
(4, 'SHHFK7G41KU218148', '2023-03-16', 24500.00),
(5, 'JN1EV7AP2MM703855', '2023-04-08', 28500.00);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `car`
--
ALTER TABLE `car`
  ADD PRIMARY KEY (`vin`);

--
-- Indexes for table `purchaseorder`
--
ALTER TABLE `purchaseorder`
  ADD PRIMARY KEY (`id`),
  ADD KEY `vin` (`vin`);

--
-- Indexes for table `salesorder`
--
ALTER TABLE `salesorder`
  ADD PRIMARY KEY (`id`),
  ADD KEY `vin` (`vin`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `purchaseorder`
--
ALTER TABLE `purchaseorder`
  MODIFY `id` tinyint(3) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `salesorder`
--
ALTER TABLE `salesorder`
  MODIFY `id` tinyint(3) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `purchaseorder`
--
ALTER TABLE `purchaseorder`
  ADD CONSTRAINT `purchaseorder_ibfk_1` FOREIGN KEY (`vin`) REFERENCES `car` (`vin`);

--
-- Constraints for table `salesorder`
--
ALTER TABLE `salesorder`
  ADD CONSTRAINT `salesorder_ibfk_1` FOREIGN KEY (`vin`) REFERENCES `car` (`vin`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
