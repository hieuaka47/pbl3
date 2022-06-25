create database pbl3;
use pbl3;

CREATE TABLE `category_tour` (
  `id_cate` int NOT NULL auto_increment,
  `name_cate` varchar(255) collate utf8_unicode_ci default NULL,
  PRIMARY KEY  (`id_cate`)
) ;

INSERT INTO `category_tour`(name_cate) VALUES ('Tiết kiệm');
INSERT INTO `category_tour`(name_cate) VALUES ('Tiêu chuẩn');
INSERT INTO `category_tour`(name_cate) VALUES ('Cao cấp');

CREATE TABLE `tour` (
  `id_tour` int NOT NULL auto_increment,
  `id_cate` int not NULL,
  `name_tour` varchar(1000) collate utf8_unicode_ci default NULL,
  `img` varchar(500) collate utf8_unicode_ci default NULL,
  `price` double default NULL,
  `duration` varchar(255) NULL default NULL,
  `date_start` date collate utf8_unicode_ci default NULL,
  `pickup_locations` varchar(500) collate utf8_unicode_ci default NULL,
  `quantity_max_people` int collate utf8_unicode_ci default NULL,
  PRIMARY KEY  (`id_tour`),
  Foreign KEY(id_cate)REFERENCES category_tour(id_cate)
) ;

INSERT INTO `tour` VALUES ('1','1','Đà Nẵng - Bà Nà - Cầu Vàng - Sơn Trà - Biển Mỹ Khê - Hội An - Đà Nẵng',
				'assets/img/tour/bantayvang.jpg','5590000','3 ngày 2 đêm','2022-5-26','Truong DHBK','5');
INSERT INTO `tour` VALUES ('2','2','Đà Nẵng - Huế - Đầm Lập An - La Vang - Bà Nà - Cầu Vàng -Sơn Trà - Hội An',
				'assets/img/tour/suoikhoangnong.jpg','7490000','2 ngày 2 đêm','2022-5-26','Truong DHBK','6');
INSERT INTO `tour` VALUES ('3','3','Đà Nẵng - Bán Đảo Sơn Trà - Bà Nà - Rừng Dừa Bảy Mẫu - Phố Cổ Hội An',
				'assets/img/tour/rungdua7mau.jpg','10890000','3 ngày 2 đêm','2022-5-26','Truong DHBK','7');  
INSERT INTO `tour` VALUES ('4','2','Đà Nẵng - Bà Nà - Cầu Vàng - Hội An',
				'assets/img/tour/hoian.jpg','6490000','1 ngày 1 đêm','2022-5-26','Truong DHBK','8');  
INSERT INTO `tour` VALUES ('5','1','Huế - Đà Nẵng - Bà Nà - Hội An',
				'assets/img/tour/banahill.jpg','3690000','2 ngày 1 đêm','2022-5-26','Truong DHBK','5');  
INSERT INTO `tour` VALUES ('6','3','Đại học Bách Khoa Đà Nẵng - From KHDL With Love <3 !',
				'assets/img/tour/bkdn.jpg','9290000','4 ngày 3 đêm','2022-5-26','Truong DHBK','4');  

INSERT INTO `tour` VALUES ('7','1','Đà Nẵng - Bà Nà - Sơn Trà - Biển Mỹ Khê',
				'assets/img/tour/bantayvang.jpg','5190000','2 ngày 1 đêm','2022-5-26','Truong DHBK','5');
INSERT INTO `tour` VALUES ('8','1','Đà Nẵng - Cầu Vàng - Sơn Trà - Biển Mỹ Khê',
				'assets/img/tour/bantayvang.jpg','3190000','3 ngày 2 đêm','2022-5-26','Truong DHBK','5');
INSERT INTO `tour` VALUES ('9','1','Đà Nẵng - Bà Nà - Sơn Trà - Biển Mỹ Khê',
				'assets/img/tour/bantayvang.jpg','2190000','2 ngày 1 đêm','2022-5-26','Truong DHBK','5');
