<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
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
	crossorigin="anonymous" />
<link rel="icon" href="assets/img/favicons/favicon-16x16.png">
<!-- Font Awesome 5 CSS -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" />
<link href="https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css"
	rel="stylesheet">
<!-- Products List CSS -->
<link rel="stylesheet" href="assets/css/style_tour.css" />
<!-- Demo CSS (No need to include it into your project) -->
<link rel="stylesheet" href="assets/css/demo.css" />
</head>
<jsp:include page="header_home.jsp"></jsp:include>
<body>
	<input type="hidden" id=cart_status
		value="<%=session.getAttribute("cart_status")%>">

	<main>
		<!-- DEMO HTML -->
		<div class="container container1 bg-white">
			<nav
				class="navbar navbar-expand-md navbar-light bg-white 
        navbar1 navbar-expand-md1 navbar-light1 bg-white1"
				style="margin-left: 0 !important; margin-right: 0 !important">
				<div
					class="container-fluid p-0 
                      container-fluid1 p-01">

					<button class="navbar-toggler navbar-toggler1" type="button"
						data-bs-toggle="collapse" data-bs-target="#myNav"
						aria-controls="myNav" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="fas fa-bars"></span>
					</button>

					<form
						action="list_tour?action=${action }&id_cate=${tag }&search=${txtSearch}&mode=${mode}"
						method="get" style="display: flex; align-items: center;">
						<input type="hidden" name="action" value="${action }">
						<input type="hidden" name="id_cate" value="${tag }">
						<div class="search" style="margin-right: 2rem;">
							<button type="submit">
								<i class="fas fa-search"></i>
							</button>
							<div class="input">
								<input value="${txtSearch}" name="search" type="text"
									id="mySearch" placeholder="Search" >
							</div>
							<span class="clear"
								onclick="document.getElementById('mySearch').value = ''"></span>
						</div>

						<div>
							<select name="selected"
								style="color: #000; height: 2.2rem; border-radius: 0.3rem;">
								<option ${mode == 'asc' ? 'selected="selected"' : ''}>Giá từ thấp đến cao</option>
								<option ${mode == 'desc' ? 'selected="selected"' : ''}>Giá từ cao đến thấp</option>
							</select>
						</div>

						<!--  <div class="select-menu">
							<div class="select-btn" style="border: 1px solid;">
								<c:if test="${mode ==  null}">
									<span class="sBtn-text">Giá</span>
								</c:if>
								<c:if test="${mode ==  'asc'}">
									<span class="sBtn-text">Giá từ thấp đến cao</span>
								</c:if>
								<c:if test="${mode ==  'desc'}">
									<span class="sBtn-text">Giá từ cao đến thấp</span>
								</c:if>
								<i class="bx bx-chevron-down"></i>
							</div>

							<ul class="options" style="border: 1px solid;">
								<a href="list_tour?action=sort&mode=asc">
									<li class="option"><span class="option-text">Giá từ
											thấp đến cao</span></li>
								</a>
								<a href="list_tour?action=sort&mode=desc">
									<li class="option"><span class="option-text">Giá từ
											cao đến thấp</span></li>
								</a>

							</ul>
						</div> -->

						<input type="submit" value="Search" class="input-search"
							style="margin-left: 2rem; width: 5rem; border: 1px solid; height: 2.1rem; border-radius: 0.3rem; font-weight: 500; background: #fff">

					</form>

					<div class="collapse navbar-collapse collapse1 navbar-collapse1"
						id="myNav">
						<div id="nav-a"
							class="navbar-nav navbar-nav ms-auto 
              navbar-nav1 navbar-nav1 ms-auto1">
							<a
								${tagAll != null ? ' class="nav-link nav-link nav-link1 active"' : 'class="nav-link nav-link nav-link1"'}
								aria-current="page" href="list_tour?action=viewAll&selected=null">All</a>
							<c:forEach items="${listC }" var="c">
								<a
									${tag == c.id_cate ? ' class="nav-link nav-link1 active"' : 'class="nav-link nav-link1"'}
									href="list_tour?id_cate=${c.id_cate }&action=viewWithCondition&selected=null">${c.name_cate }</a>
							</c:forEach>
						</div>
					</div>
				</div>
			</nav>

			<div class="row row-cols-3">

				<c:forEach items="${listT }" var="t">

					<div
						class="col tour-items d-flex flex-column align-items-center justify-content-center product-item my-3">
						<div class="product">
							<a href="detail_tour?id_tour=${t.id_tour }"><img
								src="${t.img }" alt="" /></a>
							<ul
								class="d-flex align-items-center justify-content-center list-unstyled icons">
								<a href="detail_tour?id_tour=${t.id_tour }"><li class="icon">
										<span class="fas fa-expand-arrows-alt"></span>
								</li> </a>
								<li class="icon mx-3"><span class="far fa-heart"></span></li>
								<li value="${t.id_tour }" class="icon"><span
									class="fas fa-shopping-bag"></span></li>
							</ul>
						</div>
						<!--<div class="tag bg-red">sale</div>-->
						<div class="title pt-4 pb-1 name-tour">
							<a href="detail_tour?id_tour=${t.id_tour }">${t.name_tour }</a>
						</div>
						<div class="d-flex align-content-center justify-content-center">
							<span class="fas fa-star"></span> <span class="fas fa-star"></span>
							<span class="fas fa-star"></span> <span class="fas fa-star"></span>
							<span class="fas fa-star"></span>
						</div>
						<div class="price">
							<fmt:setLocale value="vi_VN" />
							<fmt:formatNumber value="${t.price}" type="currency" />
						</div>
					</div>

				</c:forEach>
			</div>
		</div>

		<div class="page-number">
			<c:if test="${tagP > 1 }">
				<a
					href="list_tour?index=${tagP-1}&id_cate=${tag == null ? 'null' : tag }&search=${txtSearch}&action=${action}&selected=${mode}">&laquo;</a>
			</c:if>
			<c:if test="${tagP == 1 }">
				<a style="pointer-events: none; opacity: 0.5;"
					href="list_tour?index=${tagP}&id_cate=${tag == null ? 'null' : tag }&search=${txtSearch}&action=${action}&selected=${mode}">&laquo;</a>
			</c:if>
			<c:forEach begin="1" end="${endPage }" var="i">
				<a ${tagP == i ? ' class="active"' : 'class=""'}
					href="list_tour?index=${i }&id_cate=${tag == null ? 'null' : tag }&search=${txtSearch}&action=${action}&selected=${mode}">${i }</a>
			</c:forEach>
			<c:if test="${tagP < endPage }">
				<a
					href="list_tour?index=${tagP+1}&id_cate=${tag == null ? 'null' : tag }&search=${txtSearch}&action=${action}&selected=${mode}">&raquo;</a>
			</c:if>
			<c:if test="${tagP == endPage }">
				<a style="pointer-events: none; opacity: 0.5;"
					href="list_tour?index=${tagP}&id_cate=${tag == null ? 'null' : tag }&search=${txtSearch}&action=${action}&selected=${mode}">&raquo;</a>
			</c:if>
		</div>


		<!-- EMD DEMO HTML -->
	</main>
	<jsp:include page="footer_home.jsp"></jsp:include>

	<!-- Bootstrap 5 JS -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>

	<script>
    const optionMenu = document.querySelector(".select-menu"),
    selectBtn = optionMenu.querySelector(".select-btn"),
    options = optionMenu.querySelectorAll(".option"),
    sBtn_text = optionMenu.querySelector(".sBtn-text");

	selectBtn.addEventListener("click", () => optionMenu.classList.toggle("active"));       
	
	options.forEach(option =>{
	 option.addEventListener("click", ()=>{
	     let selectedOption = option.querySelector(".option-text").innerText;
	     sBtn_text.innerText = selectedOption;
	
	     optionMenu.classList.remove("active");
	 })
	})

    </script>

	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<link rel="stylesheet" href="alert/dist/sweetalert.css">


</body>
</html>