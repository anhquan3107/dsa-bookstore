package com.bookstore.admindao;
import com.bookstore.model.Books;

public interface AdminBookDao {

	public boolean addBook(Books book);

	public Books getBookById(String id);
	
	public boolean updateEditBooks(Books book);
	
	public boolean deleteBooks(String id);

}
