<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Cart</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        .cart-container {
            width: 80%;
            margin: 20px auto;
            background-color: #fff;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            overflow: hidden;
        }
        .cart-header, .cart-footer {
            background-color: #333;
            color: #fff;
            padding: 10px 20px;
            text-align: center;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table th, table td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: center;
        }
        table th {
            background-color: #f4f4f4;
        }
        .quantity-buttons {
            display: flex;
            justify-content: center;
            align-items: center;
            gap: 5px;
        }
        .quantity-buttons button {
            width: 30px;
            height: 30px;
            border: none;
            border-radius: 50%;
            font-size: 18px;
            color: #fff;
            background-color: #007bff;
            cursor: pointer;
        }
        .quantity-buttons button:hover {
            background-color: #0056b3;
        }
        .action-buttons button {
            margin: 0 5px;
            padding: 5px 10px;
            border: none;
            color: #fff;
            background-color: #dc3545;
            cursor: pointer;
            border-radius: 4px;
        }
        .summary {
            padding: 10px 20px;
            text-align: right;
            font-size: 18px;
        }
        .checkout-btn {
            background-color: #28a745;
            color: #fff;
            padding: 10px;
            border: none;
            border-radius: 4px;
            font-size: 16px;
            cursor: pointer;
        }
        .home-link {
            position: absolute;
            top: 730px;
            left: 20px;
            font-size: 20px;
            font-weight: bold;
        }

        .home-link a {
            color: #c7b198;
            text-decoration: none;
        }

        .home-link a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<div class="cart-container">
    <div class="cart-header">
        <h2>Your Cart</h2>
    </div>

    <c:choose>
        <c:when test="${empty cartList}">
            <p style="text-align: center; padding: 20px;">Your cart is empty.</p>
        </c:when>
        <c:otherwise>
            <table>
                <tr>
                    <th>Item</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Actions</th>
                </tr>
                <c:forEach var="item" items="${cartList}">
                    <tr id="cart-item-${item.book.bookId}">
                        <td>${item.book.title}</td>
                        <td class="quantity-buttons">
                            <button class="quantity-btn" data-book-id="${item.book.bookId}" data-action="decrement">-</button>
                            <span id="quantity-${item.book.bookId}">${item.quantity}</span>
                            <button class="quantity-btn" data-book-id="${item.book.bookId}" data-action="increment">+</button>
                        </td>
                        <td>$ ${item.book.price}</td>
                        <td class="action-buttons">
                            <button class="delete-btn" data-book-id="${item.book.bookId}">Delete</button>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <div class="summary">
                Total: <strong id="total-price">$ ${sessionScope.totalPrice}</strong>
            </div>
        </c:otherwise>
    </c:choose>

    <div class="cart-footer">
        <a href = "checkout.jsp"
            <button class="checkout-btn">Go to Checkout</button>
         </a>
        <button id="undo-btn" class="checkout-btn" style="background-color: #ffc107;">Undo</button>
    </div>
</div>

<div class="home-link">
    <p><a href="home">Back to Home</a></p>
  </div>


<script src="js/updateCart.js"></script>
</body>
</html>
