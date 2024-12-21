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
                <th scope="col">Actions</th>
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
                            <td>
                                <!-- Button to ship order -->
                                <form action="AdminOrderServlet" method="get" style="display:inline;">
                                    <input type="hidden" name="action" value="shipOrder">
                                    <input type="hidden" name="orderId" value="${order.orderId}">
                                    <button type="submit" class="btn btn-primary">Ship Order</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <tr>
                        <td colspan="7" class="text-center">No orders found</td>
                    </tr>
                </c:otherwise>
            </c:choose>
        </tbody>
    </table>
</body>
</html>