INSERT INTO `tour` VALUES ('10','1','Đà Nẵng - Bà Nà - Sơn Trà - Biển Mỹ Khê',
				'assets/img/tour/bantayvang.jpg','4190000','2 ngày 1 đêm','2022-5-26','Truong DHBK','5');
INSERT INTO `tour` VALUES ('11','1','Đà Nẵng - Bà Nà - Sơn Trà - Biển Mỹ Khê',
				'assets/img/tour/bantayvang.jpg','3690000','2 ngày 1 đêm','2022-5-26','Truong DHBK','5');
                
INSERT INTO `tour` VALUES ('12','2','Đà Nẵng - Bà Nà - Cầu Vàng - Sơn Trà - Biển Mỹ Khê - Hội An - Đà Nẵng',
				'assets/img/tour/bantayvang.jpg','6190000','3 ngày 2 đêm','2022-5-26','Truong DHBK','5');
INSERT INTO `tour` VALUES ('13','2','Đà Nẵng - Bà Nà - Cầu Vàng - Sơn Trà - Biển Mỹ Khê - Hội An - Đà Nẵng',
				'assets/img/tour/bantayvang.jpg','7190000','3 ngày 2 đêm','2022-5-26','Truong DHBK','5');
INSERT INTO `tour` VALUES ('14','2','Đà Nẵng - Bà Nà - Cầu Vàng - Sơn Trà - Biển Mỹ Khê - Hội An - Đà Nẵng',
				'assets/img/tour/bantayvang.jpg','6590000','3 ngày 2 đêm','2022-5-26','Truong DHBK','5');
INSERT INTO `tour` VALUES ('15','2','Đà Nẵng - Bà Nà - Cầu Vàng - Sơn Trà - Biển Mỹ Khê - Hội An - Đà Nẵng',
				'assets/img/tour/bantayvang.jpg','8190000','3 ngày 2 đêm','2022-5-26','Truong DHBK','5');
INSERT INTO `tour` VALUES ('16','2','Đà Nẵng - Bà Nà - Cầu Vàng - Sơn Trà - Biển Mỹ Khê - Hội An - Đà Nẵng',
				'assets/img/tour/bantayvang.jpg','7790000','3 ngày 2 đêm','2022-5-26','Truong DHBK','5');
INSERT INTO `tour` VALUES ('17','2','Đà Nẵng - Bà Nà - Cầu Vàng - Sơn Trà - Biển Mỹ Khê - Hội An - Đà Nẵng',
				'assets/img/tour/bantayvang.jpg','6890000','3 ngày 2 đêm','2022-5-26','Truong DHBK','5');
INSERT INTO `tour` VALUES ('18','2','Đà Nẵng - Bà Nà - Cầu Vàng - Sơn Trà - Biển Mỹ Khê - Hội An - Đà Nẵng',
				'assets/img/tour/bantayvang.jpg','6990000','3 ngày 2 đêm','2022-5-26','Truong DHBK','5');
INSERT INTO `tour` VALUES ('19','2','Đà Nẵng - Bà Nà - Cầu Vàng - Sơn Trà - Biển Mỹ Khê - Hội An - Đà Nẵng',
				'assets/img/tour/bantayvang.jpg','8990000','3 ngày 2 đêm','2022-5-26','Truong DHBK','5');
                
INSERT INTO `tour` VALUES ('33','2','Đà Nẵng - Bà Nà - Cầu Vàng - Sơn Trà - Biển Mỹ Khê - Hội An - Đà Nẵng',
				'assets/img/tour/bantayvang.jpg','8990000','3 ngày 2 đêm','2022-5-26','Truong DHBK','5');
INSERT INTO `tour` VALUES ('34','2','Đà Nẵng - Bà Nà - Cầu Vàng - Sơn Trà - Biển Mỹ Khê - Hội An - Đà Nẵng',
				'assets/img/tour/bantayvang.jpg','8990000','3 ngày 2 đêm','2022-5-26','Truong DHBK','5');
