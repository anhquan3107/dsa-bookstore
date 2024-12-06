package com.bookstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.util.DBUtil;
import com.bookstore.daoimpl.UserDaoImpl;
import com.bookstore.model.Users;

@WebServlet("/SignupServlet") 
public class SignupServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter output = response.getWriter();
        
        
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        
        
        String fullName = request.getParameter("fullName");
        String address = request.getParameter("address");
        String password = request.getParameter("password");
        
        String status = "";
        Users user = new Users(username, password, fullName, email, phone, address);
        UserDaoImpl userSignUp = new UserDaoImpl();
        status = userSignUp.signupUser(user);

        try (Connection connection = DBUtil.openConnection()) {
            String insertQuery = "INSERT INTO BookUsers (user_ID, fullName, userName, phone, address, email, password) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement ps = connection.prepareStatement(insertQuery)) {
            	ps.setString(1, user.getUserID());
                ps.setString(2, fullName);
                ps.setString(3, username);
                ps.setString(4, phone);
                ps.setString(5, address);
                ps.setString(6, email);
                ps.setString(7, password);

                int rowsAffected = ps.executeUpdate();
                if (rowsAffected > 0) {
                    response.sendRedirect("signUpSuccess.html");
                } else {
                    output.println("<h2>Signup failed. Please try again.</h2>");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            output.println("<h2>Error: Unable to process your request.</h2>");
            output.println("<pre>" + e.getMessage() + "</pre>");
        }
    }
}
