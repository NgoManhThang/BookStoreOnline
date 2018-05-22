<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="sidebar" data-color="blue"
	data-image="assets/img/sidebar-5.jpg">
	<div class="sidebar-wrapper">
		<div class="logo">
			<div class="row">
				<img class="img-circle avatar" src="<c:url value='/image?fileName=${sessionScope.current_user.avatar}'/>"/>
				<label class="info-text">Xin chào ${sessionScope.current_user.name}</label>
			</div>
			<!-- <div class="row">
				<a href="https://www.facebook.com/ngomanhthang.1107" class="simple-text"> TRANG QUẢN TRỊ </a>
			</div> -->
			
		</div>
		<ul class="nav">
			<li class="active">
				<c:url value="/admin/pages/dashboard.jsp" var="dashboard"></c:url>
				<a href="${dashboard}">
					<i class="pe-7s-graph"></i>
					<p>Dashboard</p>
				</a>
			</li>
			<li>
				<c:url value="/searchBook" var="manageBook"></c:url>
				<a href="${manageBook}">
					<i class="pe-7s-user"></i>
					<p>Quản người dùng</p>
				</a>
			</li>
			<li>
				<c:url value="/searchBook" var="manageBook"></c:url>
				<a href="${manageBook}">
					<i class="pe-7s-science"></i>
					<p>Quản lý sách</p>
				</a>
			</li>
			<li>
				<c:url value="/searchBook" var="manageBook"></c:url>
				<a href="${manageBook}">
					<i class="pe-7s-shopbag"></i>
					<p>Quản đơn hàng</p>
				</a>
			</li>
		</ul>
	</div>
</div>
<div class="main-panel">
	<nav class="navbar navbar-default navbar-fixed">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">TRANG QUẢN TRỊ</a>
			</div>
			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav navbar-right">
					<li>
						<button type="button" class="btn btn-danger" style="border-radius: 20px;" title="Đăng xuất">
							<c:url value="/logout" var="logout"></c:url>
							<a href="${logout}"><i class="fa fa-sign-out"></i></a>
						</button>
					</li>
					<li class="separator hidden-lg"></li>
				</ul>
			</div>
		</div>
	</nav>
</div>
<!-- Start modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">...</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary">Save changes</button>
			</div>
		</div>
	</div>
</div>