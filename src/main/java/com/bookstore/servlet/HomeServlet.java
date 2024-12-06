package com.bookstore.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookstore.model.*;
import com.bookstore.daoimpl.*;

/**
 
 */
@WebServlet(name = "HomeServlet", urlPatterns = "/home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    BookDaoImpl bookService = new BookDaoImpl();
	    List<Books> randomBooks = bookService.getRandomBooks(2);
	    List<Books> featuredBooks = bookService.getRandomBooks(4);
	    List<Books> bestSellingBook= bookService.getRandomBooks(1);
	    List<Books> allBooks = bookService.getAllBooks();
	    request.setAttribute("bestSellingBook", bestSellingBook);
	    request.setAttribute("featuredBooks", featuredBooks);
	    request.setAttribute("allBooks", allBooks);
	    request.setAttribute("randomBooks", randomBooks);
	    request.getRequestDispatcher("/index.jsp").forward(request, response);  
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
