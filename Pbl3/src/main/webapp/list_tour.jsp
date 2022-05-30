<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Tour</title>
    <!-- Bootstrap 5 CSS -->
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
      crossorigin="anonymous"
    />
    <link rel="icon" href="assets/img/favicons/favicon-16x16.png">
    <!-- Font Awesome 5 CSS -->
    <link
      rel="stylesheet"
      href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"
    />
    <!-- Products List CSS -->
    <link rel="stylesheet" href="assets/css/style_tour.css" />
    <!-- Demo CSS (No need to include it into your project) -->
    <link rel="stylesheet" href="assets/css/demo.css" />
</head>

<body>
	  <jsp:include page="header_home.jsp"></jsp:include>
	  <main>
      <!-- DEMO HTML -->
      <div class="container container1 bg-white">
        <nav class="navbar navbar-expand-md navbar-light bg-white 
        navbar1 navbar-expand-md1 navbar-light1 bg-white1">
          <div class="container-fluid p-0 
                      container-fluid1 p-01">
            <a class="navbar-brand text-uppercase fw-800
                      navbar-brand1 text-uppercase1 fw-8001" href="#"
              ><span class="border-red pe-2 border-red1 pe-21">All</span>Tour</a
            >
            <button
              class="navbar-toggler navbar-toggler1"
              type="button"
              data-bs-toggle="collapse"
              data-bs-target="#myNav"
              aria-controls="myNav"
              aria-expanded="false"
              aria-label="Toggle navigation"
            >
              <span class="fas fa-bars"></span>
            </button>
            <div class="collapse navbar-collapse collapse1 navbar-collapse1" id="myNav">
              <div id="nav-a" class="navbar-nav navbar-nav ms-auto 
              navbar-nav1 navbar-nav1 ms-auto1">
                <a ${tagAll != null ? ' class="nav-link nav-link nav-link1 active"' : 'class="nav-link nav-link nav-link1"'} aria-current="page" href="list_tour">All</a>
                <c:forEach items="${listC }" var="c">
                	<a ${tag == c.id_cate ? ' class="nav-link nav-link1 active"' : 'class="nav-link nav-link1"'} href="category_selected?id_cate=${c.id_cate }">${c.name_cate }</a>
                </c:forEach>
              </div>
            </div>
          </div>
        </nav>
        
        <div class="row row-cols-3">
        
			<c:forEach items="${listT }" var="t"  >
				
	          <div class="col d-flex flex-column align-items-center justify-content-center product-item my-3">
	            <div class="product">
	              <a href="#"><img src="${t.img }" alt="" /></a>
	              <ul class="d-flex align-items-center justify-content-center list-unstyled icons">
	                <li class="icon">
	                  <span class="fas fa-expand-arrows-alt"></span>
	                </li>
	                <li class="icon mx-3"><span class="far fa-heart"></span></li>
	                <li class="icon"><span class="fas fa-shopping-bag"></span></li>
	              </ul>
	            </div>
	            <!--<div class="tag bg-red">sale</div>-->
	            <div class="title pt-4 pb-1">
	            	<a href="#">${t.name_tour }</a>
	            </div>
	            <div class="d-flex align-content-center justify-content-center">
	              <span class="fas fa-star"></span>
	              <span class="fas fa-star"></span>
	              <span class="fas fa-star"></span>
	              <span class="fas fa-star"></span>
	              <span class="fas fa-star"></span>
	            </div>
	            <div class="price">${t.price } <span>d</span></div>
	            <div class="quantity_empty">Số chỗ còn nhận : <span>${t.quantity_max_tour }</span></div>
	          </div>
			
			</c:forEach>
			</div>
        </div>
      <!-- EMD DEMO HTML -->
    </main>
	<jsp:include page="footer_home.jsp"></jsp:include>

    <!-- Bootstrap 5 JS -->
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
      crossorigin="anonymous"
    ></script>
</body>
</html>