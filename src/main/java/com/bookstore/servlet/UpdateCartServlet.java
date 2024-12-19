package com.bookstore.servlet;

import java.io.IOException;
import java.util.Stack;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookstore.daoimpl.CartDaoImpl;
import com.bookstore.daoimpl.ProductDaoImpl;
import com.bookstore.model.Cart;
import com.bookstore.model.Users;

/**
 * Servlet implementation class UpdateCartServlet
 */
@WebServlet("/UpdateCartServlet")
public class UpdateCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
        String bookID = request.getParameter("bookId");
        HttpSession session = request.getSession();
        Users userinfo = (Users) session.getAttribute("userinfo");
        String userID = userinfo.getUserID();
        CartDaoImpl cartService = new CartDaoImpl();
        ProductDaoImpl productService = new ProductDaoImpl();

        @SuppressWarnings("unchecked")
        Stack<Cart> undoStack = (Stack<Cart>) session.getAttribute("undoStack");
        if (undoStack == null) {
            undoStack = new Stack<>();
            session.setAttribute("undoStack", undoStack);
        }

        try {
            boolean success = false;
            int newQuantity = 0;
            double totalPrice = 0.0;
            

            switch (action) {
                case "increment":
                    success = cartService.incrementQuantity(userID, bookID);
                    break;
                case "decrement":
                    success = cartService.decrementQuantity(userID, bookID);
                    break;
                case "delete":
                    Cart deletedItem = cartService.getCartItem(userID, bookID);
                    success = cartService.deleteItem(userID, bookID);
                    if(success && deletedItem != null){
                        undoStack.push(deletedItem);
                        session.setAttribute("undoStack", undoStack);
                    }
                    break;
                case "undo":
                    if (!undoStack.isEmpty()) {
                        String cartID = productService.createCartID(userID);
                        Cart itemToRestore = undoStack.pop(); 
                        success = cartService.restoreItem(cartID, userID, itemToRestore);
                        
                    } else {
                        success = false;
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Invalid action: " + action);
            }

            if (success) {
                newQuantity = cartService.getItemQuantity(userID, bookID); 
                totalPrice = cartService.getCartTotal(userID); 
                session.setAttribute("totalPrice", totalPrice);
                session.setAttribute("cart", cartService.getCartItem(userID, bookID));
                
            }

            String jsonResponse = "{\"success\":" + success + 
            ", \"newQuantity\":" + newQuantity + 
            ", \"totalPrice\":" + totalPrice + "}";

            
            response.setContentType("application/json");
            response.getWriter().write(jsonResponse);

            } catch (Exception e) {
                e.printStackTrace();
            
            String jsonResponse = "{\"success\":false, \"message\":\"Error: " + e.getMessage() + "\"}";
            response.setContentType("application/json");
            response.getWriter().write(jsonResponse);
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
