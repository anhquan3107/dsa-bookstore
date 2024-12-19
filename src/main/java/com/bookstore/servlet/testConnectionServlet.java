package com.bookstore.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.bookstore.util.*;
/**
 
 */
@WebServlet("/testConnection")
public class testConnectionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/plain");
        try (Connection conn = DBUtil.openConnection()) {
            if (conn != null) {
                response.getWriter().write("Connected to the database!");
            } else {
                response.getWriter().write("Failed to connect to the database.");
            }
        } catch (Exception e) {
            e.printStackTrace(response.getWriter());
        }
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
