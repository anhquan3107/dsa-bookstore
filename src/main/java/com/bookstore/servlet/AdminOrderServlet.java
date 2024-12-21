package com.bookstore.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.bookstore.admindaoimpl.AdminOrderDaoImpl;

import com.bookstore.model.Orders;

/**
 * Servlet implementation class AdminOrderServlet
 */
@WebServlet("/AdminOrderServlet")
public class AdminOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        AdminOrderDaoImpl orderDao = new AdminOrderDaoImpl();
		String action = request.getParameter("action");
		if ("shipOrder".equals(action)) {
			String orderId = request.getParameter("orderId");
			List<Orders> prioritizedOrders = orderDao.getPrioritizedOrders();
	
			Orders orderToShip = null;
			for (Orders order : prioritizedOrders) {
				if (order.getOrderId().equals(orderId)) {
					orderToShip = order;
					break;
				}
			}
	
			if (orderToShip != null) {
				
				orderToShip.setStatus("Shipped");
				orderDao.updateOrderStatus(orderToShip);
			}
		}
        List<Orders> prioritizedOrders = orderDao.getPrioritizedOrders();
        request.setAttribute("ordersList", prioritizedOrders);
        request.getRequestDispatcher("admin/orderMana.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