INSERT INTO `tour` VALUES ('35','2','Đà Nẵng - Bà Nà - Cầu Vàng - Sơn Trà - Biển Mỹ Khê - Hội An - Đà Nẵng',
				'assets/img/tour/bantayvang.jpg','8990000','3 ngày 2 đêm','2022-5-26','Truong DHBK','5');
INSERT INTO `tour` VALUES ('36','2','Đà Nẵng - Bà Nà - Cầu Vàng - Sơn Trà - Biển Mỹ Khê - Hội An - Đà Nẵng',
				'assets/img/tour/bantayvang.jpg','8990000','3 ngày 2 đêm','2022-5-26','Truong DHBK','5');
INSERT INTO `tour` VALUES ('37','2','Đà Nẵng - Bà Nà - Cầu Vàng - Sơn Trà - Biển Mỹ Khê - Hội An - Đà Nẵng',
				'assets/img/tour/bantayvang.jpg','8990000','3 ngày 2 đêm','2022-5-26','Truong DHBK','5');
                
INSERT INTO `tour` VALUES ('20','3','Đà Nẵng - Bán Đảo Sơn Trà - Bà Nà - Rừng Dừa Bảy Mẫu - Phố Cổ Hội An',
				'assets/img/tour/rungdua7mau.jpg','9190000','3 ngày 2 đêm','2022-5-26','Truong DHBK','7');  
INSERT INTO `tour` VALUES ('21','3','Đà Nẵng - Bán Đảo Sơn Trà - Bà Nà - Rừng Dừa Bảy Mẫu - Phố Cổ Hội An',
				'assets/img/tour/rungdua7mau.jpg','9590000','3 ngày 2 đêm','2022-5-26','Truong DHBK','7');  
INSERT INTO `tour` VALUES ('22','3','Đà Nẵng - Bán Đảo Sơn Trà - Bà Nà - Rừng Dừa Bảy Mẫu - Phố Cổ Hội An',
				'assets/img/tour/rungdua7mau.jpg','10190000','3 ngày 2 đêm','2022-5-26','Truong DHBK','7');  
INSERT INTO `tour` VALUES ('23','3','Đà Nẵng - Bán Đảo Sơn Trà - Bà Nà - Rừng Dừa Bảy Mẫu - Phố Cổ Hội An',
				'assets/img/tour/rungdua7mau.jpg','10790000','3 ngày 2 đêm','2022-5-26','Truong DHBK','7');  
INSERT INTO `tour` VALUES ('24','3','Đà Nẵng - Bán Đảo Sơn Trà - Bà Nà - Rừng Dừa Bảy Mẫu - Phố Cổ Hội An',
				'assets/img/tour/rungdua7mau.jpg','11190000','3 ngày 2 đêm','2022-5-26','Truong DHBK','7');  
INSERT INTO `tour` VALUES ('25','3','Đà Nẵng - Bán Đảo Sơn Trà - Bà Nà - Rừng Dừa Bảy Mẫu - Phố Cổ Hội An',
				'assets/img/tour/rungdua7mau.jpg','11990000','3 ngày 2 đêm','2022-5-26','Truong DHBK','7'); 
INSERT INTO `tour` VALUES ('26','3','Đà Nẵng - Huế - Đầm Lập An - La Vang - Rừng Dừa Bảy Mẫu - Phố Cổ Hội An',
				'assets/img/tour/rungdua7mau.jpg','12190000','5 ngày 4 đêm','2022-5-26','Truong DHBK','7');  
INSERT INTO `tour` VALUES ('27','3','Đà Nẵng - Huế - Đầm Lập An - La Vang - Rừng Dừa Bảy Mẫu - Phố Cổ Hội An',
				'assets/img/tour/rungdua7mau.jpg','129990000','5 ngày 4 đêm','2022-5-26','Truong DHBK','7');
                
