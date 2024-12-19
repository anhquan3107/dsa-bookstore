package com.bookstore.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookstore.daoimpl.ProductDaoImpl;
import com.bookstore.model.Cart;
import com.bookstore.model.Users;

/**
 * Servlet implementation class ViewCartServlet
 */
@WebServlet("/ViewCartServlet")
public class ViewCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewCartServlet() {
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
		String userID = userinfo.getUserID();
        ProductDaoImpl productService = new ProductDaoImpl();
		List <Cart> cartList =  productService.getCartsAsList(userID);    
		double totalPrice = 0.0;
		for (Cart cart : cartList) {
			totalPrice += cart.getBook().getPrice() * cart.getQuantity();
		}
		session.setAttribute("totalPrice", totalPrice);
		request.setAttribute("cartList", cartList);    
        request.getRequestDispatcher("cart.jsp").forward(request, response);
		
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
