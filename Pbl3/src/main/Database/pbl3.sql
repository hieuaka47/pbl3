create database pbl3;
use pbl3;

CREATE TABLE `category` (
  `id_cate` int NOT NULL auto_increment,
  `name_cate` varchar(255) collate utf8_unicode_ci default NULL,
  PRIMARY KEY  (`id_cate`)
) ENGINE=MyISAM AUTO_INCREMENT=0 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `category`(name_cate) VALUES ('Tiet kiem');
INSERT INTO `category`(name_cate) VALUES ('Tieu chuan');
INSERT INTO `category`(name_cate) VALUES ('Cao cap');

CREATE TABLE `tour` (
  `id_tour` int NOT NULL auto_increment,
  `id_cate` int default NULL,
  `name_tour` varchar(1000) collate utf8_unicode_ci default NULL,
  `img` varchar(500) collate utf8_unicode_ci default NULL,
  `price` double default NULL,
  `duration` varchar(255) NULL default NULL,
  `date_start` date collate utf8_unicode_ci default NULL,
  `pickup_locations` varchar(500) collate utf8_unicode_ci default NULL,
  `quantity_max_people` int collate utf8_unicode_ci default NULL,
  `quantity_max_tour` int collate utf8_unicode_ci default NULL,
  `describe` text collate utf8_unicode_ci default NULL,
  `schedule` text collate utf8_unicode_ci default NULL,
  PRIMARY KEY  (`id_tour`),
  KEY `fk_tour_category` (`id_cate`)
) ENGINE=MyISAM AUTO_INCREMENT=0 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `user` (
  `user_id` int NOT NULL auto_increment,
  `username` varchar(255) collate utf8_unicode_ci NOT NULL,
  `email` varchar(255) collate utf8_unicode_ci default NULL,
  `password` varchar(255) collate utf8_unicode_ci NOT NULL,
  `ngaysinh` date default NULL,
  `gioitinh` varchar(10) collate utf8_unicode_ci default NULL,
  `sdt` varchar(20) collate utf8_unicode_ci default NULL,
  `diachi` varchar(255) collate utf8_unicode_ci default NULL,
  `role` varchar(255) collate utf8_unicode_ci default NULL,
  PRIMARY KEY  (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=0 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
--ALTER TABLE tablename AUTO_INCREMENT = 0;
--admin
INSERT INTO `user` (username,email,password,ngaysinh,gioitinh,sdt,diachi,role) VALUES ('Hieu Ngoc Giap', 'giaphieu86@gmail.com','12345', '2002-10-11', 'Nam', '0915789629', 'Son Giang', '1');
--user
INSERT INTO `user` (username,email,password,ngaysinh,gioitinh,sdt,diachi,role) VALUES ('Nhat Tan', 'tanlapro@gmail.com','tanyeuhanh', '2002-10-19', 'Nam', '0912345678', 'Hue', '2');