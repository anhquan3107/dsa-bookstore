<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>List Display</title>
</head>
<body>
<h2>Items:</h2>
    <ul>
        <c:forEach var="book" items="${allBooks}">
            <li>${book.title}</li>
        </c:forEach>
    </ul>

</body>
</html>
