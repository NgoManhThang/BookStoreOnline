<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Sửa thông tin sách</title>
	<jsp:include page="header.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="leftMenu.jsp"></jsp:include>
	<div class="main-panel content">
		<div class="container-fluid card header">
			<c:url value="/editBook?idBook=${book.id}" var="editBook"></c:url>
			<form action="${editBook}" method="post" enctype="multipart/form-data">
				<div class="row">
					<div class="col-sm-6">
						<div class="form-group text-center">
							<label>Ảnh minh họa</label><br>
							<img class="img-book-edit" src="<c:url value='/image?fileName=${book.pathImage}'/>"/>
						</div>
					</div>
					
					<div class="col-sm-6">
						<div class="form-group">
							<label>Tên sách</label>
							<input type="text" name="bookName" class="form-control" placeholder="Nhập tên sách" value="${book.bookName}">
						</div>
						<div class="form-group">
							<label>Giá sách</label>
							<input type="text" name="bookPrice" class="form-control" placeholder="Nhập giá sách" value="${book.price}">
						</div>
						<div class="form-group">
							<label>Tác giả</label>
							<input type="text" name="bookAuthor" class="form-control" placeholder="Nhập tên tác giả" value="${book.author}">
						</div>
						<div class="form-group">
							<label>Thể loại</label>
							<select class="form-control" name="category">
								<c:choose>
									<c:when test="${book.category == 'TC' }">
										<option value="TC" selected>Tình cảm</option>
										<option value="KNS">Kỹ năng sống</option>
									</c:when>
									<c:otherwise>
										<option value="TC">Tình cảm</option>
										<option value="KNS" selected>Kỹ năng sống</option>
									</c:otherwise>
								</c:choose>
							</select>
						</div>
						<div class="form-group">
							<label>Số lượng sách</label>
							<input type="number" name="bookQuantity" class="form-control" placeholder="Nhập số lượng sách" value="${book.quantity}">
						</div>
						<div class="form-group">
							<label>Mô tả sách</label>
							<input type="text" name="bookDecription" class="form-control" placeholder="Mô tả sách" value="${book.description}">
						</div>
						<div class="form-group">
							<label>Đính kèm ảnh</label>
							<input type="file" name="bookPicture" class="form-control">
						</div>
						<div class="form-group text-center">
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
</body>
</html>