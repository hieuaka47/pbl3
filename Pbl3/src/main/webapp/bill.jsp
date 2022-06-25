<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="assets/css/bill.css">
    <title>Bill</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css">
    <script>
    	function Purchase(){
    		alert("Mua hàng thành công !!")
    	}    	
    </script>
</head>
<body>
	<jsp:include page="header_home.jsp"></jsp:include>
    <div class="container">
        <div class="row m-0">
            <div class="col-lg-7 pb-5 pe-lg-5">
                <div class="row">
                    <div class="col-12 p-5">
                        <img src="${bill.tour.img}"
                            alt="">
                    </div>
                    <div class="row m-0 bg-light">
                        <div class="col-md-4 col-6 ps-30 pe-0 my-4">
                            <p class="text-muted">Tour</p>
                            <p class="h5">${bill.name_tour }</p>
                        </div>
                        <div class="col-md-4 col-6  ps-30 my-4">
                            <p class="text-muted">Thời gian mở</p>
                            <p class="h5 m-0">Annual</p>
                        </div>
                        <div class="col-md-4 col-6 ps-30 my-4">
                            <p class="text-muted">Ngày Mua</p>
                            <p class="h5 m-0">${bill.buyDate }</p>
                        </div>
                        <div class="col-md-4 col-6 ps-30 my-4">
                            <p class="text-muted">Date Start</p>
                            <p class="h5 m-0">${bill.tour.date_start}</p>
                        </div>
                        <div class="col-md-4 col-6 ps-30 my-4">
                            <p class="text-muted">Số tour đã đặt</p>
                            <p class="h5 m-0">${bill.amount_tour }</p>
                        </div>
                        <div class="col-md-4 col-6 ps-30 my-4">
                            <p class="text-muted">DURATION</p>
                            <p class="h5 m-0">${bill.tour.duration }</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-5 p-0 ps-lg-4">
                <div class="row m-0">
                    <div class="col-12 px-4">
                        <div class="d-flex align-items-end mt-4 mb-2">
                            <h1>PAYMENT</h1>
                        </div>
                       <!--   <div class="d-flex justify-content-between mb-2">
                            <p class="textmuted">Quantity</p>
                            <p class="fs-14 fw-bold">1</p>
                            -->
                        </div>
                        <div class="d-flex justify-content-between mb-2">
                            <p class="textmuted">Subtotal</p>
                            <p class="fs-14 fw-bold">${bill.price } VNĐ</p>
                        </div>
                        <div class="d-flex justify-content-between mb-2">
                            <p class="textmuted">Gas Fee</p>
                            <p class="fs-14 fw-bold">10%</p>
                        </div>
                        <div class="d-flex justify-content-between mb-2">
                        </div>
                        <div class="d-flex justify-content-between mb-3">
                            <p class="textmuted fw-bold">Total</p>
                            <div class="d-flex align-text-top ">
                                <span class="h4">${bill.price * 0.9 } VNĐ</span>
                            </div>
                        </div>
                    </div>
                    <div class="col-12 px-0">
                        <div class="row bg-light m-0">
                            <div class="col-12 px-4 my-4">
                                <p class="fw-bold">Payment detail</p>
                            </div>
                            <div class="col-12 px-4">
                                <div class="d-flex  mb-4">
                                    <span class="">
                                        <p class="text-muted">ID USER</p>
                                        <input class="form-control" type="text" value="${bill.buyer.user_id }"
                                            placeholder="Name">
                                    </span>
                                    <span class="">
                                        <p class="text-muted">Email</p>
                                        <input class="form-control" type="text" value="${bill.buyer.email }"
                                            placeholder="Name">
                                    </span>
                                </div>
                                <div class="d-flex mb-5">
                                    <span class="me-5">
                                        <p class="text-muted">User Name</p>
                                        <input class="form-control" type="text" value="${bill.buyer.hoten }"
                                            placeholder="Name">
                                    </span>
                                    <span class="me-5">
                                        <p class="text-muted">Số Điện Thoại</p>
                                        <input class="form-control" type="text" value="${bill.buyer.sdt }"
                                            placeholder="Name">
                                    </span>
                                </div>
                            </div>
                        </div>
                        <div class="row m-0">
                            <div class="col-12  mb-4 p-0">
                                <a class="btn btn-primary" href="bill_payment" onclick="Purchase()">Purchase<span class="fas fa-arrow-right ps-2"></span>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="footer_home.jsp"></jsp:include>
</body>
</html>