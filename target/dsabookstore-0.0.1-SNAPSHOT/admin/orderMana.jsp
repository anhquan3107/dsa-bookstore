<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>BS Admin: Orders Tracking</title>
    <%@ include file="admin.jsp" %>
</head>
<body>
    <%@ include file="adminNavBar.jsp" %>

    <h1 class="text-center">Hello Admin</h1>

    <table class="table table-striped">
        <thead class="bg-black">
            <tr>
                <th scope="col">Order ID</th>
                <th scope="col">UserID</th>
                <th scope="col">Quantity</th>
                <th scope="col">Total Price</th>
                <th scope="col">Distance</th>
                <th scope="col">Status</th>
            </tr>
        </thead>
        <tbody>
            <c:choose>
                <c:when test="${not empty ordersList}">
                    <c:forEach var="order" items="${ordersList}">
                        <tr>
                            <td>${order.orderId}</td>
                            <td>${order.userId}</td>
                            <td>${order.totalBook}</td>
                            <td>${order.totalPrice}</td>
                            <td>${order.shippingDistance}</td>
                            <td>${order.status}</td>
                        </tr>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <tr>
                        <td colspan="9" class="text-center">No orders found</td>
                    </tr>
                </c:otherwise>
            </c:choose>
        </tbody>
    </table>
</body>
</html>
