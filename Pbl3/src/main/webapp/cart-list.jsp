<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.*"%>
<%@page import="DAO.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cart</title>
    <link rel="stylesheet" href="assets/css/style_cart.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://code.jquery.com/jquery-3.3.1.slim.min.js">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.bundle.min.js">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
	<jsp:include page="header_home.jsp"></jsp:include>
    <div class="px-4 px-lg-0 cart">
        <!-- For demo purpose -->
        <div class="container text-white py-5 text-center">
          <h1 class="display-4">TOUR CART</h1>
        </div>
        <!-- End -->
      
        <div class="pb-5">
          <div class="container">
            <div class="row ">
              <div class="col-lg-12 col-cart p-5 bg-white rounded mb-5">
      
                <!-- Shopping cart table -->
                <div class="table-responsive">
                  <table class="table">
                    <thead>
                      <tr>
                        <th scope="col" class="border-0 bg-light">
                          <div class="p-2 px-3 text-uppercase pro">Product</div>
                        </th>
                        <th scope="col" class="border-0 bg-light">
                          <div class="py-2 text-uppercase">Price</div>
                        </th>
                        <th scope="col" class="border-0 bg-light">
                          <div class="py-2 text-uppercase">Category</div>
                        </th>
                        <th scope="col" class="border-0 bg-light">
                          <div class="py-2 text-uppercase">Remove</div>
                        </th>
                      </tr>
                    </thead>
                    <tbody class="cart_list">
                    	<c:forEach items="${sessionScope.cart}" var="entry">
	                      <tr>
	                        <th scope="row" class="border-0">
	                          <div class="p-2 tour">
	                            <img src="${entry.value.tour.img}" alt="" width="70" class="img-fluid rounded shadow-sm">
	                            <div class="ml-3 d-inline-block align-middle">
	                              <h5 class="mb-0"> <a href="#" class="text-dark d-inline-block align-middle"> ${entry.value.tour.name_tour}</a></h5><span class="text-muted font-weight-normal font-italic d-block d-block-t">Tinh trang: Con`</span>
	                            </div>
	                          </div>
	                        </th>
	                        <td class="border-0 align-middle"><strong class="margin-price" >${entry.value.unitPrice}</strong></td>
	                        <td class="border-0 align-middle"><strong class="center">${entry.value.tour.cateID.name_cate }</strong></td>
	                        <td class="border-0 align-middle"><li value="${entry.key}" class="text-dark center"><i class="fa fa-trash"></i></li></td>
	                      </tr>                     	                      							                    
	                     </c:forEach>
                    </tbody>
                  </table>
                </div>

                <!-- End -->
              </div>
            </div>
      
            <div class="row py-5 p-4 bg-white rounded col-pay">
              <div class="col-lg-6">
                <div class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Coupon code</div>
                <div class="p-4">
                  <p class="font-italic mb-4">If you have a coupon code, please enter it in the box below</p>
                  <div class="input-group mb-4 border rounded-pill p-2">
                    <input type="text" placeholder="Apply coupon" aria-describedby="button-addon3" class="form-control border-0">
                    <div class="input-group-append border-0">
                      <button id="button-addon3" type="button" class="btn btn-dark px-4 rounded-pill"><i class="fa fa-gift mr-2"></i>Apply coupon</button>
                    </div>
                  </div>
                </div>
                <div class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Instructions for seller</div>
                <div class="p-4">
                  <p class="font-italic mb-4">If you have some information for the seller you can leave them in the box below</p>
                  <textarea name="" cols="30" rows="2" class="form-control"></textarea>
                </div>
              </div>
              <div class="col-lg-6">
                <div class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Order summary </div>
                <div class="p-4">
                  <p class="font-italic mb-4">Shipping and additional costs are calculated based on values you have entered.</p>
                  <ul class="list-unstyled mb-4">
	                  <!--    <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Order Subtotal </strong><strong>${t.total}</strong></li>
	                    <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Tax</strong><strong>$0.00</strong></li>
	                    <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Total</strong>
	                      <h5 class="font-weight-bold">$400.00</h5>
	                    </li>-->   
                  </ul><a href="add-order" class="btn btn-dark rounded-pill py-2 btn-block">Thanh Toán</a>
                </div>
              </div>
            </div>
      
          </div>
        </div>
      </div>
      <jsp:include page="footer_home.jsp"></jsp:include>
    <script src="assets/js/jquery-3.6.0.js" type="text/javascript"></script>
    <script src="assets/js/ajax.js" type="text/javascript"></script>
</body>
</html>
</body>
</html>