package com.bookstore.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookstore.daoimpl.ProductDaoImpl;
import com.bookstore.model.Users;
import com.bookstore.util.IDGenerateUtil;

/**
 * Servlet implementation class AddToCartServlet
 */
@WebServlet("/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		ProductDaoImpl cartService = new ProductDaoImpl();

        Users userinfo = (Users) session.getAttribute("userinfo");
        if (userinfo == null) {
            response.sendRedirect("login.jsp");
            return;
        }
        String userID = userinfo.getUserID();
        Map<String, Integer> cart = cartService.getCartItems(userID);
        
        
        
        String bookID = request.getParameter("bookId");
       
        
        String bookPriceStr = request.getParameter("bookPrice");
        double bookPrice = Double.parseDouble(bookPriceStr);

        cart.put(bookID, cart.getOrDefault(bookID, 0) + 1);
        session.setAttribute("cart", cart);
        
        String cartID = cartService.createCartID(userID);
        if(cartService.checkCartItem(userID, bookID, cartID)) {
        	cartService.updateCartItem(userID, bookID, cartID, 1);
        }
        else {
        	cartService.addCartItem(userID, bookID, cartID, 1);
        }


        int totalItems = cart.values().stream().mapToInt(Integer::intValue).sum();
        double totalPrice = cart.entrySet().stream()
                                .mapToDouble(entry -> entry.getValue() * bookPrice)
                                .sum();
        response.setContentType("application/json");
        response.getWriter().write("{\"totalItems\":" + totalItems + ", \"totalPrice\":" + totalPrice + "}");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
