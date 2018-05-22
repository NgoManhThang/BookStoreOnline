<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DASHBOARD</title>
<jsp:include page="header.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="leftMenu.jsp"></jsp:include>
	<div class="main-panel">
		<div class="content">
			<div class="container-fluid">
				<div class="row">
					<div class="col-md-12">
						<div class="card">
							<div class="header">
								<h4 class="title">DANH SÁCH CÁC ĐẦU SÁCH</h4>
								<!-- <p class="category">Here is a subtitle for this table</p> -->
							</div>
							<div class="content table-responsive table-full-width">
								<table class="table table-hover table-striped">
									<thead>
										<tr>
										<th>ID</th>
										<th>Name</th>
										<th>Salary</th>
										<th>Country</th>
										<th>City</th>
										<th>Action</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>1</td>
											<td>Dakota Rice</td>
											<td>$36,738</td>
											<td>Niger</td>
											<td>Oud-Turnhout</td>
											<td>
												<a href="" title="Sua"><i class="fa fa-edit"></i></a>
												<a href="" title="Xoa"><i class="fa fa-times-circle"></i></a>
												<a href="" title="Chi tiet"><i class="fa fa-info-circle"></i></a>
											</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>