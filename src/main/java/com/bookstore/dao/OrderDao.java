package com.bookstore.dao;

import com.bookstore.model.Orders;

public interface OrderDao {
    public boolean insertOrder(Orders order);
}
