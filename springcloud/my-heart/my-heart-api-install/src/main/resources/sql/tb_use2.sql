/*
SQLyog Ultimate - MySQL GUI v8.2 
MySQL - 5.5.27 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `tb_user2` (
	`id` double ,
	`username` varchar (60),
	`password` varchar (60),
	`role` double 
); 
insert into `tb_user2` (`id`, `username`, `password`, `role`) values('1','mck','123','1');
insert into `tb_user2` (`id`, `username`, `password`, `role`) values('2','wxp','123','0');
insert into `tb_user2` (`id`, `username`, `password`, `role`) values('4','xiaoming','456','0');
