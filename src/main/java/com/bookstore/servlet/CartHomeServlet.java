package com.bookstore.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookstore.daoimpl.BookDaoImpl;
import com.bookstore.daoimpl.ProductDaoImpl;
import com.bookstore.model.Users;

/**
 * Servlet implementation class CartHomeServlet
 */
@WebServlet("/CartHomeServlet")
public class CartHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartHomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
        Users userinfo = (Users) session.getAttribute("userinfo");
        
        if (userinfo == null) {
            response.sendRedirect("login.jsp");
            return;
        }


        ProductDaoImpl cartService = new ProductDaoImpl();
        Map<String, Integer> cart = cartService.getCartItems(userinfo.getUserID());

        session.setAttribute("cart", cart);

        BookDaoImpl bookService = new BookDaoImpl();
        double totalPrice = 0.0;
        int totalItems = 0;

        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            String bookID = entry.getKey();
            int quantity = entry.getValue();

            double bookPrice = bookService.getBookPrice(bookID);
            totalPrice += bookPrice * quantity;
            totalItems += quantity;
        }
        session.setAttribute("cartTotalPrice", totalPrice);
        session.setAttribute("cartTotalItems", totalItems);
        request.getRequestDispatcher("home").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
