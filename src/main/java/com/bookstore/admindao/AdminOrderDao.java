package com.bookstore.admindao;

import java.util.List;

import com.bookstore.model.Orders;

public interface AdminOrderDao {
    public List<Orders> getAllOrders();
}
