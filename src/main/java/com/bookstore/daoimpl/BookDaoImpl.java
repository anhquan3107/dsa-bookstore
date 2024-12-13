package com.bookstore.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookstore.dao.BookDao;
import com.bookstore.model.Books;
import com.bookstore.util.DBUtil;

public class BookDaoImpl implements BookDao {
	public List<Books> getRandomBooks(int limit){
        List<Books> books = new ArrayList<>();
        String query = "SELECT * FROM Books ORDER BY NEWID() OFFSET 0 ROWS FETCH NEXT ? ROWS ONLY";
        
        try (Connection connection = DBUtil.openConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, limit); 

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Books book = new Books();
                    book.setBookId(rs.getString("book_ID"));
                    book.setAuthor(rs.getString("author"));
                    book.setPrice(rs.getFloat("price"));
                    book.setBookImage(rs.getString("coverImage"));
                    book.setTitle(rs.getString("title"));
                    book.setDescription(rs.getString("description"));
                    books.add(book);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;
	}

	@Override
	public List<Books> getAllBooks() {
		List<Books> allBooks = new ArrayList<>();
		String query = "SELECT * FROM Books ORDER BY title";
		try (Connection connection = DBUtil.openConnection();
	             PreparedStatement ps = connection.prepareStatement(query)) { 
	            try (ResultSet rs = ps.executeQuery()) {
	                while (rs.next()) {
	                    Books book = new Books();
	                    book.setBookId(rs.getString("book_ID"));
	                    book.setAuthor(rs.getString("author"));
	                    book.setPrice(rs.getFloat("price"));
	                    book.setBookImage(rs.getString("coverImage"));
	                    book.setTitle(rs.getString("title"));
	                    book.setDescription(rs.getString("description"));
	                    allBooks.add(book);
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return allBooks;
	}
	
	public double getBookPrice(String bookID) {
        double bookPrice = 0.0;
        String query = "SELECT price FROM Books WHERE book_ID = ?"; 

        try (Connection con = DBUtil.openConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, bookID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                bookPrice = rs.getDouble("price");             }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bookPrice;
    }
}