CREATE TABLE `user` (
  `user_id` int NOT NULL auto_increment,
  `username` varchar(255) collate utf8_unicode_ci NOT NULL,
  `hoten` varchar(255) collate utf8_unicode_ci NOT NULL,
  `email` varchar(255) collate utf8_unicode_ci default NULL,
  `password` varchar(255) collate utf8_unicode_ci NOT NULL,
  `ngaysinh` date default NULL,
  `gioitinh` bit collate utf8_unicode_ci default NULL,
  `sdt` varchar(20) collate utf8_unicode_ci default NULL,
  `diachi` varchar(255) collate utf8_unicode_ci default NULL,
  `role` varchar(255) collate utf8_unicode_ci default NULL,
  PRIMARY KEY  (`user_id`)
)AUTO_INCREMENT=0 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
INSERT INTO `user` (username,hoten,email,password,ngaysinh,gioitinh,sdt,diachi,role) VALUES ('hieuAka47','Hieu Ngoc Giap', 'anhtutun@gmail.com','12345', '2002-10-11', 0, '0915789629', 'Son Giang', '1');
INSERT INTO `user` (username,hoten,email,password,ngaysinh,gioitinh,sdt,diachi,role) VALUES ('tan','Nhat Tan', 'tanlapro@gmail.com','tanyeutrang', '2002-10-19', 1, '0934744073', 'Hue', '2');
INSERT INTO `user` (username,hoten,email,password,ngaysinh,gioitinh,sdt,diachi,role) VALUES ('hieuaka47v2','Ngoc Hieu', 'giaphieu86@gmail.com','12345', '2002-10-11', 1, '0915789629', 'Son Giang', '1');

CREATE TABLE `history` (
  `id_history` int NOT NULL auto_increment,
  `user_id` int default NULL,
  `id_tour` int  default NULL,
  `ngay_mua` timestamp NULL default NULL,
  `so_luong` int default NULL,
  `thanh_tien` double default NULL,
  PRIMARY KEY  (`id_history`),
  Foreign KEY(id_tour) REFERENCES `tour`(id_tour)
) AUTO_INCREMENT=0;

