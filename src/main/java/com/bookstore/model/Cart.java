package com.bookstore.model;


public class Cart {
		private String userId;
		private String bookId;
		private int quantity;
		public Cart(String userId, String bookId, int quantity) {
			this.userId = userId;
			this.bookId = bookId;
			this.quantity = quantity;
		}
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		public String getBookId() {
			return bookId;
		}
		public void setBookId(String bookId) {
			this.bookId = bookId;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

}

