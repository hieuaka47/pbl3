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
									<div id="myForm" class="container tm-mt-big tm-mb-big"
										 background: #EAECEE; z-index: 100; position: absolute; border-radius: 1rem; height: 39rem; width: 72rem;">
										<div class="row">
											<div class="col-xl-9 col-lg-10 col-md-12 col-sm-12 mx-auto"
												style="margin-top: 1rem;">
												<div class="tm-bg-primary-dark tm-block tm-block-h-auto">
													<div class="row">
														<div class="col-12">
															<h2 class="tm-block-title d-inline-block">Edit Tour</h2>
														</div>
													</div>
													<div class="row tm-edit-product-row">
													<div class="col-xl-6 col-lg-6 col-md-12">
														<form action="table_tour_handel" method="post" class="tm-edit-product-form" enctype="multipart/form-data">
														  <input type="hidden" name="action" value="addOrUpdate" />
														   <div class="form-group mb-3">
														    <label for="idTour">ID </label> <input readonly="readonly" value="${detail.id_tour }" id="idTour" name="idTour" type="text" class="form-control validate"
														      required />
														  </div>
														  <div class="form-group mb-3">
														    <label for="name">Tour Name </label> <input value="${detail.name_tour }" id="name" name="name" type="text" class="form-control validate"
														      required />
														  </div>
														
														  <div class="form-group mb-3">
														    <label for="category">Category</label>
														    <select required name="category" class="custom-select tm-select-accounts" id="category">
														      <c:forEach items="${listC }" var="c">
														        <option ${detail.cateID.id_cate== c.id_cate ? 'selected' : ''} value="${c.id_cate }">${c.name_cate }</option>
														      </c:forEach>
														    </select>
														  </div>
														  <div class="row">
														    <div class="form-group mb-3 col-xs-12 col-sm-6">
														      <label for="price">Price </label> <input value="${detail.price }" id="price" name="price" type="number" required
														        class="form-control validate" data-large-mode="true" />
														    </div>
														    <div class="form-group mb-3 col-xs-12 col-sm-6">
														      <label for="duration">Duration </label> <input value="${detail.duration }" id="duration" name="duration" type="text"
														        class="form-control validate" required />
														    </div>
														  </div>
														  <div class="row">
														    <div class="form-group mb-3 col-xs-12 col-sm-6">
														      <label for="start">Start </label> <input value="${detail.date_start }" id="start" required name="start" type="date"
														        class="form-control validate" data-large-mode="true" />
														    </div>
														    <div class="form-group mb-3 col-xs-12 col-sm-6">
														      <label for="pickup">Pickup </label> <input value="${detail.pickup_locations }" id="pickup" name="pickup" type="text" class="form-control validate"
														        required />
														    </div>
														  </div>
														  <div class="row">
														    <div class="form-group mb-3 col-xs-12 col-sm-6">
														      <label for="people">Max people </label> <input value="${detail.quantity_max_people }" id="people" name="people" type="number" required
														        class="form-control validate" data-large-mode="true" />
														    </div>
														  </div>
														  </div>
														  <div class="col-xl-6 col-lg-6 col-md-12 mx-auto mb-4" style="top: 2rem;">
														    <div class="tm-product-img-dummy mx-auto"
														      style="max-width: 100%; height: 240px; display: flex; align-items: center; justify-content: center; color: #fff; background: #aaa;">
														      <img id="upload" src="http://localhost:8080/Pbl3/${detail.img }" alt="tour image"
														        style="width: 100%; height: 100%;" />
														      <input type="hidden" name="img-tour" value="${detail.img }" />
														    </div>
														    <div class="custom-file mt-3 mb-3">
														      <input id="fileInput" type="file" style="display: none;" />
														      <input name="img-upload" type="file" id="imgInp" accept="image/*" class="btn btn-primary btn-block mx-auto" />
														    </div>
														  </div>
														  <div class="col-12" style="margin-bottom: 1rem">
														    <button type="submit" class="btn btn-primary btn-block text-uppercase">Edit
														      Tour Now</button>
														  </div>
														</form>
													</div>
												</div>
											</div>
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
		function openForm() {
			document.getElementById("myForm").style.display = "block";
		}

		function closeForm() {
			document.getElementById("myForm").style.display = "none";
		}
	</script>

	<script type="text/javascript">
		imgInp.onchange = evt => {
		  const [file] = imgInp.files
		  if (file) {
		    upload.src = URL.createObjectURL(file)
		  }
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