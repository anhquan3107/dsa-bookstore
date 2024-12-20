package com.bookstore.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bookstore.dao.OrderDao;
import com.bookstore.model.Orders;
import com.bookstore.util.DBUtil;

public class OrderDaoImpl implements OrderDao {

    public boolean insertOrder(Orders order) {
        String sql = "INSERT INTO orders (orderID, totalPrice, totalBook, user_ID, Status, distance) VALUES (?, ?, ?, ?, ?, ?)";
        Connection con = DBUtil.openConnection();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);

            ps.setString(1, order.getOrderId());
            ps.setDouble(2, order.getTotalPrice());
            ps.setInt(3, order.getTotalBook());
            ps.setString(4, order.getUserId());
            ps.setString(5, order.getStatus());
            ps.setInt(6, order.getShippingDistance());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
