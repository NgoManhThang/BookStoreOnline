<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Aha Shop | Book Category</title>
	<jsp:include page="head.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="header-menu.jsp"></jsp:include>
	
	<section class="section-wrap pt-70 pb-40 catalogue">
		<div class="container relative">
			<div class="row">
				<div class="col-md-9 catalogue-col right mb-50">
					<div class="banner-wrap relative">
						<c:url value="/shop/assets/img/banner.jpg" var="banner"></c:url>
						<img src="${banner}" alt="">
						<div class="hero-holder text-center right-align">
			                <div class="hero-lines mb-0">
			                  <h1 class="hero-heading white">AHA SHOP | BOOK STORE</h1>
			                  <h4 class="hero-subheading white uppercase">Sách nào cũng có!</h4>
			                </div>
			             </div>
					</div>
					
					<div class="shop-filter">
						<p class="result-count">Trang <c:out value="${searchDto.page}"/> / <c:out value="${searchDto.totalPage}"/></p>
					</div>
					
					<div class="shop-catalogue grid-view left">
						<div class="row row-10 items-grid">
							<c:forEach items="${requestScope.listBooksShop}" var="book" varStatus="status">
								<div class="col-md-4 col-xs-6">
									<div class="product-item">
										<div class="product-img">
											<c:url value="/shop/bookDetail?idBook=${book.id}" var="bookDetail"></c:url>
											<a href="${bookDetail}" style="height: 380px">
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
								</div>
							</c:forEach>
						</div>
					</div>
					
					<div class="clear"></div>
					
					<div class="pagination-wrap">
						<p class="result-count">Trang <c:out value="${searchDto.page}"/> / <c:out value="${searchDto.totalPage}"/></p>
						<nav class="pagination right clear">
							<c:choose>
								<c:when test="${searchDto.page == 1}">
									<a href="#" disabled><i class="fa fa-angle-left"></i></a>
								</c:when>
								<c:otherwise>
									<c:url value='/shop/categoryBook?page=${searchDto.page - 1}' var="pagintion"/>
									<a href="${pagintion}"><i class="fa fa-angle-left"></i></a>
								</c:otherwise>
							</c:choose>
							<c:forEach begin="1" end="${requestScope.searchDto.totalPage}" varStatus="status">
								<c:url value='/shop/categoryBook?page=${status.count}' var="pagintion"/>
								<c:choose>
									<c:when test="${status.count == searchDto.page}">
											<a class="active-pagin" href="${pagintion}">
												<c:out value="${status.count}"></c:out>
											</a>
									</c:when>
									<c:otherwise>
											<a href="${pagintion}">
												<c:out value="${status.count}"></c:out>
											</a>
									</c:otherwise>
								</c:choose>
							</c:forEach>
							<c:choose>
								<c:when test="${searchDto.page == searchDto.totalPage}">
									<a disabled><i class="fa fa-angle-right"></i></a>
								</c:when>
								<c:otherwise>
									<c:url value='/shop/categoryBook?page=${searchDto.page + 1}' var="pagintion"/>
									<a href="${pagintion}"><i class="fa fa-angle-right"></i></a>
								</c:otherwise>
							</c:choose>
						</nav>
					</div>
				</div>
				
				<aside class="col-md-3 sidebar left-sidebar">
					<div class="widget categories">
						<h3 class="widget-title uppercase">Danh mục</h3>
						<ul class="list-no-dividers">
							<c:choose>
								<c:when test="${searchDto.category == 'TC'}">
									<li>
										<c:url value='/shop/categoryBook?category=' var="ALL"/>
					                  	<a href="${ALL}">Tất cả</a>
					                </li>
									<li class="active-cat">
										<c:url value='/shop/categoryBook?category=TC' var="TC"/>
					                  	<a href="${TC}">Tình cảm</a>
					                </li>
					                <li>
					                	<c:url value='/shop/categoryBook?category=KNS' var="KNS"/>
					                  	<a href="${KNS}">Kỹ năng sống</a>
					                </li>
								</c:when>
								<c:when test="${searchDto.category == 'KNS'}">
									<li>
										<c:url value='/shop/categoryBook?category=' var="ALL"/>
					                  	<a href="${ALL}">Tất cả</a>
					                </li>
									<li>
										<c:url value='/shop/categoryBook?category=TC' var="TC"/>
					                  	<a href="${TC}">Tình cảm</a>
					                </li>
					                <li class="active-cat">
					                	<c:url value='/shop/categoryBook?category=KNS' var="KNS"/>
					                  	<a href="${KNS}">Kỹ năng sống</a>
					                </li>
								</c:when>
								<c:otherwise>
									<li class="active-cat">
										<c:url value='/shop/categoryBook?category=' var="ALL"/>
					                  	<a href="${ALL}">Tất cả</a>
					                </li>
									<li>
										<c:url value='/shop/categoryBook?category=TC' var="TC"/>
					                  	<a href="${TC}">Tình cảm</a>
					                </li>
					                <li>
					                	<c:url value='/shop/categoryBook?category=KNS' var="KNS"/>
					                  	<a href="${KNS}">Kỹ năng sống</a>
					                </li>
								</c:otherwise>
							</c:choose>
						</ul>
					</div>
					
					<div class="widget filter-by-price clearfix">
						<c:url value="/shop/categoryBook" var="searchCategory"></c:url>
						<h3 class="widget-title uppercase">Lọc theo giá (x 1000 VND)</h3>
						<div id="slider-range"></div>
						<form action="${searchCategory}" method="post">
							<p>
						       <label for="amount">Giá:</label>
						       <input type="text" id="amount" readonly name="filterPrice" style="border:0;">
						       <button type="submit" class="btn btn-sm btn-dark">Lọc</button>
						   	</p>
						</form>
					</div>
				</aside>
				
			</div>
		</div>
	</section>
	
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>