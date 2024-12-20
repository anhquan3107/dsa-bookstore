package com.bookstore.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookstore.daoimpl.OrderDaoImpl;
import com.bookstore.daoimpl.ProductDaoImpl;
import com.bookstore.model.Cart;
import com.bookstore.model.Orders;
import com.bookstore.model.Users;
import com.bookstore.util.*;

/**
 * Servlet implementation class ConfirmOrderServlet
 *
 */
@WebServlet("/ConfirmOrderServlet")
public class ConfirmOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmOrderServlet
() {
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

        String userID = userinfo.getUserID();
        String recipientEmail = userinfo.getEmail();
        Double shippingFee = (Double)session.getAttribute("shippingFee");
        if (shippingFee == null) {
            response.getWriter().write("Shipping information is missing. Please go back and calculate shipping.");
            return;
        }
        
        ProductDaoImpl productService = new ProductDaoImpl();
        List<Cart> cartItems = productService.getCartsAsList(userID);

        if (cartItems.isEmpty()) {
            response.getWriter().write("Your cart is empty.");
            return;
        }

        OrderDaoImpl orderService = new OrderDaoImpl();
        double totalPrice = (Double)session.getAttribute("totalPrice");
        int totalBooks = 0;
        for (Cart item : cartItems) {
            totalBooks += item.getQuantity();
        }
        String orderID = IDGenerateUtil.generateOrderId();
        int shippingDistance = (Integer) session.getAttribute("shippingDistance");
        Orders order = new Orders(orderID, totalBooks, totalPrice, "Unshipped", userID, shippingDistance);
        boolean statusDB = orderService.insertOrder(order);
        
        if(statusDB){
            System.out.println("Insert Order successfully");
        }else{
            System.err.println("Fail insert order");
        }
        String emailContent = EmailContentUtil.generateOrderConfirmationEmail(userinfo, cartItems, shippingFee, orderID);
        
        try {
      
            SendEmailUtil.sendEmail(recipientEmail, "Order Confirmation", emailContent);
            response.getWriter().write("Order confirmed! A confirmation email has been sent.");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("Error sending confirmation email: " + e.getMessage());
        }
    }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
