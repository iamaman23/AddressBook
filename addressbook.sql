/*
SQLyog Enterprise - MySQL GUI v7.02 
MySQL - 5.0.27-community-nt : Database - addressbook
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`addressbook` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `addressbook`;

/*Table structure for table `contact` */

DROP TABLE IF EXISTS `contact`;

CREATE TABLE `contact` (
  `id` int(100) NOT NULL auto_increment,
  `firstname` varchar(100) default NULL,
  `lastname` varchar(100) default NULL,
  `email` varchar(100) default NULL,
  `mobile` varchar(100) default NULL,
  `phone` varchar(100) default NULL,
  `address` varchar(1000) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `contact` */

insert  into `contact`(`id`,`firstname`,`lastname`,`email`,`mobile`,`phone`,`address`) values (3,'Aman','Modi','amanjainn23@gmail.com','9929977239','01412617418','Flat No 206 Sethi Colony Jaipur'),(4,'Rajesh','Modi','rajesh@gmail.com','9314519474','01412617418','Vaibhav Apt. Jaipur');

/*Table structure for table `login` */

DROP TABLE IF EXISTS `login`;

CREATE TABLE `login` (
  `username` varchar(100) default NULL,
  `password` varchar(100) default NULL,
  `usertype` varchar(100) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `login` */

insert  into `login`(`username`,`password`,`usertype`) values ('aman','aman','Admin'),('akshit','akshit123','User'),('rajesh','rajesh123','User'),('rajesh','rajesh123','User'),('jay','jay@123','User');

/*Table structure for table `registration` */

DROP TABLE IF EXISTS `registration`;

CREATE TABLE `registration` (
  `firstname` varchar(100) default NULL,
  `lastname` varchar(100) default NULL,
  `username` varchar(100) default NULL,
  `password` varchar(100) default NULL,
  `retypepassword` varchar(100) default NULL,
  `usertype` varchar(100) default NULL,
  `email` varchar(100) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `registration` */

insert  into `registration`(`firstname`,`lastname`,`username`,`password`,`retypepassword`,`usertype`,`email`) values ('Aman','Modi','aman','aman','aman','Admin','amanjainn23@gmail.com'),('Rajesh ','Modi','rajesh','rajesh123','rajesh123','User','rajeshmodi@gmail.com'),('Jay','Singh','jay','jay@123','jay@123','User','jay@gmail.com');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
