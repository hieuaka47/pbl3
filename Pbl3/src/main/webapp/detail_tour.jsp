<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Detail Tour</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="assets/css/style_detail_tour.css">
<link rel="apple-touch-icon" sizes="180x180"
	href="assets/img/favicons/apple-touch-icon.png">
<link rel="icon" type="image/png" sizes="32x32"
	href="assets/img/favicons/favicon-32x32.png">
<link rel="icon" type="image/png" sizes="16x16"
	href="assets/img/favicons/favicon-16x16.png">
<link rel="shortcut icon" type="image/x-icon"
	href="assets/img/favicons/favicon.ico">
<link rel="manifest" href="assets/img/favicons/manifest.json">
<link rel="stylesheet"
	href="https://unpkg.com/swiper/swiper-bundle.min.css" />
<link rel="stylesheet"
	href="alert/dist/sweetalert.css" />
<meta name="msapplication-TileImage"
	content="assets/img/favicons/mstile-150x150.png">
<meta name="theme-color" content="#ffffff">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"
	integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA=="
	crossorigin="anonymous" />
</head>
<body
	style="background: linear-gradient(-225deg, #E3FDF5 0%, #FFE6FA 100%);">

	<jsp:include page="header_home.jsp"></jsp:include>

	<div class="card-wrapper">
		<div class="card">
			<!-- card left -->
			<div class="product-imgs">
				<div class="img-display">
					<div class="img-showcase">
						<img src="${detail_tour.img }"> <img
							src="${detail_tour.img }"> <img src="${detail_tour.img }">
						<img src="${detail_tour.img }">
					</div>
				</div>
				<div class="img-select">
					<div class="img-item">
						<a href="#" data-id="1"> <img src="${detail_tour.img }"
							alt="shoe image">
						</a>
					</div>
					<div class="img-item">
						<a href="#" data-id="2"> <img src="${detail_tour.img }"
							alt="shoe image">
						</a>
					</div>
					<div class="img-item">
						<a href="#" data-id="3"> <img src="${detail_tour.img }"
							alt="shoe image">
						</a>
					</div>
					<div class="img-item">
						<a href="#" data-id="4"> <img src="${detail_tour.img }"
							alt="shoe image">
						</a>
					</div>
				</div>
			</div>
			<!-- card right -->
			<div class="product-content">
				<h2 class="product-title">${detail_tour.name_tour }</h2>
				<a href="#" class="product-link">booking tour !!! <3</a>
				<div class="product-rating">
					<i class="fas fa-star"></i> <i class="fas fa-star"></i> <i
						class="fas fa-star"></i> <i class="fas fa-star"></i> <i
						class="fas fa-star-half-alt"></i> <span>4.7(21)</span>
				</div>

				<div class="product-price">
					<p class="last-price">
						Old Price: <span>5990000 đ</span>
					</p>
					<p class="new-price">
						New Price: <span> <fmt:setLocale value="vi_VN" /> <fmt:formatNumber
								value="${detail_tour.price }" type="currency" /></span>
					</p>
				</div>

				<div class="product-detail">
					<h2>about this tour:</h2>
					<p>Tour ${detail_tour.name_tour } với hành trình thú vị hứa hẹn
						sẽ là chuyến đi ý nghĩa nhất cho quý khách cùng gia đình, đưa du
						khách và gia đình khám phá những điểm đến đẹp nhất nơi đây <3 !
						Hãy nhanh tay đăng ký tour để được trải nghiệm chương trình tour
						hấp dẫn với mức giá vô cùng ưu đãi!</p>
					<ul>
						<li>Tour duration: <span>${detail_tour.duration }</span></li>
						<li>Pick up location: <span>${detail_tour.pickup_locations }</span></li>
						<!--  <li>Departure day: <span>${detail_tour.date_start }</span></li>-->
						<li>Departure day: <span><fmt:formatDate
									pattern="dd-MM-yyyy" value="${detail_tour.date_start}" /></span></li>
						<li>Tour Category: <span>${detail_tour.cateID.name_cate }</span></li>
					</ul>
				</div>
				<input id="addToCartValue" type="hidden"
					value="${detail_tour.id_tour }">
				<div class="purchase-info">
					<c:if test="${sessionScope.acc.role == 2}">
						<button id="addToCart" type="button" class="btn">
							Add to Cart <i class="fas fa-shopping-cart"></i>
						</button>
					</c:if>
					<c:if test="${sessionScope.acc == null}">
						<a href="login">
							<button type="button" class="btn">
								Add to Cart <i class="fas fa-shopping-cart"></i>
							</button>
						</a>
					</c:if>
					<button type="button" class="btn">Compare</button>
				</div>

				<div class="social-links">
					<p>Share At:</p>
					<a class="social-share-url facebook" href="#"> <i
						class="fab fa-facebook-f"></i>
					</a> <a href="#"> <i class="fab fa-twitter"></i>
					</a> <a href="#"> <i class="fab fa-instagram"></i>
					</a> <a href="#"> <i class="fab fa-whatsapp"></i>
					</a> <a href="#"> <i class="fab fa-pinterest"></i>
					</a>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer_home.jsp"></jsp:include>

	<script
		src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js'></script>
	<script src="assets/js/script_detail_tour.js"></script>
	<script src="assets/js/ajax.js"></script>
	<script src="assets/js/jquery-3.6.0.js"></script>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<link rel="stylesheet"
	href="alert/dist/sweetalert.css" />
	
</body>
</html>