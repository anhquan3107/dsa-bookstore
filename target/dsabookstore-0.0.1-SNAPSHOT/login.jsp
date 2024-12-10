<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Login</title>
  <link rel="stylesheet" href="css/login.css" />
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css" />
  <style>
   
  </style>
  <script>
    window.onload = () => {
      const params = new URLSearchParams(window.location.search);
      const error = params.get("error");
      if (error === "invalid_credentials") {
        const errorMessage = document.querySelector(".error-message");
        errorMessage.style.display = "block";
        errorMessage.textContent = "Invalid email/username or password.";
      }
    };
  </script>
</head>
<body>

  <div class="wrapper">
    <div class="title"><span>Login Form</span></div>
    <form action="LoginServlet" method="POST">
      <div class="row">
        <i class="fas fa-user"></i>
        <input type="text" placeholder="Email or Username" required class="emailOrUserName" name="emailOrUserName" />
        <!-- Error message for email/username -->
        <div class="error-message"></div>
      </div>
      <div class="row">
        <i class="fas fa-lock"></i>
        <input type="password" placeholder="Password" required class="passwordLogin" name="passwordLogin" />
        <!-- Error message for password -->
        <div class="error-message"></div>
      </div>
      <div class="pass"><a href="#">Forgot password?</a></div>
      <div class="row button">
        <input type="submit" value="Login" />
      </div>
      <div class="signup-link">Not a member? <a href="signup.jsp">Signup now</a></div>
    </form>
  </div>
  <div class="home-link">
    <p><a href="home">Back to Home</a></p>
  </div>
</body>
</html>
