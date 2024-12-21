package com.bookstore.admindaoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookstore.admindao.AdminOrderDao;
import com.bookstore.model.Orders;
import com.bookstore.util.DBUtil;

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

    
}
