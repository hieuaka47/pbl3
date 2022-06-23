<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Admin</title>

<!-- Custom fonts for this template -->
<link href="vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">
<link href="https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css"
	rel="stylesheet">
<!-- Custom styles for this template -->
<link href="css/sb-admin-2.min.css" rel="stylesheet">

<!-- Custom styles for this page -->
<link href="vendor/datatables/dataTables.bootstrap4.min.css"
	rel="stylesheet">

</head>
<jsp:include page="header_home.jsp"></jsp:include>
<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<jsp:include page="navbarAdmin.jsp"></jsp:include>

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">
				<!-- Begin Page Content -->
				<div class="container-fluid" style="margin-top: 4rem">
					<!-- DataTales Example -->
					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<h6 class="m-0 font-weight-bold text-primary">Table of Category Tour</h6>
						</div>
						<div class="card-body">
							<table class="table table-bordered" id="dataTable" width="100%"
								cellspacing="0">
								<thead>
									<div onclick="openFormC()" style="display: flex">
										<div style="font-size: 1.2rem; margin-bottom: 1rem">
											<a onclick="return false;" href=""
												style="margin-right: 2rem;"><i
												class="fas fa-plus-square"></i><span
												style="margin-left: 0.7rem;">Add Category</span></a>
										</div>
									</div>

									<div id="myFormC" class="container tm-mt-big tm-mb-big"
										style="display: none; background: #EAECEE; z-index: 100; position: absolute; border-radius: 1rem; height: 17rem; width: 44rem; left: 20%">
										<div class="row"
											style="align-items: center; justify-content: center;">
											<div class="col-xl-9 col-lg-10 col-md-12 col-sm-12 mx-auto"
												style="margin-top: 1rem;">
												<div class="tm-bg-primary-dark tm-block tm-block-h-auto">
													<div class="row" style="text-align: center;">
														<div class="col-12">
															<h2 class="tm-block-title d-inline-block">Add
																Category</h2>
														</div>
													</div>
													<div class="row tm-edit-product-row"
														style="align-items: center; justify-content: center;">
														<div class="col-xl-6 col-lg-6 col-md-12">
															<form action="tableCategoryHandel" method="post"
																class="tm-edit-product-form">
																<input type="hidden" name="action" value="addOrUpdate" />
																<div class="form-group mb-3" style="text-align: center;">
																	<label for="name">Category Name </label> <input
																		id="nameC" name="nameC" type="text"
																		class="form-control validate" required />
																</div>
																<div class="col-12" style="margin-bottom: 1rem">
																	<button type="submit"
																		class="btn btn-primary btn-block text-uppercase">Add
																		Category Now</button>
																</div>
																<div class="col-12">
																	<button onclick="closeFormC()" type="submit"
																		class="btn btn-primary btn-block text-uppercase">Close</button>
																</div>
															</form>
														</div>
													</div>
												</div>
											</div>
										</div>
								

										<tr>
											<th>ID</th>
											<th>Category Name</th>
											<th>Edit</th>
											<th>Delete</th>
										</tr>
								</thead>
								<tfoot>
									<tr>
										<th>ID</th>
										<th>Category Name</th>
										<th>Edit</th>
										<th>Delete</th>
									</tr>
								</tfoot>
								<tbody>
									<c:forEach items="${listC }" var="c">
										<tr>
											<td>${c.id_cate }</td>
											<td>${c.name_cate }</td>
											<td><a
												href="tableCategoryHandel?cid=${c.id_cate }&action=edit"><i
													class="fas fa-edit"
													style="font-size: 1.3rem; cursor: pointer;"></i></a></td>
											<td><a
												href="tableCategoryHandel?cid=${c.id_cate }&action=delete"><i
													class="fas fa-window-close "
													style="font-size: 1.3rem; cursor: pointer;"></i></a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>

			</div>
			<!-- /.container-fluid -->

		</div>
		<!-- End of Main Content -->

	</div>
	<!-- End of Content Wrapper -->

	</div>
	<!-- End of Page Wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- Logout Modal-->
	<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">Select "Logout" below if you are ready
					to end your current session.</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Cancel</button>
					<a class="btn btn-primary" href="login.html">Logout</a>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer_home.jsp"></jsp:include>
	<!-- Bootstrap core JavaScript-->

	<script>
		function openFormC() {
			document.getElementById("myFormC").style.display = "block";
		}

		function closeFormC() {
			document.getElementById("myFormC").style.display = "none";
		}
	</script>

	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="js/sb-admin-2.min.js"></script>

	<!-- Page level plugins -->
	<script src="vendor/datatables/jquery.dataTables.min.js"></script>
	<script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

	<!-- Page level custom scripts -->
	<script src="js/demo/datatables-demo.js"></script>

</body>

</html>