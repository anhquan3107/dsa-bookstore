package com.bookstore.dao;

public interface CartDao {
     public boolean incrementQuantity(String userId, String bookId);
     public boolean decrementQuantity(String userId, String bookId);
     public boolean deleteItem(String userId, String bookId);
     public int getItemQuantity(String userId, String bookId);
     public double getCartTotal(String userId);

}
