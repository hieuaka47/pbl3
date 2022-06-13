<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA==" crossorigin="anonymous" />
  </head>
  <body>
    
    <jsp:include page="header_home.jsp"></jsp:include>
    
    <div class = "card-wrapper">
      <div class = "card">
        <!-- card left -->
        <div class = "product-imgs">
          <div class = "img-display">
            <div class = "img-showcase">
              <img src = "${detail_tour.img }" >
              <img src = "${detail_tour.img }" >
              <img src = "${detail_tour.img }" >
              <img src = "${detail_tour.img }" >
            </div>
          </div>
          <div class = "img-select">
            <div class = "img-item">
              <a href = "#" data-id = "1">
                <img src = "${detail_tour.img }" alt = "shoe image">
              </a>
            </div>
            <div class = "img-item">
              <a href = "#" data-id = "2">
                <img src = "${detail_tour.img }" alt = "shoe image">
              </a>
            </div>
            <div class = "img-item">
              <a href = "#" data-id = "3">
                <img src = "${detail_tour.img }" alt = "shoe image">
              </a>
            </div>
            <div class = "img-item">
              <a href = "#" data-id = "4">
                <img src = "${detail_tour.img }" alt = "shoe image">
              </a>
            </div>
          </div>
        </div>
        <!-- card right -->
        <div class = "product-content">
          <h2 class = "product-title">${detail_tour.name_tour }</h2>
          <a href = "#" class = "product-link">booking tour !!! <3</a>
          <div class = "product-rating">
            <i class = "fas fa-star"></i>
            <i class = "fas fa-star"></i>
            <i class = "fas fa-star"></i>
            <i class = "fas fa-star"></i>
            <i class = "fas fa-star-half-alt"></i>
            <span>4.7(21)</span>
          </div>

          <div class = "product-price">
            <p class = "last-price">Old Price: <span>5990000 đ</span></p>
            <p class = "new-price">New Price: <span>	            	
            		<fmt:setLocale value = "vi_VN"/>
         			<fmt:formatNumber value = "${detail_tour.price }" type = "currency"/></span></p>
          </div>

          <div class = "product-detail">
            <h2>about this tour: </h2>
            <p> 
            	Tour ${detail_tour.name_tour } với hành trình thú vị hứa hẹn 
            	sẽ là chuyến đi ý nghĩa nhất cho quý khách cùng gia đình, đưa du khách và gia đình khám phá những điểm đến đẹp nhất nơi đây <3 !
            	Hãy nhanh tay đăng ký tour để được trải nghiệm chương trình tour hấp dẫn với mức giá vô cùng ưu đãi! 
           	</p>
            <ul>
              <li>Tour duration: <span>${detail_tour.duration }</span></li>
              <li>Pick up location: <span>${detail_tour.pickup_locations }</span></li>
              <!--  <li>Departure day: <span>${detail_tour.date_start }</span></li>-->
              <li>Departure day: <span><fmt:formatDate pattern = "dd-MM-yyyy" 
         							value = "${detail_tour.date_start}" /></span></li>
              <li> Tour Category: <span>${detail_tour.cateID.name_cate }</span></li>
              <li>Slot available: <span>${detail_tour.quantity_max_tour }</span></li>
            </ul>
          </div>

          <div class = "purchase-info">
            <input type = "number" min = "0" value = "1">
            <button type = "button" class = "btn">
              Add to Cart <i class = "fas fa-shopping-cart"></i>
            </button>
            <button type = "button" class = "btn">Compare</button>
          </div>

          <div class = "social-links">
            <p>Share At: </p>
            <a class = "social-share-url facebook" href = "#">
              <i class = "fab fa-facebook-f"></i>
            </a>
            <a href = "#">
              <i class = "fab fa-twitter"></i>
            </a>
            <a href = "#">
              <i class = "fab fa-instagram"></i>
            </a>
            <a href = "#">
              <i class = "fab fa-whatsapp"></i>
            </a>
            <a href = "#">
              <i class = "fab fa-pinterest"></i>
            </a>
          </div>
        </div>
      </div>
    </div>
	
    <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js'></script>
    <script src="assets/js/script_detail_tour.js"></script>
    <jsp:include page="footer_home.jsp"></jsp:include>
  </body>
</html>