package com.bookstore.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.bookstore.daoimpl.UserDaoImpl;
import com.bookstore.model.Users;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");
        
        boolean status;
        String emailOrUserName = request.getParameter("emailOrUserName").trim();
        String password = request.getParameter("passwordLogin").trim();
        
        UserDaoImpl userService = new UserDaoImpl();
        status = userService.isValidUser(emailOrUserName, password);
        
        if (status) {
        	Users user = userService.getUserInfo(emailOrUserName, password);
        	HttpSession session = request.getSession();
        	session.setAttribute("userinfo", user);
        	session.setAttribute("emailOrUserName", emailOrUserName);
        	session.setAttribute("password", password);
        	session.setMaxInactiveInterval(3600);
        	
        	
        	response.sendRedirect("loginSuccess.html");
        } else {
        	response.sendRedirect("login.jsp?error=invalid_credentials");
        }
    }
}