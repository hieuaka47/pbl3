<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- ===============================================-->
<!--    Favicons-->
<!-- ===============================================-->
<link rel="apple-touch-icon" sizes="180x180"
	href="assets/img/favicons/apple-touch-icon.png">
<link rel="icon" type="image/png" sizes="32x32"
	href="assets/img/favicons/favicon-32x32.png">
<link rel="icon" type="image/png" sizes="16x16"
	href="assets/img/favicons/favicon-16x16.png">
<link rel="shortcut icon" type="image/x-icon"
	href="assets/img/favicons/favicon.ico">
<link rel="manifest" href="assets/img/favicons/manifest.json">
<meta name="msapplication-TileImage"
	content="assets/img/favicons/mstile-150x150.png">
<meta name="theme-color" content="#ffffff">


<!-- ===============================================-->
<!--    Stylesheets-->
<!-- ===============================================-->
<link href="assets/css/header_home.css" rel="stylesheet" />

</head>

<body>
	<main>
		<nav
			class="navbar navbar-expand-lg navbar-light fixed-top py-5 d-block nav-header"
			data-navbar-on-scroll="data-navbar-on-scroll" ${sessionScope.acc != null ? ' style="padding-bottom: 0 !important;
    padding-top: 0 !important;"' : 'style=""'}>
			<div class="container">
				<a class="navbar-brand" href="index.jsp"><img
					src="assets/img/logo.svg" height="34" alt="logo" /></a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"> </span>
				</button>
				<div
					class="collapse navbar-collapse border-top border-lg-0 mt-4 mt-lg-0"
					id="navbarSupportedContent">
					<ul
						class="navbar-nav ms-auto pt-2 pt-lg-0 font-base align-items-lg-center align-items-start">
						<li class="nav-item px-3 px-xl-4"><a
							class="nav-link fw-medium" aria-current="page" href="home">Home</a></li>
						<li class="nav-item px-3 px-xl-4"><a
							class="nav-link fw-medium" aria-current="page"
							href="list_blog">Blogs</a></li>
						<li class="nav-item px-3 px-xl-4"><a
							class="nav-link fw-medium" aria-current="page" href="list_tour">Tour</a></li>
						<c:if test="${sessionScope.acc.role != 1 }">
							<li class="nav-item px-3 px-xl-4"><a
								class="nav-link fw-medium" aria-current="page"
								${sessionScope.acc != null ? ' href="cart"' : 'href="login"'}>Cart</a></li>
						</c:if>
						<c:if test="${sessionScope.acc.role == 1 }">
							<li class="nav-item px-3 px-xl-4"><a
								class="nav-link fw-medium" aria-current="page" href="admin_home">Manager</a></li>
						</c:if>

						<c:if test="${sessionScope.acc != null }">
							<li class="nav__listitem nav-item px-3 px-xl-4"><a
								class="nav-link fw-medium" aria-current="page"
								onclick="return false;" href="#">Hello
									${sessionScope.acc.username }</a>
								<ul class="nav__listitemdrop">
									<li><a href="update_user">Your Profile</a></li>
									<li><a href="">Order</a></li>
									<li><a href="logout">Log out</a></li>
								</ul></li>
						</c:if>
						<c:if test="${sessionScope.acc == null }">
							<li class="nav-item px-3 px-xl-4"><a
								class="nav-link fw-medium" aria-current="page" href="login">Login</a></li>
						</c:if>

						<c:if test="${sessionScope.acc == null }">
							<li class="nav-item px-3 px-xl-4"><a
								class="btn btn-outline-dark order-1 order-lg-0 fw-medium"
								href="register">Sign Up</a></li>
						</c:if>
					</ul>
				</div>
			</div>
		</nav>
	</main>
	<script src="vendors/@popperjs/popper.min.js"></script>
	<script src="vendors/bootstrap/bootstrap.min.js"></script>
	<script src="vendors/is/is.min.js"></script>
	<script
		src="https://polyfill.io/v3/polyfill.min.js?features=window.scroll"></script>
	<script src="vendors/fontawesome/all.min.js"></script>
	<script src="assets/js/theme.js"></script>

	<link
		href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&amp;family=Volkhov:wght@700&amp;display=swap"
		rel="stylesheet">
</body>

</html>