<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Thêm mới sách</title>
	<jsp:include page="header.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="leftMenu.jsp"></jsp:include>
	<div class="main-panel">
	<div class="content">
		<div class="container-fluid card">
			<div class="header">
			<c:url value="/insertBook" var="insertBook"/>
			<form action="${insertBook}" method="post" enctype = "multipart/form-data">
				<div class="row">
					<div class="col-sm-6">
						<div class="form-group">
							<label>Tên sách</label>
							<input type="text" name="bookName" class="form-control" placeholder="Nhập tên sách">
						</div>
						<div class="form-group">
							<label>Giá sách</label>
							<input type="number" name="bookPrice" class="form-control" placeholder="Nhập giá sách">
						</div>
						<div class="form-group">
							<label>Mô tả sách</label>
							<input type="text" name="bookDecription" class="form-control" placeholder="Mô tả sách">
						</div>
						<div class="form-group">
							<label>Đính kèm ảnh</label>
							<input type="file" name="bookPicture" class="form-control">
						</div>
					</div>
					
					<div class="col-sm-6">
						<div class="form-group">
							<label>Tác giả</label>
							<input type="text" name="bookAuthor" class="form-control" placeholder="Nhập tên tác giả">
						</div>
						<div class="form-group">
							<label>Số lượng sách</label>
							<input type="number" name="bookQuantity" class="form-control" placeholder="Nhập số lượng sách">
						</div>
						<div class="form-group">
							<label>Chọn thể loại</label>
							<select class="form-control" name="category">
								<option value="TC" selected>Tình cảm</option>
								<option value="KNS">Kỹ năng sống</option>
							</select>
						</div>
					</div>
				</div>
				
				<div class="row">
					<div class="col-sm-12 text-center">
						<div class="form-group">
							<button type="submit" class="btn btn-default">
								<i class="fa fa-save"></i> <span>Ghi lại</span>
							</button>
							<button type="button" class="btn btn-default">
								<c:url value="/searchBook" var="searchBook"></c:url>
								<i class="fa fa-mail-reply"></i> <a href="${searchBook}">Quay lại</a>
							</button>
						</div>
					</div>
				</div>
			</form>
			</div>
		</div>
	</div>	
	</div>
</body>
</html>