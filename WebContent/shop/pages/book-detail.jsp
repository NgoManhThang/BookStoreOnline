<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Aha Shop | Detail</title>
	<jsp:include page="head.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="header-menu.jsp"></jsp:include>
	
	<section class="section-wrap single-product">
		<div class="container relative">
			<div class="row">
				<div class="col-sm-6 col-xs-12 mb-60">
					<div class="flickity flickity-slider-wrap mfp-hover" id="gallery-main">
						<c:forEach begin="1" end="5" varStatus="status">
							<div class="gallery-cell">
				               <a href="<c:url value='/image?fileName=${bookShop.pathImage}'/>" class="lightbox-img">
				                 <img src="<c:url value='/image?fileName=${bookShop.pathImage}'/>" alt="" />
				                 <i class="icon arrow_expand"></i>
				               </a>
				             </div>
						</c:forEach>
					</div>
					
					<div class="gallery-thumbs">
						<c:forEach begin="1" end="5" varStatus="status">
							<div class="gallery-cell">
				            	<img src="<c:url value='/image?fileName=${bookShop.pathImage}'/>" alt="" />
				            </div>
						</c:forEach>
					</div>
				</div>
				
				<div class="col-sm-6 col-xs-12 product-description-wrap">
					<h1 class="product-title"><c:out value="${bookShop.bookName}"/></h1>
					
					<span class="price">
		              <ins>
		                <span class="ammount"><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${bookShop.price}"/></span>
	                    <span> VNĐ</span>
		              </ins>
		            </span>
		            
		            <p class="product-description"><c:out value="${bookShop.description}"/></p>
		            
		            <ul class="product-actions clearfix">
		            	<c:url value="/shop/addToCart?bookId=${bookShop.id}" var="addToCart"></c:url>
		            	<form action="${addToCart}" method="post">
		            		<li>
			            		<button type="submit" class="btn btn-color btn-sm add-to-cart left"><span>Thêm vào giỏ hàng</span></button>
				            </li>
				            <li>
				                <div class="quantity buttons_added">
				                  <input type="button" value="-" class="minus" />
				                  <input type="number" step="1" min="0" value="1" title="Qty" class="input-text qty text" name="quantity"/>
				                  <input type="button" value="+" class="plus" />
				                </div>
			              	</li>
		            	</form>
		            </ul>
		            
		            <div class="product_meta">
		              <span class="sku">Tác giả: <c:out value="${bookShop.author}"></c:out></span>
		              <span class="posted_in">Thể loại: <c:out value="${bookShop.categoryDecode}"></c:out> </span>
		            </div>
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-12">
					<div class="tabs tabs-bb">
						<ul class="nav nav-tabs">                                 
			                <li class="active">
			                  <a href="#tab-description" data-toggle="tab">Mô tả chi tiết</a>
			                </li>                                 
			                <li>
			                  <a href="#tab-info" data-toggle="tab">Information</a>
			                </li>                              
			             </ul>
			             
			             <div class="tab-content">
			             	<div class="tab-pane fade in active" id="tab-description">
			                  <p>
			                  	<c:out value="${bookShop.description}"/>
			                  </p>
			                </div>
			             </div>
					</div>
				</div>
			</div>
		</div>
	</section>
	
	<section class="section-wrap related-products pt-0">
		<div class="container">
			<div class="row heading-row">
	          <div class="col-md-12 text-center">
	            <h2 class="heading uppercase"><small>Sản phẩm khác</small></h2>
	          </div>
	        </div>
	        
	        <div class="row row-10">
	        	<div id="owl-related-products" class="owl-carousel owl-theme nopadding">
	        		<c:forEach items="${requestScope.listBooksShop}" var="book" varStatus="status">
	        			<div class="product-item">
	        				<c:url value="/shop/bookDetail?idBook=${book.id}" var="bookDetail"></c:url>
	        				<div class="product-img">
	        					<a href="${bookDetail}" style="height: 380px;">
				                  <img src="<c:url value='/image?fileName=${book.pathImage}'/>" alt="">
				                  <img src="<c:url value='/image?fileName=${book.pathImage}'/>" alt="" class="back-img">
				                </a>
				                <div class="product-actions">
				                  <a href="#" class="product-add-to-wishlist" data-toggle="tooltip" data-placement="bottom" title="Thêm vào giỏ hàng">
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
	        		</c:forEach>
	        	</div>
	        </div>
		</div>
	</section>
	
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>