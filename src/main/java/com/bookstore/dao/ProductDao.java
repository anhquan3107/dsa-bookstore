package com.bookstore.dao;

import java.util.Map;

public interface ProductDao {

	public boolean checkCartItem(String userID, String bookID, String cartID);

	public void addCartItem(String userID, String bookID, String cartID, int quantity);

	public void updateCartItem(String userId, String bookId, String cartId, int quantity);
	
	public String createCartID(String userID);
	
	public Map<String, Integer> getCartItems(String userID);
	
	
	
}
