package com.bookstore.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookstore.daoimpl.BookDaoImpl;
import com.bookstore.daoimpl.CartDaoImpl;
import com.bookstore.daoimpl.ProductDaoImpl;
import com.bookstore.model.Cart;
import com.bookstore.model.Users;
import com.bookstore.util.EmailUtil;

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
		HHttpSession session = request.getSession();
        Users userinfo = (Users) session.getAttribute("userinfo");

        if (userinfo == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String userID = userinfo.getUserID();
        String recipientEmail = userinfo.getEmail();

        // Fetch cart items for the user
        CartDaoImpl cartService = new CartDaoImpl();
        List<Cart> cartItems = cartService.getAllCartItems(userID);

        if (cartItems.isEmpty()) {
            response.getWriter().write("Your cart is empty.");
            return;
        }

        // Prepare email content
        StringBuilder emailContent = new StringBuilder();
        emailContent.append("Dear ").append(userinfo.getFullname()).append(",\n\n");
        emailContent.append("Thank you for your order! Here are the details:\n\n");

        double total = 0.0;
        for (Cart item : cartItems) {
            emailContent.append("- ").append(item.getProductName()).append(" (Quantity: ").append(item.getQuantity())
                        .append(", Price: $").append(item.getPrice()).append(")\n");
            total += item.getQuantity() * item.getPrice();
        }
        emailContent.append("\nTotal: $").append(total).append("\n");
        emailContent.append("\nWe hope to serve you again soon!\n\nBest regards,\nBookstore Team");

        try {
            // Send confirmation email
            EmailUtil.sendEmail(recipientEmail, "Order Confirmation", emailContent.toString());
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
