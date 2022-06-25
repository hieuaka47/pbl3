<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="DAO.*"%>
<%@page import="Model.*"%>
<%@page import="java.util.List"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="assets/css/style_history.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>History</title>
</head>
<body>
	<jsp:include page="header_home.jsp"></jsp:include>
	<div class="wrapper rounded"
		style="top: 6rem; position: relative; margin-bottom: 6rem;">
		<nav
			class="navbar navbar-expand-lg navbar-dark dark d-lg-flex align-items-lg-start">
			<a class="navbar-brand" href="#">HISTORY
				<p class="text-muted pl-1">Welcome to your History</p>
			</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarNav" aria-controls="navbarNav"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

		</nav>
		<div class="d-flex justify-content-between align-items-center mt-3">
			<ul class="nav nav-tabs w-75">
				<li class="nav-item"><a class="nav-link active" href="#history">History
						Order</a></li>
			</ul>
			<a class="btn btn-primary" href="home">Back to homepage</a>
		</div>
		<div class="table-responsive mt-3">
			<table class="table table-dark table-borderless">
				<thead>
					<tr>
						<th scope="col">Name Tour</th>
						<th scope="col">CATEGORY</th>
						<th scope="col">Date Order</th>
						<th scope="col" class="text-right">Total</th>
					</tr>
				</thead>
				<%
				NumberFormat nf = NumberFormat.getInstance();
				nf.setMinimumIntegerDigits(0);
				TourDAOImpl tourDAO = new TourDAOImpl();
				Category_tourDAOImpl cate = new Category_tourDAOImpl();
				HistoryDAOlmpl historyDAO = new HistoryDAOlmpl();
				User buyer = (User) session.getAttribute("loginUser");
				List<History> L = historyDAO.getList(buyer.getUser_id());
				
				%>
				<%
				if (L != null) {
					for (History h : L) {
				%>
				<tbody>
					<tr>
						<td><%=tourDAO.getTour(h.getId_tour()).getName_tour()%></td>
						<td><%=tourDAO.getTour(h.getId_tour()).getCateID().getName_cate()%></td>
						<td class="text-muted"><%=h.getDate_time()%></td>
						<td class="d-flex justify-content-end align-items-center"><span
							class="fa fa-long-arrow-up mr-1"></span> <%=nf.format(h.getPrice())%>VNĐ
						</td>
					</tr>
				</tbody>
				<%
				}
				}
				%>
			</table>
		</div>
		<div class="d-flex justify-content-between align-items-center results">
			<b class="text-white">Username: <%= buyer.getUsername() %></b>
			<div class="pt-3">
				<nav aria-label="Page navigation example">
					<ul class="pagination">
						<li class="page-item disabled"><a class="page-link" href="#"
							aria-label="Previous"> <span aria-hidden="true">&lt;</span>
						</a></li>
						<li class="page-item"><a class="page-link" href="#"
							aria-label="Next"> <span aria-hidden="true">&gt;</span>
						</a></li>
					</ul>
				</nav>
			</div>
		</div>
	</div>
	<jsp:include page="footer_home.jsp"></jsp:include>
</body>
</html>