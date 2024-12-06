package com.bookstore.model;
import com.bookstore.util.IDGenerateUtil;

public class Books {
	    private String bookId;
	    private String title;
	    private String author;
	    private String description;
	    private double price;
	    private String bookImage;
	    
	    public Books() {
	    
	    }
		public Books(String title, String author, String description, double price, String bookImage) {
			this.bookId = IDGenerateUtil.generateBookId();
			this.title = title;
			this.author = author;
			this.description = description;
			this.price = price;
			this.bookImage = bookImage;
		}
		public String getBookImage() {
			return bookImage;
		}
		public void setBookImage(String bookImage) {
			this.bookImage = bookImage;
		}
		public String getBookId() {
			return bookId;
		}
		public void setBookId(String bookId) {
			this.bookId = bookId;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getAuthor() {
			return author;
		}
		public void setAuthor(String author) {
			this.author = author;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		

	}


