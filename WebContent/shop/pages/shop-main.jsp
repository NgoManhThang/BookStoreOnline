<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Aha Shop | Book</title>
	<jsp:include page="head.jsp"></jsp:include>
</head>
<body class="relative">
	<jsp:include page="header-menu.jsp"></jsp:include>
	<section class="section-wrap nopadding">
		<div class="container">
			<div class="entry-slider">
				<div class="flexslider" id="flexslider-hero">
					<ul class="slides clearfix">
						<li>
							<c:url value="/shop/assets/img/slider/1.jpg" var="1"></c:url>
							<img src="${1}" alt="">
							<div class="img-holder img-1"></div>
							<div class="hero-holder right-align">
			                  <div class="hero-lines">
			                    <h1 class="hero-heading white">Cuốn theo chiều gió</h1>
			                    <h4 class="hero-subheading white uppercase">Hot sales 2018</h4>
			                  </div>
			                  <a href="#" class="btn btn-lg btn-white"><span>Chi tiết</span></a>
			                </div>
						</li>
						<li>
							<c:url value="/shop/assets/img/slider/2.jpg" var="2"></c:url>
							<img src="${2}" alt="">
							<div class="img-holder img-2"></div>
							<div class="hero-holder left-align">
			                  <div class="hero-lines">
			                    <h1 class="hero-heading white">Cuốn theo chiều gió</h1>
			                    <h4 class="hero-subheading white uppercase">Hot sales 2018</h4>
			                  </div>
			                  <a href="#" class="btn btn-lg btn-white"><span>Chi tiết</span></a>
			                </div>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</section>
	
	<section class="section-wrap new-arrivals pb-40">
		<div class="container">
			<div class="row heading-row">
	          <div class="col-md-12 text-center">
	            <h2 class="heading uppercase"><small>Sách mới nhất</small></h2>
	          </div>
	        </div>
			<div class="row row-10">
			<c:forEach begin="1" end="4" items="${requestScope.listBooksShop}" var="book" varStatus="status">
				<div class="col-md-3 col-xs-6">
					<div class="product-item">
						<c:url value="/shop/bookDetail?idBook=${book.id}" var="bookDetail"></c:url>
						<c:url value="/shop/addToCart?bookId=${book.id}" var="addToCart"></c:url>
						<div class="product-img">
							<a href="${bookDetail}" style="height: 380px">
			                  <img src="<c:url value='/image?fileName=${book.pathImage}'/>" alt="">
			                  <img src="<c:url value='/image?fileName=${book.pathImage}'/>" alt="" class="back-img">
			                </a>
			                <div class="product-actions">
			                  <a href="${addToCart}" class="product-add-to-wishlist" data-toggle="tooltip" data-placement="bottom" title="Thêm vào giỏ hàng">
			                    <i class="fa fa-cart-plus"></i>
			                  </a>                    
			                </div>
			                <a href="${bookDetail}" class="product-quickview">Xem chi tiết</a>
						</div>
						<div class="product-details">
							<h3>
			                  <a class="product-title" href="${bookDetail}"><c:out value="${book.bookName}"/></a>
			                </h3>
			                <span class="price">
			                  <ins>
			                    <span class="ammount"><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${book.price}"/></span>
			                    <span> VNĐ</span>
			                  </ins>
			                </span>
						</div>
					</div>
				</div>
			</c:forEach>
			</div>
		</div>
	</section>
	
	<div class="container">
		<div class="row">
			<div class="col-sm-12">
				<div class="newsletter-box">
					<h5 class="uppercase">Đăng ký nhận thông tin</h5>
					<form action="">
		              <input type="email" class="newsletter-input" placeholder="Nhập email của bạn">
		              <input type="submit" class="newsletter-submit btn btn-md btn-dark" value="Đăng ký">
		            </form>
				</div>
			</div>
		</div>
	</div>
	<section class="section-wrap pb-0">
		<div class="container">
			<div class="row heading-row">
	          <div class="col-md-12 text-center">
	            <h2 class="heading uppercase"><small>Sách bán chạy</small></h2>
	          </div>
	        </div>
	        
	        <div class="row row-10">
	        	<c:forEach begin="1" end="4" items="${requestScope.listBooksShop}" var="book" varStatus="status">
	        		<div class="col-md-3 col-xs-6 animated-from-left">
	        			<div class="product-item">
	        				<div class="product-img">
	        					<a href="#" style="height: 400px">
				                  <img src="<c:url value='/image?fileName=${book.pathImage}'/>" alt="">
				                  <img src="<c:url value='/image?fileName=${book.pathImage}'/>" alt="" class="back-img">
				                </a>
				                <div class="product-actions">
				                  <a href="#" class="product-add-to-wishlist" data-toggle="tooltip" data-placement="bottom" title="Thêm vào giỏ hàng">
				                    <i class="fa fa-cart-plus"></i>
				                  </a>                    
				                </div>
				                <a href="#" class="product-quickview">Xem chi tiết</a>
	        				</div>
	        				
	        				<div class="product-details">
				               <h3>
				                 <a class="product-title" href="shop-single-product.html"><c:out value="${book.bookName}"/></a>
				               </h3>
				               <span class="price">
				                 <ins>
				                    <span class="ammount"><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${book.price}"/></span>
				                    <span> VNĐ</span>
				                 </ins>
				               </span>
				             </div>
	        			</div>
	        		</div>
	        	</c:forEach>
	        </div>
		</div>
	</section>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>