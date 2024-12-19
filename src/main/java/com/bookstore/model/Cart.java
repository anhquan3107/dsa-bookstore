package com.bookstore.model;


public class Cart {
		private int quantity;
		private Books book;
		public Cart(){
			
		}
		public Cart(int quantity, Books book) {
			this.quantity = quantity;
			this.book = book;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public Books getBook() {
			return book;
		}
		public void setBook(Books book) {
			this.book = book;
		}
}

