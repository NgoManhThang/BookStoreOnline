<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LOGIN</title>
<jsp:include page="../login/header.jsp"></jsp:include>
</head>
<body>
	<nav class="navbar navbar-ct-transparent navbar-fixed-top" role="navigation-demo" id="register-navbar">
		<div class="container">
			<div class="row">
				<div class="col-xs-12 text-center">
					<h4 class="title-top">HỆ THỐNG QUẢN LÝ SÁCH</h5>
				</div>
			</div>
		</div>
	</nav>
	
	<div class="wrapper">
		<div class="register-background">
			<div class="filter-black"></div>
			
			<div class="container">
				<div class="row">
					<div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 col-xs-10 col-xs-offset-1 ">
						<div class="register-card">
							<h3 class="title">Đăng nhập</h3>
							<c:url value="/login" var="urlLogin"/>
							<form class="register-form" action="${urlLogin}" method="post">
								<label>UserName</label>
								<input type="text" class="form-control" placeholder="Nhập UserName" name="username">
								
								<label>Password</label>
								<input class="form-control" type="password" name="password" placeholder="Nhập PassWord">
								
								<button class="btn btn-danger btn-block" type="submit">ĐĂNG NHẬP</button>
							</form>
							<div class="forgot"></div>
						</div>
					</div>
				</div>
			</div>
			
			<div class="footer register-footer text-center">
				<h6>&copy; 2018, Coding <i class="fa fa-heart heart"></i> by Ngô Mạnh Thắng</h6>
			</div>
		</div>
	</div>
</body>
</html>