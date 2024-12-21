<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BookSaw - Admin</title>
<%@include file="admin/admin.jsp"%>
<style type="text/css">
.back-img {
	background: url("adminImage/4kwallpaper.jpg");
	height: 50vh;
	width: 100%;
	background-repeat: no-repeat;
	background-size: cover;
}

a {
	text-decoration: none;
	color: black;
}

a:hover {
	text-decoration: none;
	color: black;
}
</style>
</head>
<body>
	<%@include file="admin/adminNavBar.jsp"%>
	<div class="container-fluid back-img">

		<h3 class="text-center text-black">Welcome, AdminName !</h3>

	</div>

	<div class="container">
		<div class="row p-5">
			<div class="col-md-3">
				<a href="admin/addBooks.jsp">
					<div class="card">
						<div class="card-body text-center">
							<i class="fa-solid fa-circle-plus fa-3x"></i><br>
							<h4>Add books</h4>
							-----------------
						</div>
					</div>
				</a>
			</div>


			<div class="col-md-3">
				<a href="admin/allBooks.jsp">
					<div class="card">
						<div class="card-body text-center">
							<i class="fa-solid fa-book fa-3x"></i><br>
							<h4>All books</h4>
							------------------
						</div>
					</div>
				</a>
			</div>

			<div class="col-md-3">
				<a href="AdminOrderServlet">
					<div class="card">
						<div class="card-body text-center">
							<i class="fa-solid fa-cart-	shopping fa-3x"></i><br>
							<h4>Order</h4>
							------------------
						</div>
					</div>
				</a>

			</div>

			<div class="col-md-3">
				<a href="LogoutServlet">
				<div class="card">
					<div class="card-body text-center">
						<i class="fa-solid fa-right-from-bracket fa-3x"></i><br>
						<h4>Logout</h4>
						------------------
					</div>
				</div>
			</div>
		</div>

	</div>

<div style = "margin-top: 130px;">
<%@include file = "admin/footer.jsp" %>
</div>





</body>
</html>
