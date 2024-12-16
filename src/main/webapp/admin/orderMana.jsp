<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BS Admin: Orders Tracking</title>
<%@include file="admin.jsp"%>
</head>
<body>
	<%@include file="adminNavBar.jsp"%>

	<h1 class="text-center">Hello admin</h1>

	<table class="table table-striped">
		<thead class="bg-black">
			<%-- doi mau cai head dau o day --%>
			<tr>
				<th scope="col">Order ID</th>
				<th scope="col">Name</th>
				<th scope="col">Email</th>
				<th scope="col">Address</th>
				<th scope="col">Phone no</th>
				<th scope="col">Quantity</th>
				<th scope="col">Book Name</th>
				<th scope="col">Total</th>
				<th scope="col">Status</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th scope="row">1</th>
				<td>Mark</td>
				<td>Otto</td>
				<td>@mdo</td>
				<td>Mark</td>
				<td>Otto</td>
				<td>@mdo</td>
				<td><a href="#" class="btn btn-sm btn-primary">Edit</a> <a
					href="#" class="btn btn-sm btn-primary">Delete </a>
			</tr>
			<tr>
				<th scope="row">2</th>
				<td>Mark</td>
				<td>Otto</td>
				<td>@mdo</td>
				<td>Mark</td>
				<td>Otto</td>
				<td>@mdo</td>
				<td><a href="#" class="btn btn-sm btn-primary">Edit</a> <a
					href="#" class="btn btn-sm btn-primary">Delete </a>
			</tr>
			<tr>
				<th scope="row">3</th>
				<td>Mark</td>
				<td>Otto</td>
				<td>@mdo</td>
				<td>Mark</td>
				<td>Otto</td>
				<td>@mdo</td>
				<td><a href="#" class="btn btn-sm btn-primary">Edit</a> <a
					href="#" class="btn btn-sm btn-primary">Delete </a>
			</tr>
		</tbody>
	</table>

</body>
</html>