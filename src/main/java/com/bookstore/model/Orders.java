package com.bookstore.model;

public class Orders {
	    private String orderId;
	    private String userId;
	    private int totalBook;  
	    private double totalPrice;
	    private String status;
		private int shippingDistance;
	

	    

		public Orders() {
	    	
	    }
		public Orders(String orderId, int totalBook, double totalPrice, String status, String userId, int shippingDistance) {
			this.userId = userId;
			this.orderId = orderId;
			this.totalBook = totalBook;
			this.totalPrice = totalPrice;
			this.status = status;
			this.shippingDistance = shippingDistance;
		}
		public int getShippingDistance() {
			return shippingDistance;
		}
		public void setShippingDistance(int shippingDistance) {
			this.shippingDistance = shippingDistance;
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

	
}

