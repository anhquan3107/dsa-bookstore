package com.bookstore.admindaoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import com.bookstore.admindao.AdminOrderDao;
import com.bookstore.model.Orders;
import com.bookstore.util.DBUtil;
import com.bookstore.util.ShippingUtil;

public class AdminOrderDaoImpl implements AdminOrderDao {

    @Override
    public List<Orders> getAllOrders() {
        String sql = "SELECT orderID, totalPrice, totalBook, Status, user_ID, distance FROM Orders";
        Connection con = DBUtil.openConnection();
        List<Orders> ordersList = new ArrayList<>();
        PreparedStatement ps = null;
        
        try {
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Orders order = new Orders();
                order.setOrderId(rs.getString("orderID"));
                order.setUserId(rs.getString("user_ID"));
                order.setTotalBook(rs.getInt("totalBook"));
                order.setTotalPrice(rs.getDouble("totalPrice"));
                order.setStatus(rs.getString("Status"));
                order.setShippingDistance(rs.getInt("distance")); 

                ordersList.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ordersList;
    }

    public List<Orders> getPrioritizedOrders() {
        List<Orders> ordersList = getAllOrders();
    

        PriorityQueue<Orders> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            double priorityScore1 = ShippingUtil.calculatePriorityScore(o1.getShippingDistance(), o1.getTotalBook());
            double priorityScore2 = ShippingUtil.calculatePriorityScore(o2.getShippingDistance(), o2.getTotalBook());
            return Double.compare(priorityScore2, priorityScore1); 
        });
    
        for (Orders order : ordersList) {
            priorityQueue.add(order);
        }
    

        List<Orders> sortedOrders = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {
            sortedOrders.add(priorityQueue.poll());
        }
    
        return sortedOrders;
    }

    public void updateOrderStatus(Orders order) {
        String updateQuery = "UPDATE Orders SET Status = ? WHERE orderID = ?";

        try (Connection connection = DBUtil.openConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {

            preparedStatement.setString(1, order.getStatus());
            preparedStatement.setString(2, order.getOrderId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
}
