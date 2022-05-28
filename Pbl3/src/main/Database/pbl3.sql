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

INSERT INTO `tour` VALUES ('1','1','Đà Nẵng - Bà Nà - Cầu Vàng - Sơn Trà - Biển Mỹ Khê - Hội An - Đà Nẵng',
				'assets/img/tour/bantayvang.jpg','6190000','3 ngày 2 đêm','2022-5-26','Truong DHBK','5','10','','');
INSERT INTO `tour` VALUES ('2','2','Đà Nẵng - Huế - Đầm Lập An - La Vang - KDL Bà Nà - Cầu Vàng -Sơn Trà - Hội An',
				'assets/img/tour/suoikhoangnong.jpg','7190000','2 ngày 2 đêm','2022-5-26','Truong DHBK','6','8','','');
INSERT INTO `tour` VALUES ('3','3','Đà Nẵng - Bán Đảo Sơn Trà - Bà Nà Hills - Rừng Dừa Bảy Mẫu - Phố Cổ Hội An',
				'assets/img/tour/rungdua7mau.jpg','8190000','3 ngày 2 đêm','2022-5-26','Truong DHBK','7','9','','');  
INSERT INTO `tour` VALUES ('4','2','Đà Nẵng - Bà Nà - Cầu Vàng - Hội An',
				'assets/img/tour/hoian.jpg','6190000','1 ngày 1 đêm','2022-5-26','Truong DHBK','8','7','','');  
INSERT INTO `tour` VALUES ('5','1','Huế - Đà Nẵng - Bà Nà - Hội An',
				'assets/img/tour/banahill.jpg','6190000','2 ngày 1 đêm','2022-5-26','Truong DHBK','5','10','','');  
INSERT INTO `tour` VALUES ('6','3','Đại học Bách Khoa Đà Nẵng',
				'assets/img/tour/DHBKDN.jpg','10190000','4 ngày 3 đêm','2022-5-26','Truong DHBK','4','7','',''); 
				

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