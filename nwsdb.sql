-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Oct 29, 2014 at 05:38 PM
-- Server version: 5.6.12-log
-- PHP Version: 5.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `nwsdb`
--
CREATE DATABASE IF NOT EXISTS `nwsdb` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `nwsdb`;

-- --------------------------------------------------------

--
-- Table structure for table `issued`
--

CREATE TABLE IF NOT EXISTS `issued` (
  `Issued_DoRefNo` varchar(250) NOT NULL,
  `issued_ForLocation` varchar(250) NOT NULL,
  `issued_Description` varchar(250) NOT NULL,
  `Issued_Date` date NOT NULL,
  `Issued_By` varchar(250) NOT NULL,
  `Total` double NOT NULL,
  PRIMARY KEY (`Issued_DoRefNo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `issued`
--

INSERT INTO `issued` (`Issued_DoRefNo`, `issued_ForLocation`, `issued_Description`, `Issued_Date`, `Issued_By`, `Total`) VALUES
('Min004', 'dff', 'fw', '2014-08-12', 'fdjgkj', 2000.34),
('mni002', 'sdfs', 'sfs', '2014-09-24', 'fdjgkj', 2000.34);

-- --------------------------------------------------------

--
-- Table structure for table `issued_item`
--

CREATE TABLE IF NOT EXISTS `issued_item` (
  `issueditem_RefNo` varchar(250) NOT NULL,
  `item_ID` varchar(250) NOT NULL,
  `issueditem_Qty` double NOT NULL,
  `issueditem_Uprice` double NOT NULL,
  PRIMARY KEY (`issueditem_RefNo`,`item_ID`),
  KEY `item_ID` (`item_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `issued_item`
--

INSERT INTO `issued_item` (`issueditem_RefNo`, `item_ID`, `issueditem_Qty`, `issueditem_Uprice`) VALUES
('Min004', 'abc', 333, 333),
('Min004', 'abcd', 444, 444),
('mni002', 'abc', 2222, 2222);

-- --------------------------------------------------------

--
-- Table structure for table `item`
--

CREATE TABLE IF NOT EXISTS `item` (
  `item_ID` varchar(250) NOT NULL,
  `item_Name` varchar(250) NOT NULL,
  `item_Des` varchar(250) NOT NULL,
  `item_Cat` varchar(250) NOT NULL,
  `item_Unit` varchar(100) NOT NULL,
  `item_Location` varchar(250) NOT NULL,
  `item_Uprice` double NOT NULL,
  `item_Qty` double NOT NULL,
  `item_Rlevel` double NOT NULL,
  PRIMARY KEY (`item_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `item`
--

INSERT INTO `item` (`item_ID`, `item_Name`, `item_Des`, `item_Cat`, `item_Unit`, `item_Location`, `item_Uprice`, `item_Qty`, `item_Rlevel`) VALUES
('abc', 'PVC', 'khjkhd', 'ma', 'm', 'jksjd', 34, 43, 3),
('abcd', 'tyre', 'jsdkj', 'jfdskj', 'pack', 'hfkjhf', 22, 3, 45);

-- --------------------------------------------------------

--
-- Table structure for table `recieved`
--

CREATE TABLE IF NOT EXISTS `recieved` (
  `grn_No` varchar(250) NOT NULL,
  `grn_Description` varchar(250) NOT NULL,
  `grn_Price` double NOT NULL,
  `grn_FromLocation` varchar(250) NOT NULL,
  PRIMARY KEY (`grn_No`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `recieved_item`
--

CREATE TABLE IF NOT EXISTS `recieved_item` (
  `grn_No` varchar(250) NOT NULL,
  `item_ID` varchar(250) NOT NULL,
  `grn_itemQty` double NOT NULL,
  `grn_itemUprice` double NOT NULL,
  PRIMARY KEY (`grn_No`,`item_ID`),
  KEY `item_ID` (`item_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `transfered`
--

CREATE TABLE IF NOT EXISTS `transfered` (
  `transfered_DNo` varchar(250) NOT NULL,
  `transfered_ForLocation` varchar(250) NOT NULL,
  `transfered_Description` varchar(250) NOT NULL,
  `transfered_Date` date NOT NULL,
  `Issued_By` varchar(250) NOT NULL,
  `Total` double NOT NULL,
  PRIMARY KEY (`transfered_DNo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transfered`
--

INSERT INTO `transfered` (`transfered_DNo`, `transfered_ForLocation`, `transfered_Description`, `transfered_Date`, `Issued_By`, `Total`) VALUES
('hskajfh', '', '', '2014-07-23', 'dkfkdsf', 2000.28),
('job22', 'dfds', 'fsf', '2014-09-22', 'dkfkdsf', 2000.28),
('job40', 'fs', 'sfs', '2014-08-24', 'dkfkdsf', 2000.28),
('kdshfjdfh', 'djlksjf', 'sfkjlkf', '2012-05-23', 'dkfkdsf', 2000.28),
('khsfk', '', '', '2014-09-23', 'dkfkdsf', 2000.28),
('kshjd', '', '', '2014-05-23', 'dkfkdsf', 2000.28),
('kskhf', 'kdhfkjhfkfhk', '.dsfslk', '2014-08-07', 'dkfkdsf', 2000.28),
('m33', 'dkjf', 'fnkjfnh', '2014-08-03', 'dkfkdsf', 2000.28);

-- --------------------------------------------------------

--
-- Table structure for table `transfered_item`
--

CREATE TABLE IF NOT EXISTS `transfered_item` (
  `transfered_No` varchar(250) NOT NULL,
  `item_ID` varchar(250) NOT NULL,
  `transfered_itemQty` double NOT NULL,
  `transfered_itemPrice` double NOT NULL,
  PRIMARY KEY (`transfered_No`,`item_ID`),
  KEY `item_ID` (`item_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transfered_item`
--

INSERT INTO `transfered_item` (`transfered_No`, `item_ID`, `transfered_itemQty`, `transfered_itemPrice`) VALUES
('hskajfh', 'abc', 233, 2),
('job22', 'abc', 9999, 9999),
('job22', 'abcd', 8888, 8888),
('job40', 'abcd', 222, 3333),
('khsfk', 'abc', 332, 23),
('kshjd', 'abc', 2, 34),
('m33', 'abc', 22, 52);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `issued_item`
--
ALTER TABLE `issued_item`
  ADD CONSTRAINT `issued_item_ibfk_1` FOREIGN KEY (`issueditem_RefNo`) REFERENCES `issued` (`Issued_DoRefNo`) ON DELETE CASCADE,
  ADD CONSTRAINT `issued_item_ibfk_2` FOREIGN KEY (`item_ID`) REFERENCES `item` (`item_ID`) ON DELETE CASCADE;

--
-- Constraints for table `recieved_item`
--
ALTER TABLE `recieved_item`
  ADD CONSTRAINT `recieved_item_ibfk_1` FOREIGN KEY (`item_ID`) REFERENCES `item` (`item_ID`) ON DELETE CASCADE,
  ADD CONSTRAINT `recieved_item_ibfk_2` FOREIGN KEY (`grn_No`) REFERENCES `recieved` (`grn_No`) ON DELETE CASCADE;

--
-- Constraints for table `transfered_item`
--
ALTER TABLE `transfered_item`
  ADD CONSTRAINT `transfered_item_ibfk_1` FOREIGN KEY (`transfered_No`) REFERENCES `transfered` (`transfered_DNo`) ON DELETE CASCADE,
  ADD CONSTRAINT `transfered_item_ibfk_2` FOREIGN KEY (`item_ID`) REFERENCES `item` (`item_ID`) ON DELETE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;




DROP PROCEDURE IF EXISTS add_item;
DELIMITER //
CREATE PROCEDURE add_item(IN pitem_id VARCHAR(250),IN pitem_qty double, IN pitem_uprice double)
 BEGIN
 DECLARE vitem_qty double;
 DECLARE vitem_price double;
 DECLARE vunit_price double;
 
 SELECT item_Qty,item_Uprice 
 into vitem_qty,vitem_price
 FROM item
 WHERE item_ID = pitem_id;
 
 set vunit_price= round((((pitem_qty*pitem_uprice)+(vitem_qty*vitem_price))/(vitem_qty+pitem_qty)),2) ;
 update  item set item_Qty=(vitem_qty+pitem_qty),item_Uprice=vunit_price where item_ID=pitem_id;
 END //
 
 
DELIMITER ;



DROP PROCEDURE IF EXISTS issue_item;
DELIMITER //
CREATE PROCEDURE issue_item(IN pitem_id VARCHAR(250),IN pitem_qty double, IN pitem_uprice double)
 BEGIN

 update  item set item_Qty=(item_Qty-pitem_qty) where item_ID=pitem_id;
 END //
 DELIMITER ;
 
