<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<%@ page import="Admin.AdminBookDaoImpl"%>
<%@ page import="Admin.AdminBookDao"%>
<%@ page import="com.bookstore.util.DBUtil"%>
<%@ page import="java.util.*"%>
<%@ page import="com.bookstore.model.Books"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BS Admin: Add Books</title>
<%@include file="admin.jsp"%>
</head>
<body style="background-color: #F3F2EC;">
	<%@include file="adminNavBar.jsp"%>

	<div class="container">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="cord">
					<div class="card-body"></div>


					<h4 class="text-center">Edit Books</h4>

					<c:if test="${not empty succMsg}">
						<p class="text-center text-success">${succMsg}</p>
						<c:remove var="succMsg" scope="session" />
						<!-- Remove the message after it is displayed -->
					</c:if>

					<c:if test="${not empty failedMsg}">
						<p class="text-center text-danger">${failedMsg}</p>
						<c:remove var="failedMsg" scope="session" />
						<!-- Remove the message after it is displayed -->
					</c:if>

					<%
					String id = request.getParameter("id"); // Ensure this matches the parameter name in the URL
					AdminBookDaoImpl dao = new AdminBookDaoImpl();
					Books b = dao.getBookById(id);
					%>

					<form action="../editbooks" method="post">
						<input type = "hidden" name = "id" value="<%=b.getBookId() %>">


						<div class="form-group">
							<label for="exampleInputEmail1">Book Name</label> <input
								name="bname" type="text" class="form-control"
								id="exampleInputEmail1" aria-describedby="emailHelp"
								value="<%=b.getTitle()%>">
						</div>

						<div class="form-group">
							<label for="exampleInputEmail1">Author Name</label> <input
								name="author" type="text" class="form-control"
								id="exampleInputEmail1" aria-describedby="emailHelp"
								value="<%=b.getAuthor()%>">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Price</label> <input
								name="price" type="number" class="form-control"
								id="exampleInputPassword1" value="<%=b.getPrice()%>">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Description</label> <input
								name="bdes" type="text" class="form-control"
								id="exampleInputEmail1" aria-describedby="emailHelp"
								value="<%=b.getDescription()%>">
						</div>

						<button type="submit" class="btn btn-primary">Edit</button>
					</form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>