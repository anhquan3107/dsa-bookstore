package com.bookstore.model;

import java.util.List;

public class Orders {
	    private String orderId;
	    private String userId;
	    private int totalBook;  // Total number of books in the order
	    private double totalPrice;
	    private String status;
	
	    // Relationships
	    private Users user;  // The user who placed the order
	    private List<Books> books;  // List of books in the order
	    
	    public Orders() {
	    	
	    }
		public Orders(String orderId, int totalBook, double totalPrice, String status, Users user, List<Books> books, String userId) {
			this.userId = userId;
			this.orderId = orderId;
			this.totalBook = totalBook;
			this.totalPrice = totalPrice;
			this.status = status;
			this.user = user;
			this.books = books;
		}
		public String getOrderId() {
			return orderId;
		}
		public void setOrderId(String orderId) {
			this.orderId = orderId;
		}
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		public int getTotalBook() {
			return totalBook;
		}
		public void setTotalBook(int totalBook) {
			this.totalBook = totalBook;
		}
		public double getTotalPrice() {
			return totalPrice;
		}
		public void setTotalPrice(double totalPrice) {
			this.totalPrice = totalPrice;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public Users getUser() {
			return user;
		}
		public void setUser(Users user) {
			this.user = user;
		}
		public List<Books> getBooks() {
			return books;
		}
		public void setBooks(List<Books> books) {
			this.books = books;
		}

	
}

