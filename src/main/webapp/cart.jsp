<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    .action-buttons button {
        margin: 0 5px;
        padding: 5px 10px;
        border: none;
        color: #fff;
        background-color: #007bff;
        cursor: pointer;
        border-radius: 4px;
    }
    .action-buttons button.delete {
        background-color: #dc3545;
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
</style>
</head>
<body>
<div class="cart-container">
    <div class="cart-header">
        <h2>Your Cart</h2>
    </div>
    <table>
        <tr>
            <th>Item</th>
            <th>Quantity</th>
            <th>Price</th>
            <th>Actions</th>
        </tr>
        <tr>
            <td>Blue denim shirt</td>
            <td>
                <button>-</button>
                1
                <button>+</button>
            </td>
            <td>$17.99</td>
            <td class="action-buttons">
                <button class="delete">Delete</button>
            </td>
        </tr>
        <tr>
            <td>Red hoodie</td>
            <td>
                <button>-</button>
                1
                <button>+</button>
            </td>
            <td>$17.99</td>
            <td class="action-buttons">
                <button class="delete">Delete</button>
            </td>
        </tr>
    </table>
    <div class="summary">
        Total: <strong>$35.98</strong>
    </div>
    <div class="cart-footer">
        <button class="checkout-btn">Go to Checkout</button>
    </div>
</div>
</body>
</html>
