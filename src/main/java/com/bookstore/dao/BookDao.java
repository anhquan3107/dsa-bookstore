package com.bookstore.dao;
import java.util.List;

import com.bookstore.model.Books;

public interface BookDao {
	public List<Books> getRandomBooks(int limit);
	public List<Books> getAllBooks();
}
