<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!-- Preloader -->
<div class="loader-mask">
  <div class="loader">
    <div></div>
    <div></div>
  </div>
</div>

<!-- Navigation -->
<header class="nav-type-1">
	<div class="container"><!-- Start top bar -->
	<div class="top-bar-line">
		<div class="row">
			<div class="top-bar-links">
				<ul class="col-sm-6 top-bar-acc">
					<c:url value="/shop/searchBook" var="main"></c:url>
	               <li class="top-bar-link"><a href="${main}">Shop book online</a></li>
	            </ul>
             
	            <ul class="col-sm-6 text-right top-bar-currency-language">
	            	<li>
		            	<div class="social-icons">
		                    <a href="#" title="Đăng nhập"><i class="fa fa-sign-in"></i></a>
		                 </div>
	            	</li>
	            </ul>
			</div>
		</div>
	</div>
</div><!-- end top bar -->

<nav class="navbar navbar-static-top">
	<div class="navigation" id="sticky-nav">
		<div class="container relative">
			<div class="row">
				<div class="navbar-header"> <!-- Start navbar-header -->
             <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse">
               <span class="sr-only">Toggle navigation</span>
               <span class="icon-bar"></span>
               <span class="icon-bar"></span>
               <span class="icon-bar"></span>
             </button>
             <!-- Mobile cart -->
             <div class="nav-cart mobile-cart hidden-lg hidden-md">
               <div class="nav-cart-outer">
                 <div class="nav-cart-inner">
                   <a href="#" class="nav-cart-icon">
                   	<c:out value="${fn:length(order.lstItems)}"></c:out>
                   </a>
                 </div>
               </div>
             </div>
          </div> <!-- end navbar-header -->
          
          <div class="header-wrap">
          	<div class="header-wrap-holder">
         			<!-- Search -->
               	<div class="nav-search hidden-sm hidden-xs">
                 	<form method="get">
                    	<input type="search" class="form-control" placeholder="Search">
                    	<button type="submit" class="search-button">
                      	<i class="icon icon_search"></i>
                    	</button>
                 	</form>
               	</div>
               	<!-- Logo -->
               	<div class="logo-container">
                 	<div class="logo-wrap text-center">
                 		<c:url value="/shop/assets/img/logo_dark.png" var="logo"/>
                 		<c:url value="/shop/searchBook" var="main"></c:url>
                   		<a href="${main}">
                     		<img class="logo" src="${logo}" alt="logo">
                   		</a>
                 	</div>
               	</div>
               	
              		<!-- Cart -->
               	<div class="nav-cart-wrap hidden-sm hidden-xs">
                 	<div class="nav-cart right">
                    <div class="nav-cart-outer">
                      <div class="nav-cart-inner">
                        <a href="#" class="nav-cart-icon">
                        	<c:out value="${fn:length(order.lstItems)}"></c:out>
                        </a>
                      </div>
                    </div>
                   	<div class="nav-cart-container">
                     <div class="nav-cart-items">
                     	<c:forEach items="${order.lstItems}" var="bookOrder" varStatus="status">
                     		<div class="nav-cart-item clearfix">
	                          <div class="nav-cart-img">
	                          	<c:url value="/image?fileName=${bookOrder.bookDto.pathImage}" var="img"></c:url>
	                            <a href="#">
	                              <img class="img-order" src="${img}" alt="">
	                            </a>
	                          </div>
	                          <div class="nav-cart-title">
	                            <a href="#" style="overflow: hidden;">
	                              <c:out value="${bookOrder.bookDto.bookName}"></c:out>
	                            </a>
	                            <div class="nav-cart-price">
	                              <span><c:out value="${bookOrder.quantity}"></c:out> x </span>
	                              <span><c:out value="${bookOrder.bookDto.price}"></c:out></span>
	                            </div>
	                          </div>
	                          <div class="nav-cart-remove">
	                          	<c:url value="/shop/removeItemInCart?id=${bookOrder.bookDto.id}" var="remove"></c:url>
	                            <a href="${remove}"><i class="icon icon_close"></i></a>
	                          </div>
	                        </div>
                     	</c:forEach>
                      </div> <!-- end cart items -->

                      <div class="nav-cart-summary">
                        <span>Tổng tiền</span>
                        <span class="total-price">
                        	<c:out value="${order.totalPayment}"></c:out> VNĐ
                        </span>
                      </div>

                      <div class="nav-cart-actions mt-20">
                        <a href="shop-cart.html" class="btn btn-md btn-dark"><span>Xem giỏ hàng</span></a>
                        <c:url value="/shop/insertOrder" var="addOrder"></c:url>
                        <a href="${addOrder}" class="btn btn-md btn-color mt-10"><span>Đặt hàng</span></a>
                      </div>
                   </div>
                 </div>
                 <div class="menu-cart-amount right">
                   <span>
                     Giỏ hàng / <a href="#"> <c:out value="${order.totalPayment}"></c:out> VNĐ</a>
                   </span>
                 </div>
              </div> <!-- end cart -->
         		</div>
          </div> <!-- end header wrap -->
            
            <div class="nav-wrap">
            	<div class="collapse navbar-collapse" id="navbar-collapse">
            		<ul class="nav navbar-nav">
            			<li class="dropdown">
            				<c:url value="/shop/searchBook" var="main"></c:url>
	                      	<a href="${main}">Trang chủ</a>
	                    </li>
                    <li class="dropdown">
                      <a href="#">Danh mục sách</a>
                      <i class="fa fa-angle-down dropdown-toggle" data-toggle="dropdown"></i>
                      <ul class="dropdown-menu">
                        <li>
                        	<c:url value='/shop/categoryBook?category=TC' var="TC"/>
                        	<a href="${TC}">Tình cảm</a>
                        </li>
                        <li>
                        	<c:url value='/shop/categoryBook?category=KNS' var="KNS"/>
                        	<a href="${KNS}">Kỹ năng sống</a>
                        </li>
                      </ul>
                    </li>
                    <li class="dropdown">
                      <a href="#">Blog</a>
                      <i class="fa fa-angle-down dropdown-toggle" data-toggle="dropdown"></i>
                      <ul class="dropdown-menu">
                        <li><a href="blog-standard.html">Standard</a></li>
                        <li><a href="blog-single.html">Single Post</a></li>
                      </ul>
                    </li>
            		</ul>
            	</div>
            </div>
				</div>
			</div>
		</div>
	</nav>
</header>