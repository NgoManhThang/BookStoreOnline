<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Quản lý sách</title>
<jsp:include page="header.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="leftMenu.jsp"></jsp:include>
	<div class="main-panel">
	<div class="content">
		<div class="container-fluid card">
			<div class="header">
				<c:url value="/searchBook" var="searchBook"></c:url>
				<form action="${searchBook}">
					<div class="row">
						<div class="col-sm-4">
							<div class="form-group">
								<label>Tên sách</label>
								<input type="text" name="bookName" class="form-control" value="${searchDto.bookName}"
								placeholder="Nhập tên sách">
							</div>
						</div>
						<div class="col-sm-4">
							<div class="form-group">
								<label>Tác giả</label>
								<input type="text" name="bookAuthor" class="form-control" placeholder="Nhập tên tác giả">
							</div>
						</div>
						<div class="col-sm-4">
							<div class="form-group">
								<label>Số lượng sách</label>
								<input type="number" name="bookQuantity" class="form-control" placeholder="Nhập số lượng sách">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-12 text-center">
							<button type="submit" class="btn btn-default">
								<i class="fa fa-search"></i> <span>Tìm kiếm</span>
							</button>
							<button type="button" class="btn btn-default">
								<c:url value="/admin/pages/insert-book.jsp" var="insert"></c:url>
								<i class="fa fa-plus-circle"></i> <a href="${insert}">Thêm mới</a>
							</button>
						</div>
					</div>
				</form>
				<div class="content table-responsive table-full-width table-admin">
					<table class="table table-hover table-bordered">
						<thead>
							<tr>
								<th>STT</th>
								<th>Tên sách</th>
								<th>Giá (VND)</th>
								<th>Số lượng</th>
								<th>Tác giả</th>
								<th>Thể loại</th>
								<th>Ảnh</th>
								<th>Hành động</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${requestScope.listBooks}" var="book" varStatus="status">
								<tr>
									<td class="text-center">${(searchDto.page-1)*searchDto.pageSize + status.count}</td>
									<td><c:out value="${book.bookName}"/></td>
									<td><c:out value="${book.price}"/></td>
									<td><c:out value="${book.quantity}"/></td>
									<td><c:out value="${book.author}"/></td>
									<td><c:out value="${book.category}"/></td>
									<td class="text-center"><img class="img-book" src="<c:url value='/image?fileName=${book.pathImage}'/>"/></td>
									<td class="text-center">
										<c:url value="/editBook?idBook=${book.id}" var="editBook"></c:url>
										<a href="${editBook}" title="Sửa"><i class="fa fa-edit"></i></a>
										
										<c:url value="/deleteBook?idBook=${book.id}" var="deleteBook"></c:url>
										<a href="${deleteBook}" title="Xóa"><i class="fa fa-times-circle"></i></a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="row">
					<div class="col-sm-8" style="margin-top: -36px;">
						<ul class="pagination">
							<c:choose>
								<c:when test="${searchDto.page == 1}">
									<li class="page-item"><a class="page-link" disabled>Trước</a></li>
								</c:when>
								<c:otherwise>
									<c:url value='/searchBook?page=${searchDto.page - 1}' var="pagintion"/>
									<li class="page-item"><a class="page-link" href="${pagintion}">Trước</a></li>
								</c:otherwise>
							</c:choose>
							<c:forEach begin="1" end="${requestScope.searchDto.totalPage}" varStatus="status">
								<c:url value='/searchBook?page=${status.count}' var="pagintion"/>
								<c:choose>
									<c:when test="${status.count == searchDto.page}">
										<li class="page-item active">
											<a class="page-link" href="${pagintion}">
												<c:out value="${status.count}"></c:out>
											</a>
										</li>
									</c:when>
									<c:otherwise>
										<li class="page-item">
											<a class="page-link" href="${pagintion}">
												<c:out value="${status.count}"></c:out>
											</a>
										</li>
									</c:otherwise>
								</c:choose>
							</c:forEach>
							<c:choose>
								<c:when test="${searchDto.page == searchDto.totalPage}">
									<li class="page-item"><a class="page-link" disabled>Sau</a></li>
								</c:when>
								<c:otherwise>
									<c:url value='/searchBook?page=${searchDto.page + 1}' var="pagintion"/>
									<li class="page-item"><a class="page-link" href="${pagintion}">Sau</a></li>
								</c:otherwise>
							</c:choose>
						</ul>
					</div>
					<div class="col-sm-4">
						<label style="float: right; color: black;">Trang <c:out value="${searchDto.page}"/> / <c:out value="${searchDto.totalPage}"/></label>
					</div>
				</div>
			</div>
		</div>
	</div>	
	</div>
</body>
</html>