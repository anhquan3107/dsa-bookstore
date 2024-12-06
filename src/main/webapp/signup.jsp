<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Signup</title>
    <link rel="stylesheet" href="css/signup.css" />
    <link
      href="https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css"
      rel="stylesheet"
    />
  </head>
  <body>
  	  <div class="home-link">
    	<p><a href="index.jsp">Back to Home</a></p>
  	</div>
    <div class="container">
      <header>Signup Form</header>
      <form action="SignupServlet" method="POST">
        <!-- Full Name Field -->
        <div class="field name-field">
          <div class="input-field">
            <input type="text" placeholder="Enter your full name" class="fullName" name = "fullName" />
          </div>
          <span class="error name-error">
            <i class="bx bx-error-circle error-icon"></i>
            <p class="error-text">Please enter your full name</p>
          </span>
        </div>

        <!-- Username Field -->
        <div class="field username-field">
          <div class="input-field">
            <input type="text" placeholder="Enter your username" class="username" name = "username"  />
          </div>
          <span class="error username-error">
            <i class="bx bx-error-circle error-icon"></i>
            <p class="error-text">Username must be at least 5 characters</p>
          </span>
        </div>

        <!-- Phone Field -->
        <div class="field phone-field">
          <div class="input-field">
            <input type="tel" placeholder="Enter your phone number" class="phone" name = "phone"  />
          </div>
          <span class="error phone-error">
            <i class="bx bx-error-circle error-icon"></i>
            <p class="error-text">Please enter a valid phone number</p>
          </span>
        </div>

        <!-- Address Field -->
        <div class="field address-field">
          <div class="input-field">
            <input type="text" placeholder="Enter your address" class="address" name = "address" />
          </div>
          <span class="error address-error">
            <i class="bx bx-error-circle error-icon"></i>
            <p class="error-text">Please enter your address</p>
          </span>
        </div>

        <!-- Email Field -->
        <div class="field email-field">
          <div class="input-field">
            <input type="email" placeholder="Enter your email" class="email" name = "email" />
          </div>
          <span class="error email-error">
            <i class="bx bx-error-circle error-icon"></i>
            <p class="error-text">Please enter a valid email</p>
          </span>
        </div>

        <!-- Password Field -->
        <div class="field create-password">
          <div class="input-field">
            <input
              type="password"
              placeholder="Create password"
              class="password"
              name = "password"
            />
            <i class="bx bx-hide show-hide"></i>
          </div>
          <span class="error password-error">
            <i class="bx bx-error-circle error-icon"></i>
            <p class="error-text">
              Please enter at least 8 characters with a number, symbol, small, and
              capital letter.
            </p>
          </span>
        </div>

        <!-- Confirm Password Field -->
        <div class="field confirm-password">
          <div class="input-field">
            <input
              type="password"
              placeholder="Confirm password"
              class="cPassword"
              name = "cPassword"
            />
            <i class="bx bx-hide show-hide"></i>
          </div>
          <span class="error cPassword-error">
            <i class="bx bx-error-circle error-icon"></i>
            <p class="error-text">Password doesn't match</p>
          </span>
        </div>

        <!-- Submit Button -->
        <div class="input-field button">
          <input type="submit" value="Submit Now" />
        </div>
      </form>

      <!-- Login Link Section -->
      <div class="already-member">
        <p>Already a member? <a href="login.jsp">Login here</a></p>
      </div>
      
    </div>

    <script src="js/signup.js"></script>
  </body>
</html>
