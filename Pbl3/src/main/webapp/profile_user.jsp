<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Your Profile</title>

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
<jsp:include page="header_home.jsp"></jsp:include>
<body>

	<input type="hidden" id="status"
		value="<%=session.getAttribute("status")%>">

	<div class="main">
		<style>
.main {
	background: linear-gradient(to top, rgb(251, 194, 235) 0%,
		rgb(166, 193, 238) 100%) !important;
}
</style>
		<!-- Sign up form -->
		<section class="signup">
			<div class="container1">
				<div class="signup-content">
					<div class="signup-form" style="width: 80% !important">
						<h2 class="form-title">Your Profile</h2>

						<form method="post" action="update_user" class="register-form"
							id="register-form">
							<div class="form-group">
								<label for="name"><i
									class="zmdi zmdi-account material-icons-name"></i></label> <input
									type="text" readonly="true" name="name" id="name"
									value="${sessionScope.acc.username }" />
							</div>
							<div class="form-group">
								<label for="yourname"><i
									class="zmdi zmdi-account material-icons-name"></i></label> <input
									type="text" name="yourname" id="yourname"
									value="${sessionScope.acc.hoten }" />
							</div>
							<div class="form-group">
								<label for="email"><i class="zmdi zmdi-email"></i></label> <input
									type="email" name="email" id="email"
									value="${sessionScope.acc.email }" />
							</div>
							<!-- 							<div class="form-group">
								<label for="password"><i class="zmdi zmdi-lock"></i></label> <input
									type="password" readonly="true" name="password" id="password" value="${sessionScope.acc.password }" />
							</div> -->
							<div class="form-group text-info">
								<span>Your Birthday</span>
							</div>
							<div class="form-group">
								<label for="birthday"><i class="zmdi zmdi-calendar-note"></i></label>
								<input type="date" name="birthday" id="birthday"
									value="${sessionScope.acc.ngaysinh }" />
							</div>
							<div class="form-group">
								<label for="gender"><i class="zmdi zmdi-male"></i> Male</label>
								<input type="radio" name="gender" value="false" id="gender"
									${sessionScope.acc.gioitinh == false ? 'checked' :''}>
							</div>
							<div class="form-group">
								<label for="gender"><i class="zmdi zmdi-female"></i>
									Female</label> <input type="radio" name="gender" value="true"
									id="gender"
									${sessionScope.acc.gioitinh == true ? 'checked' :''}>
							</div>
							<div class="form-group">
								<label for="number"><i
									class="zmdi zmdi-account-box-phone"></i></label> <input type="text"
									name="number" id="number" value="${sessionScope.acc.sdt }" />
							</div>
							<div class="form-group">
								<label for="address"><i class="zmdi zmdi-pin"></i></label> <input
									type="text" name="address" id="address"
									value="${sessionScope.acc.diachi }" />
							</div>

							<div class="form-group form-button"
								style="display: flex; justify-content: space-between;">
								<input type="submit" name="signup" id="signup"
									class="form-submit" value="Save" /> <input type="button"
									name="signup" id="signup"
									class="form-submit form-group view-modal"
									value="Change Password" />
							</div>
						</form>

					</div>

					<form method="post" id="changeSubmit">
						<div class="popup" style="border: 1px solid; top: 24rem;">
							<header>
								<span>Change Password</span>
								<div class="close">
									<i class="uil uil-times"></i>
								</div>
							</header>
							<p>Change Your Password</p>

							<div class="field"
								style="margin-top: 8px; border: 1px solid; border-radius: 0.5rem;">
								<input required="required" type="password" id="oldP" name="oldP"
									style="height: 1.7rem" placeholder="Current Password"
									required>
							</div>
							<div class="field"
								style="margin-top: 8px; border: 1px solid; border-radius: 0.5rem;">
								<input required="required" type="password" id="newP"
									name="newP" style="height: 1.7rem" placeholder="New Password"
									required>
							</div>
							<div class="field" 
								style="margin-top: 8px; border: 1px solid; border-radius: 0.5rem;">

								<input required="required" type="password" id="reNewP"
									name="reNewP" style="height: 1.7rem"
									placeholder="Confirm Password" required>
							</div>
							<div id="tag-a" class="tag-a">
								<button type="submit">Change Password</button>
							</div>
						</div>
					</form>

					<div class="signup-image">
						<figure>
							<img src="assets/img/signup-image.jpg" alt="sing up image">
						</figure>
					</div>
				</div>
			</div>
		</section>

		<jsp:include page="footer_home.jsp"></jsp:include>
	</div>
	<!-- JS -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="assets/js/main.js"></script>
	<script src="assets/js/ajax.js"></script>
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
  	if(status =="successUp"){
  		swal("Congrats", "Saved ! <3 ", "success");
  	}  
</script>
	<%
	session.removeAttribute("status");
	%>
</body>
<!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>