<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Sign Up</title>

<!-- Font Icon -->
<link rel="stylesheet"
	href="assets/fonts/material-icon/css/material-design-iconic-font.min.css">

<!-- Main css -->
<link rel="stylesheet" href="assets/css/style.css">
</head>
<body>
<jsp:include page="header_home.jsp"></jsp:include>
<input type="hidden"id="status" value="<%= request.getAttribute("status") %>">

	<div class="main">

		<!-- Sign up form -->
		<section class="signup">
			<div class="container1">
				<div class="signup-content">
					<div class="signup-form">
						<h2 class="form-title">Sign up</h2>
					
						<form method="post" action="register" class="register-form"
							id="register-form">
							<div class="form-group">
								<label for="name"><i
									class="zmdi zmdi-account material-icons-name"></i></label> <input
									type="text" name="name" id="name" placeholder="Username" />
							</div>
							<div class="form-group">
								<label for="yourname"><i
									class="zmdi zmdi-account material-icons-name"></i></label> <input
									type="text" name="yourname" id="yourname" placeholder="Your Name" />
							</div>
							<div class="form-group">
								<label for="email"><i class="zmdi zmdi-email"></i></label> <input
									type="email" name="email" id="email" placeholder="Your Email" />
							</div>
							<div class="form-group">
								<label for="password"><i class="zmdi zmdi-lock"></i></label> <input
									type="password" name="password" id="password" placeholder="Password" />
							</div>
							<div class="form-group">
								<label for="re-pass"><i class="zmdi zmdi-lock-outline"></i></label>
								<input type="password" name="re_pass" id="re_pass"
									placeholder="Repeat your password" />
							</div>
							<div class="form-group">
								<span>Your Birthday</span>
							</div>
							<div class="form-group">
								<label for="birthday"><i class="zmdi zmdi-calendar-note"></i></label>
								<input type="date" name="birthday" id="birthday"
									/>
							</div>
							<div class="form-group">
								<label for="gender"><i class="zmdi zmdi-male"></i> Male</label>
								<input type="radio" name="gender" id="gender" value="0" >
							</div>
							<div class="form-group">
								<label for="gender"><i class="zmdi zmdi-female"></i> Female</label>
								<input type="radio" name="gender" id="gender" value="1" >
							</div>
							<div class="form-group">
								<label for="number"><i class="zmdi zmdi-account-box-phone"></i></label>
								<input type="text" name="number" id="number"
									placeholder="Your Number" />
							</div>
							<div class="form-group">
								<label for="address"><i class="zmdi zmdi-pin"></i></label>
								<input type="text" name="address" id="address"
									placeholder="Your Address" />
							</div>
							<div class="form-group">
								<input type="checkbox" name="agree-term" id="agree-term"
									class="agree-term" /> <label for="agree-term"
									class="label-agree-term"><span><span></span></span>I
									agree all statements in <a href="#" class="term-service">Terms
										of service</a></label>
							</div>
							<div class="form-group form-button">
								<input type="submit" name="signup" id="signup"
									class="form-submit" value="Register" />
							</div>
						</form>
					</div>
					<div class="signup-image">
						<figure>
							<img src="assets/img/signup-image.jpg" alt="sing up image">
						</figure>
						<a href="login.jsp" class="signup-image-link">I am already
							member</a>
					</div>
				</div>
			</div>
		</section>

	<jsp:include page="footer_home.jsp"></jsp:include>
	</div>
	<!-- JS -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="assets/js/main.js"></script>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<link rel="stylesheet"href="alert/dist/sweetalert.css">

<script type="text/javascript">
	var status = document.getElementById("status").value;
  	if(status =="nullErro"){
  		swal("Sorry","Please enter the full information ! <3 ","error");
  	}  
  	if (status =="existAcc") {
  		swal("Sorry","Username already exists ! <3 ","error");
  	}
</script>
<% session.removeAttribute("status"); %>
</body>
<!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>