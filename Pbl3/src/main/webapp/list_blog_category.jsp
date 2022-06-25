<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Blogs</title>
<link rel="stylesheet" href="assets/css/style_blog.css">
<link href="https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="header_home.jsp"></jsp:include>

	<div class="projcard-container">
	  <div class="select-menu">
        <div class="select-btn">
            <span class="sBtn-text">${location.diadiem != null ? location.diadiem : 'All'  }</span>
            <i class="bx bx-chevron-down"></i>
        </div>

        <ul class="options">
			<a href="Post">
				<li class="option">
	                <i class="bx bx-ghost" style="color: #E1306C;"></i>
	                <span href="Post">All</span>
	            </li>
			</a>
			<c:forEach items="${list_diadiem}" var="c">
				<a href="list_blog_category?cid=${c.idlocation }">
					<li class="option">
		                <i class="bx bx-ghost" style="color: #E1306C;"></i>
		                <span class="option-text">${c.diadiem }</span>
		            </li>
				</a>
			</c:forEach>
        </ul>
      </div>
	  <c:forEach items="${list_baiviet}" var="b">
	  	<div class="projcard projcard-blue">
			<div class="projcard-innerbox">
				<img class="projcard-img"
					src="${b.img}" />
				<div class="projcard-textbox">
					<div class="projcard-title"><a href="detail_blog?pid=${b.idbaiviet}" title="View Baiviet">${b.title }</a></div>

					<div class="projcard-bar"></div>
					<div class="projcard-description">${b.brief }</div>
				
				</div>
			</div>
		</div>
		
	  </c:forEach>
	  
  	<div href="Post" class="page-number">
      
    </div>
    
    

	</div>
	<jsp:include page="footer_home.jsp"></jsp:include>
</body>
<script src="assets/js/style_blog.js"></script>
</html>