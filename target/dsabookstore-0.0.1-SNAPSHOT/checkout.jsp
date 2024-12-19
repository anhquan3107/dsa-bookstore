<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">

    <title>Checkout</title>
  </head>
  <body class="bg-light">
    
    <div class="container">
      <div class="py-5 text-center">
        <h1>Checkout Form</h1>
      </div>
    </div>
    
    <div class="container">
      <div class="row justify-content-center">
         
        <div class="col-md-6">
          <h4 class="mb-3">Billing Address</h4>
          <div class="row">
            <div class="col mb-4">
              <label for="firstName">Full Name</label>
              <input type="text" id="firstName" class="form-control" placeholder="First name" value="${sessionScope.userinfo.fullname}" readonly>
            </div>
          
          <div class="input-group col mb-4">
            <div class="input-group-text">@</div>
            <input type="text" id="username" class="form-control" placeholder="Username " value="${sessionScope.userinfo.username}" readonly>
          </div>
          
          <div class="mb-4">
            <label for="email">Email</label>
            <input type="email" id="email" class="form-control" placeholder="you@example.com" value="${sessionScope.userinfo.email}" readonly>
          </div>
          
          <div class="mb-4">
            <label for="address">Address</label>
            <input type="text" id="address" class="form-control" placeholder="1234 Main St" value="${sessionScope.userinfo.address}">
            
          </div>
          <form action="ShippingServlet" method="GET">
            <div class="row">
              <div class="col mb-4">
                <label for="district">District: </label>
                <select id="district" name="district" class="form-control" required>
                  <option value="" disabled selected>Choose district</option>
                  <option value="District 1">District 1</option>
                  <option value="District 3">District 3</option>
                  <option value="District 4">District 4</option>
                  <option value="District 5">District 5</option>
                  <option value="District 6">District 6</option>
                  <option value="District 7">District 7</option>
                  <option value="District 8">District 8</option>
                  <option value="District 10">District 10</option>
                  <option value="District 11">District 11</option>
                  <option value="District 12">District 12</option>
                  <option value="Thu Duc">Thu Duc</option>
                  <option value="Binh Thanh">Binh Thanh</option>
                  <option value="Tan Phu">Tan Phu</option>
                  <option value="Go Vap">Go Vap</option>
                  <option value="Binh Tan">Binh Tan</option>
                </select>
              </div>
            </div>
          </form>


        <p class="text-muted mt-2">Shipping Fee: <span id = "shipping-fee">0</span></p>
        <p class="text-muted">Total: <span id="total">0</span></p>
          <hr class="mb-4">

          
          <hr class="mb-4">
          
          <div class="d-grid gap-2">
            <button class="btn btn-primary btn-lg" type="button">
              Confirm order
            </button>
          </div>
          
        </div>
      </div>
    </div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
    <script src = "js/shippingFee.js"></script>
  </body>
</html>
