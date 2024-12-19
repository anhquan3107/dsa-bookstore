package com.bookstore.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookstore.model.Books;

import Admin.AdminBookDaoImpl;

@WebServlet("/editbooks")
public class EditBooksServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String id = req.getParameter("id");
			String title = req.getParameter("bname");
			String author = req.getParameter("author");
			double price = Double.parseDouble(req.getParameter("price"));
			String description = req.getParameter("bdes");

			Books b = new Books();
			b.setBookId(id);
			b.setTitle(title);
			b.setAuthor(author);
			b.setDescription(description);
			b.setPrice(price);

			AdminBookDaoImpl dao = new AdminBookDaoImpl();
			boolean f = dao.updateEditBooks(b);
			dao.updateEditBooks(b);
			HttpSession session = req.getSession();

			if (f) {
				session.setAttribute("succMsg", "Book edited");
			} else {
				session.setAttribute("failedMsg", "Error");
			}
			resp.sendRedirect("admin/allBooks.jsp");

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
