<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<%@ page import="com.bookstore.daoimpl.BookDaoImpl"%>
<%@ page import="com.bookstore.util.DBUtil"%>
<%@ page import="java.util.*"%>
<%@ page import="com.bookstore.model.Books"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BS Admin: All Books</title>
<%@include file="admin.jsp"%>
</head>
<body>
	<%@include file="adminNavBar.jsp"%>

	<h1 class="text-center">Hello admin</h1>

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

	<table class="table table-striped">
		<thead class="bg-black">
			<%-- doi mau cai head dau o day --%>
			<tr>
				<th scope="col">ID</th>
				<th scope="col">Cover</th>
				<th scope="col">Book Name</th>
				<th scope="col">Author</th>
				<th scope="col">Price</th>
				<th scope="col">Description</th>
				<th scope="col">Action</th>
			</tr>
		</thead>
		<tbody>
			<%
			BookDaoImpl dao = new BookDaoImpl();
			List<Books> list = dao.getAllBooks();
			for (Books b : list) {
			%>
			<tr>
				<td><%=b.getBookId()%></td>
				<td><img src="../images/<%=b.getBookImage()%>"
					style="width: 5ppx; height: 50PX;"></td>
				<td><%=b.getTitle()%></td>
				<td><%=b.getAuthor()%></td>
				<td><%=b.getPrice()%></td>
				<td><%=b.getDescription()%></td>
				<td><a href="editBooks.jsp?id=<%=b.getBookId()%>"
					class="btn btn-sm btn-primary">Edit</a> <a href="../delete?id=<%=b.getBookId() %>"
					class="btn btn-sm btn-danger">Delete </a>
			</tr>

			<%
			}
			%>



		</tbody>
	</table>

</body>
</html>