<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Sign Up</title>

<!-- Font Icon -->
<link rel="stylesheet"
	href="assets/fonts/material-icon/css/material-design-iconic-font.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
<link rel="stylesheet"
	href="https://unicons.iconscout.com/release/v3.0.6/css/line.css">
<!-- Main css -->
<link rel="stylesheet" href="assets/css/style.css">
</head>
<body>
	<jsp:include page="header_home.jsp"></jsp:include>
	<input type="hidden" id="status"
		value="<%=request.getAttribute("status")%>">
	<input type="hidden" id="mess"
		value="<%=request.getAttribute("message")%>">
	<div class="main">

		<!-- Sing in  Form -->
		<section class="sign-in">
			<div class="container1">
				<div class="signin-content">
					<div class="signin-image">
						<figure>
							<img src="assets/img/signin-image.jpg" alt="sing up image">
						</figure>
						<a href="register" class="signup-image-link">Create an account</a>
					</div>

					<div class="signin-form">
						<h2 class="form-title">Sign in</h2>
						<form method="post" action="login" class="register-form"
							id="login-form">
							<div class="form-group">
								<label for="username"><i
									class="zmdi zmdi-account material-icons-name"></i></label> <input
									type="text" name="username" id="username" value="${username }"
									placeholder="Username" />
							</div>
							<div class="form-group">
								<label for="password"><i class="zmdi zmdi-lock"></i></label> <input
									type="password" name="password" id="password"
									value="${password }" placeholder="Password" />
							</div>
							<div class="form-group">
								<input type="checkbox" name="remember-me" id="remember-me"
									${cookie.passC != null ? 'checked' : ''} class="agree-term" />
								<label for="remember-me" class="label-agree-term"><span><span></span></span>Remember
									me</label>
							</div>
							<div class="form-group view-modal">
								<a href="#" onclick="return false;">Forgot Password ?</a>
							</div>
							<div class="form-group form-button">
								<input type="submit" name="signin" id="signin"
									class="form-submit" value="Log in" />
							</div>
						</form>
						<form method="post" action="forgotPassword">
							<div class="popup">
								<header>
									<span>Reset Password</span>
									<div class="close">
										<i class="uil uil-times"></i>
									</div>
								</header>
								<p>Enter your email address and we will send you a link to
									reset your password.</p>

								<div class="field">

									  <input type="email" id="email" name="email" placeholder="Your email" required>
								</div>
								<div class="tag-a">

									<button type="submit">Send password
											to phone</button>
								</div>
							</div>
						</form>
						<div class="social-login">
							<span class="social-label">Or login with</span>
							<ul class="socials">
								<li><a href="#"><i
										class="display-flex-center zmdi zmdi-facebook"></i></a></li>
								<li><a href="#"><i
										class="display-flex-center zmdi zmdi-twitter"></i></a></li>
								<li><a href="#"><i
										class="display-flex-center zmdi zmdi-google"></i></a></li>
							</ul>
						</div>
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
	<link rel="stylesheet" href="alert/dist/sweetalert.css">
	<script>
    const viewBtn = document.querySelector(".view-modal"),
    popup = document.querySelector(".popup"),
    close = popup.querySelector(".close"),
    field = popup.querySelector(".field"),
    input = field.querySelector("input"),
    copy = field.querySelector("button");

    viewBtn.onclick = ()=>{
      popup.classList.toggle("show");
    }
    close.onclick = ()=>{
      viewBtn.click();
    }

    copy.onclick = ()=>{
      input.select(); //select input value
      if(document.execCommand("copy")){ //if the selected text copy
        field.classList.add("active");
        copy.innerText = "Copied";
        setTimeout(()=>{
          window.getSelection().removeAllRanges(); //remove selection from document
          field.classList.remove("active");
          copy.innerText = "Copy";
        }, 3000);
      }
    }
  </script>

	<script type="text/javascript">
		var status = document.getElementById("status").value;
		var message = document.getElementById("mess").value;
		if (status === "nullErro") {
			swal("Sorry", "Please enter the full information ! <3", "error");
		}
		if (status === "failedAcc") {
			swal("Sorry", "Wrong Username or Password ! <3", "error");
		}
		if (message === "incorrect") {
			swal("Sorry", "Phone number are incorrect !", "error");
		}
		if (message === "correct") {
			swal("Congrats", "Password sent to the your phone. Please check and get your password !", "success");
		}
	</script>
<%
	request.removeAttribute("status");
	request.removeAttribute("message");
%>
</body>
<!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>