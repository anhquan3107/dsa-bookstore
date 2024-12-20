package com.bookstore.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookstore.util.*;



/**
 * Servlet implementation class ShippingServlet
 *
 */
@WebServlet("/ShippingServlet")
public class ShippingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShippingServlet
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
        String userDistrict = request.getParameter("district");
        if (userDistrict == null || userDistrict.isEmpty()) {
            response.getWriter().write("Please provide a district.");
            return;
        }
        session.setAttribute("userDistrict", userDistrict);
        int sourceIndex = 0;
        int targetIndex = ShippingUtil.findDistrictIndex(userDistrict);
        if (targetIndex == -1) {
            response.getWriter().write("Invalid district name.");
            return;
        }
        double totalPrice = (Double)session.getAttribute("totalPrice");
        int shippingDistance = ShippingUtil.dijkstra(sourceIndex, targetIndex);
        session.setAttribute("shippingDistance", shippingDistance);
        double shippingFee = ShippingUtil.calculateFee(shippingDistance);
        session.setAttribute("shippingFee", shippingFee);
        double finalPrice = totalPrice + shippingFee;
        session.setAttribute("finalPrice", finalPrice);
        response.setContentType("application/json");
        response.getWriter().write("{\"shippingFee\":" + shippingFee + ", \"finalPrice\":" + finalPrice + "}");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