CREATE TABLE `diadiem` (
  `idlocation` int(11) NOT NULL,
  `diadiem` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`idlocation`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `pbl3`.`diadiem` (`idlocation`, `diadiem`) VALUES ('1', 'Liên Chiểu');
INSERT INTO `pbl3`.`diadiem` (`idlocation`, `diadiem`) VALUES ('2', 'Hải Châu');
INSERT INTO `pbl3`.`diadiem` (`idlocation`, `diadiem`) VALUES ('3', 'Ngũ Hành Sơn');
INSERT INTO `pbl3`.`diadiem` (`idlocation`, `diadiem`) VALUES ('4', 'Cẩm Lệ');
INSERT INTO `pbl3`.`diadiem` (`idlocation`, `diadiem`) VALUES ('5', 'Thanh Khê');
INSERT INTO `pbl3`.`diadiem` (`idlocation`, `diadiem`) VALUES ('6', 'Sơn Trà');

CREATE TABLE `baiviet` (
  `idbaiviet` int(11) NOT NULL AUTO_INCREMENT,
  `idlocation` int(11) DEFAULT NULL,
  `title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `brief` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `noidung` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `img` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `img2` varchar(1000) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `img3` varchar(1000) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `img4` varchar(1000) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`idbaiviet`),
  KEY `idlocation` (`idlocation`),
  CONSTRAINT `baiviet_ibfk_1` FOREIGN KEY (`idlocation`) REFERENCES `diadiem` (`idlocation`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `pbl3`.`baiviet` (`idbaiviet`, `idlocation`, `title`, `brief`, `noidung`, `img`, `img2`, `img3`, `img4`) VALUES ('1', '1', 'Bãi biển Nam Ô',             'Du lịch Bãi biển Nam Ô tại Quận Liên Chiểu', 'Bãi biển hay rạn Nam Ô cách trung tâm 17km về phía tây bắc men dọc theo con đường biển tuyệt đẹp của Đà Nẵng với phong cảnh sơn thủy rất hữu tình. Ngoài ra, Nam Ô còn nức tiếng bởi món gỏi cá trứ danh. Đây được xem là điểm du lịch khám phá tuyệt vời cho giới trẻ hay khách du lịch đến Đà Nẵng.', 'https://images.vietnamtourism.gov.vn/vn/images/2021/Thang_5/ran_nam_o.jpeg', 'https://tophomestay.vn/upload/img/2021/09/26/bai_ran_nam_o_mua_reu_xanh_tai_da_nang_tophomestay_1_1632649420.jpg', 'https://baodanang.vn/dataimages/201902/original/images1500142_DSC_5341.jpg', 'https://cdn.vntrip.vn/cam-nang/wp-content/uploads/2018/01/ran-nam-o-da-nang-e1516328654834.png');
INSERT INTO `pbl3`.`baiviet` (`idbaiviet`, `idlocation`, `title`, `brief`, `noidung`, `img`, `img2`, `img3`, `img4`) VALUES ('2', '1', 'Suối Lương',                 'Du lịch Suối Lương tại Quận Liên Chiểu ', 'Khu du lịch sinh thái Suối Lương là một điểm hẹn du lịch sinh thái tuyệt vời ở Đà Nẵng. Khu du lịch sinh thái này được bao bọc bởi cánh rừng rậm rạp, tọa lạc ở phía nam hầm đèo Hải Vân, thuộc phường Hòa Hiệp Bắc, quận Liên Chiểu và cách trung tâm thành phố khoảng 15 km. Tìm về khu du lịch sinh thái Suối Lương, du khách sẽ được ngắm nhìn rừng cây xanh mát, tận hưởng những giây phút hòa mình, đắm chìm cùng thiên nhiên hoang dã nguyên sơ. Bên cạnh đó, khu du lịch này còn là nút thắt hội tụ văn hóa của ba miền đất nước, tái hiện không gian mang đậm sắc màu truyền thống đất Việt. Dạo quanh cánh rừng nguyên sinh bạt ngàn, đắm mình dưới dòng suối mát lạnh, lắng nghe những âm thanh của thiên nhiên ở khu du lịch sinh thái Suối Lương hẳn sẽ mang đến cho du khách những khám phá, trải nghiệm tuyệt vời trong chuyến du lịch Đà Nẵng.', 'https://dulichkhampha24.com/wp-content/uploads/2021/10/suoi-luong-3.jpg', 'https://images.vietnamtourism.gov.vn/vn/images/2019/CNMN/11.2._Suoi_Luong_mo_ao_trong_suong_1.jpg', 'https://www.danangxanh.com/data/images/suoi-hoa.jpg', 'https://www.danangxanh.com/data/images/suoi-hoa.jpg');
INSERT INTO `pbl3`.`baiviet` (`idbaiviet`, `idlocation`, `title`, `brief`, `noidung`, `img`, `img2`, `img3`, `img4`) VALUES ('3', '1', 'Chùa Quang Minh',            'Du lịch Chùa Quang Minh tại Quận Liên Chiểu ', 'Chùa Quang Minh tọa lạc tại đường Tôn Đức Thắng, phường Hòa Minh, quận Liên Chiểu, được xây dựng vào năm 1957. Trong khuôn viên chùa có pho tượng đức Phật Thích Ca lộ thiên nhìn ra quốc lộ. Tượng cao 20m, ngồi thiền định trên tòa sen hình lục giác rộng 8m, bệ xi măng cao 10m. Phật đài được xây dựng từ năm 1964, hoàn thành năm 1969, là pho tượng Phật lộ thiên lớn nhất nước ta bấy giờ. Có dịp đến Đà Nẵng, bạn không nên bỏ qua một chuyến tham quan, vãn cảnh Chùa Quang Minh, để có thể tìm đến chốn thanh tịnh, xua tan đi mọi mệt mỏi, lo toan của cuộc sống và khám phá những nét đẹp về văn hóa, truyền thống nơi đây.', 'https://mytourcdn.com/upload_images/Image/Articles%20Location/0news%20to%20location/Ch%C3%B9a%20Quang%20Minh/39034968.jpg', 'http://diadiembinhphuoc.vn/wp-content/uploads/2021/04/chuaquangminh-1.jpg', 'https://phatphapungdung.com/wp-content/uploads/2019/04/chua-quang-minh-noi-tiep-bien-giua-phat-giao-va-van-hoa-trung-hoa.jpg', 'https://mapio.net/images-p/25268443.jpg');
INSERT INTO `pbl3`.`baiviet` (`idbaiviet`, `idlocation`, `title`, `brief`, `noidung`, `img`, `img2`, `img3`, `img4`) VALUES ('4', '2', 'Asia Park',                  'Du lịch Asia Park tại Quận Hải Châu ', 'Được mệnh danh là kỳ quan nhân tạo của Đà Nẵng, Asia Park sở hữu hệ thống các trò chơi và giải trí cực kỳ hấp dẫn. Bạn có thể đi monorail ngắm cảnh công viên, hoặc lên ngay cabin Sunwheel để ngắm Đà Nẵng cả đêm lẫn ngày. Cùng với đó là các trò chơi từ giải trí nhẹ nhàng đến mạo hiểm, rùng rợn dành cho mọi đối tượng.', 'http://vyctravel.com/libs/upload/ckfinder/images/Da%20Nang/bao%20quat%20.jpg', 'http://vyctravel.com/libs/upload/ckfinder/images/Da%20Nang/bao%20quat%20.jpg', 'https://image.thanhnien.vn/w1024/Uploaded/2022/vocgmvbc/2022_04_20/asia-park-5270.jpg', 'https://dichoidanang.com/wp-content/uploads/2018/06/Cong-Thanh-2.jpg');
INSERT INTO `pbl3`.`baiviet` (`idbaiviet`, `idlocation`, `title`, `brief`, `noidung`, `img`, `img2`, `img3`, `img4`) VALUES ('5', '2', 'Sông Hàn',                   'Du lịch Sông Hàn tại Quận Hải Châu ', 'Du ngoạn sông Hàn về đêm là 1 trong những điểm nhấn nổi bật đối với du lịch Đà Nẵng. Bạn có thể chọn một chiếc thuyền, hoặc tàu để ăn tối, ngắm cảnh. Từ sông Hàn bạn có thể nhìn thấy những cây cầu đẹp nhất Đà Nẵng và cảnh thành phố hai bên sông.', 'https://images.foody.vn/res/g10/92434/prof/s576x330/foody-mobile-ve-may-bay-pleiku-di-635457710661927901.jpg', 'https://upload.wikimedia.org/wikipedia/commons/0/0c/Han_River_Bridge_Apr08.jpg', 'https://s3-ap-northeast-1.amazonaws.com/nem-vn.net/original/2020/07/ngam-nhin-da-nang-tho-mong-ben-bo-song-han-17-1594954316-9653.jpeg', 'https://cdn.vntrip.vn/cam-nang/wp-content/uploads/2017/07/cau-quay-song-han-khi-anh-den-ruc-ro.jpg');
INSERT INTO `pbl3`.`baiviet` (`idbaiviet`, `idlocation`, `title`, `brief`, `noidung`, `img`, `img2`, `img3`, `img4`) VALUES ('6', '2', 'Bảo tàng điêu khắc Chăm pa', 'Du lịch Bảo tàng điêu khắc Chăm pa tại Quận Hải Châu', 'Bảo tàng điêu khắc Chămpa, thường được dân chúng gọi là “Bảo tàng Chàm” (dịch từ Musée Cham ) nằm ở giao điểm đường Bạch Đằng và đường Trần Phú, thuộc quận Hải Châu, thành phố Đà Nẵng. Ngôi nhà được mô phỏng theo đường nét kiến trúc kiểu tháp Chăm cổ, nằm trong khuôn viên có nhiều cây sứ cổ thụ. Bảo tàng điêu khắc Chămpa xây phỏng theo mô típ của các kiến trúc Chămpa, khối nhà trưng bày màu trắng có đường nét trang trí tuy nhỏ nhưng đơn giản và duyên dáng.', 'https://mytourcdn.com/upload_images/Image/Location/13_3_2015/bao-tang-cham-pa-da-nang-mytour-1.jpg', 'https://media-cdn-v2.laodong.vn/Storage/newsportal/2019/3/1/659956/Anh-3.jpg', 'https://hanoimoi.com.vn/Uploads/images/phananh/2020/09/24/Baotang_Cham.jpg', 'https://cdnimg.vietnamplus.vn/t1200/Uploaded/ngtmbh/2020_10_02/ttxvn_bao_tang_dieu_khac_cham.jpg');
INSERT INTO `pbl3`.`baiviet` (`idbaiviet`, `idlocation`, `title`, `brief`, `noidung`, `img`, `img2`, `img3`, `img4`) VALUES ('7', '3', 'Chùa Linh Ứng',              'Du lịch Chùa Linh Ứng', 'Đã đến Ngũ Hành Sơn thì không thể bỏ qua ngôi chùa Linh Ứng trên ngọn Thuỷ Sơn. Được đặt ở vị trí trang trọng chính giữa chùa là tượng phật Thích Ca cao 10m với hai bên thờ Quan Thế Âm Bồ Tát và Bồ Tát Địa Tang. Nơi đây không chỉ thu hút nhiều du khách yêu thích du lịch tâm linh mà còn là nơi bạn có thể đắm mình vào chốn bình yên nơi cửa Phật và tránh xa nơi thị thành ồn ào náo nhiệt.', 'https://cdn.vntrip.vn/cam-nang/wp-content/uploads/2017/08/Chua-Linh-Ung-Non-Nuoc-e1502127371116.png', 'https://statics.vinpearl.com/chua-linh-ung-da-nang-1.jpg', 'https://danangfantasticity.com/wp-content/uploads/2019/09/chua-linh-ung-chon-binh-yen-giua-long-da-nang-013-2.jpg', 'https://icdn.dantri.com.vn/2020/11/04/chua-linh-ung-bai-but-2-1604500239592.jpg');
INSERT INTO `pbl3`.`baiviet` (`idbaiviet`, `idlocation`, `title`, `brief`, `noidung`, `img`, `img2`, `img3`, `img4`) VALUES ('8', '3', 'Động Huyền Không',           'Du lịch Động Huyền Không', 'Động Huyền Không là sở hữu phong cảnh đẹp nhất trong các động ở Ngũ Hành Sơn. Động nằm lộ thiên và có cấu trúc vô cùng độc đáo ấn tượng với các vòm hình tròn thông ra bên ngoài nên luôn tràn ngập áng sáng. Không chỉ đến để thăm quan, khách đến đây thường hoà mình vào không gian linh thiêng để cảm thấy tịnh tâm, thư thái.', 'https://cdn.vntrip.vn/cam-nang/wp-content/uploads/2017/08/Dong-Huyen-Khong-e1502127581461.png', 'https://statics.vinpearl.com/dong-huyen-khong-01_1634227224.jpg', 'https://cdn.yeudulich.com/940x630/media/attraction/attraction/23/1e/6826-052f-4824-9a58-dd4a2a5d83ce.jpg', 'https://lendang.vn/uploads/locations/full/locations_1422866691_e447e83e8fdc2a48eb987c6196afdb83.jpg');
INSERT INTO `pbl3`.`baiviet` (`idbaiviet`, `idlocation`, `title`, `brief`, `noidung`, `img`, `img2`, `img3`, `img4`) VALUES ('9', '4', 'Chăm Phong Lệ',              'Du lịch Chăm Phong Lệ', 'Di tích khảo cổ Chăm Phong Lệ thuộc phường Hòa Thọ Đông, quận Cẩm Lệ, thành phố Đà Nẵng. Di tích Chăm Phong Lệ (phường Hòa Thọ Đông, quận Cẩm Lệ) được phát lộ và thực hiện khai quật khảo cổ lần đầu trên diện tích 500 m2 theo Quyết định số 1666/QĐ-BVHTTDL ngày 4-5-2012 của Bộ Văn hóa, Thể thao và Du lịch. Đây là di tích tiêu biểu trong các di tích Chăm tại Đà Nẵng có điều kiện khảo sát đầy đủ nhất, đồng thời là di tích duy nhất cho đến nay trong toàn bộ hệ thống đền tháp Chăm có điều kiện để nghiên cứu và giới thiệu về phần nền móng kiến trúc.', 'link', 'link', 'link', 'libk');
INSERT INTO `pbl3`.`baiviet` (`idbaiviet`, `idlocation`, `title`, `brief`, `noidung`, `img`, `img2`, `img3`, `img4`) VALUES ('10', '5', 'Đình Thạc Gián',            'Du Lịch Đình Thạc Gián ', 'Sau khi thực hiện công cuộc khai khẩn, khai canh, khai cư, lập nên địa bộ Làng Thạc Gián, khi cư dân bước đầu có cuộc sống ổn định- Các Bậc Tiền nhân làng Thạc Gián lúc ấy đã theo phong tục tập quán của người Việt: Kêu gọi cư dân xây dựng Đình Làng Miếu Vũ nhằm đưa hồn thiêng quê cũ vào vùng quê mới. Thực hiện tín ngưỡng Thờ Phụng Tổ Phụ, Tổ Mẫu, Anh hùng dân tộc, các Bậc Tiền nhân. Đình Làng Thạc Gián đã được xếp hạng Di tích quốc gia-theo QĐ số 05/2007 của Bộ Văn Hóa Thể thao và Du lịch.', 'https://toquoc.mediacdn.vn/zoom/600_315/Uploaded/anhcinet/2018_05_25/dinh_1_EFUW.jpg', 'https://chothueleutrai.com/wp-content/uploads/2021/01/cam-trai-da-ngoai-thac-giang-dien1.jpg', 'https://upload.wikimedia.org/wikipedia/commons/thumb/2/23/Dinhlaxuyen.jpg/1200px-Dinhlaxuyen.jpg', 'https://gotrangtri.vn/wp-content/uploads/2018/05/nha-go-lim-2.jpg');

SELECT * FROM tour ORDER BY id_tour limit 0, 3;
SELECT COUNT(*) FROM tour;
RENAME TABLE  `category` TO  `category_tour`;
delete from category_tour;
select * from user;
select sum(thanh_tien), month(6) from `history`;
select * from user order by username desc;
select * from blog inner join category_blog on category_blog.id_cate = blog.id_cate order by blog.id_blog limit 3, 9;

select * from tour inner join category_tour on category_tour.id_cate = tour.id_cate where tour.id_cate=1 and concat(tour.name_tour,tour.price) like '%Bà nà%' order by tour.price limit 0, 5;
select * from tour inner join category_tour on category_tour.id_cate = tour.id_cate where concat(tour.name_tour,tour.price,category_tour.name_cate) like '%219%' order by tour.id_tour limit 0, 5;
select * from tour inner join category_tour on category_tour.id_cate = tour.id_cate order by tour.price desc limit 0, 5;
select count(*) from tour inner join category_tour on category_tour.id_cate = tour.id_cate where concat(tour.name_tour,tour.price,category_tour.name_cate) like '%219%';


