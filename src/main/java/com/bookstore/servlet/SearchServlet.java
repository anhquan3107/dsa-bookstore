package com.bookstore.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;


import com.bookstore.daoimpl.BookDaoImpl;
import com.bookstore.model.Books;
import com.bookstore.util.BookSearchUtil;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookSearchUtil.Trie trie;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	@Override
    public void init() throws ServletException {
        super.init();
        // Initialize Trie with books from database
        BookDaoImpl bookService = new BookDaoImpl();
        List<Books> books = bookService.getAllBooks();
        trie = BookSearchUtil.buildTrieFromDatabase(books);
    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String prefix = request.getParameter("prefix");
        JSONObject jsonResponse = new JSONObject();

        if (prefix != null && !prefix.isEmpty()) {
            
            List<String> bookIds = trie.autocomplete(prefix.toLowerCase());
            JSONArray suggestions = new JSONArray();


            BookDaoImpl bookService = new BookDaoImpl();
            for (String bookId : bookIds) {
                Books book = bookService.getBookById(bookId);
                if (book != null) {
                    JSONObject bookJson = new JSONObject();
                    bookJson.put("id", book.getBookId());
                    bookJson.put("title", book.getTitle());
                    bookJson.put("author", book.getAuthor());
                    bookJson.put("price", book.getPrice());
                    suggestions.put(bookJson);
                }
            }

            jsonResponse.put("status", "success");
            jsonResponse.put("suggestions", suggestions);
        } else {
            jsonResponse.put("status", "error");
            jsonResponse.put("message", "Prefix is empty or not provided.");
        }

        response.setContentType("application/json");
        response.getWriter().write(jsonResponse.toString());	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
