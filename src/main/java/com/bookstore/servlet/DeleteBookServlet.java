package com.bookstore.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Admin.AdminBookDaoImpl;

@WebServlet("/delete")
public class DeleteBookServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		try {
			String id = req.getParameter("id");
			
			AdminBookDaoImpl dao = new AdminBookDaoImpl();
			
			boolean f = dao.deleteBooks(id);
			
			HttpSession session = req.getSession();

			if (f) {
				session.setAttribute("succMsg", "Book deleted");
			} else {
				session.setAttribute("failedMsg", "Error");
			}
			resp.sendRedirect("admin/allBooks.jsp");

			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	
	
	
	
	
	
}
