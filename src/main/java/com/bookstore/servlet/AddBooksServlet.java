package com.bookstore.servlet;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.bookstore.admindaoimpl.AdminBookDaoImpl;
import com.bookstore.model.Books;
import com.bookstore.util.IDGenerateUtil;

@WebServlet("/AddBooksServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 50 // 50MB
)
public class AddBooksServlet extends HttpServlet {
	@SuppressWarnings("unused")
	private static final String UPLOAD_DIR = "book_images";

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();

		if (session.getAttribute("succMsg") == null) {
			session.setAttribute("succMsg", ""); // Empty initialization
		}
		if (session.getAttribute("failedMsg") == null) {
			session.setAttribute("failedMsg", ""); // Empty initialization
		}

		try {
			String title = req.getParameter("bname");
			String author = req.getParameter("author");
			double price = Double.parseDouble(req.getParameter("price"));
			String description = req.getParameter("bdes");

			Part filePart = req.getPart("bimg");
			String fileName = extractFileName(filePart);

			// Define the upload directory and create it if it doesn't exist
			String uploadPath = getServletContext().getRealPath("") + File.separator + "images";
			File uploadDir = new File(uploadPath);
			if (!uploadDir.exists()) {
				uploadDir.mkdir();
			}

			// Save the uploaded file to the target directory
			String filePath = uploadPath + File.separator + fileName;
			filePart.write(filePath);

			// Save the file path relative to the application context (use relative path for
			// web access)
			String relativePath = "images/" + fileName; // This path should work for the frontend

			// Create and save the book object
			Books b = new Books();
			b.setBookId(IDGenerateUtil.generateBookId()); // Generate book ID
			b.setAuthor(author);
			b.setTitle(title);
			b.setPrice(price);
			b.setDescription(description);
			b.setBookImage(relativePath);

			AdminBookDaoImpl dao = new AdminBookDaoImpl();
			boolean f = dao.addBook(b);

			if (f) {
				session.setAttribute("succMsg", "Book added successfully");
			} else {
				session.setAttribute("failedMsg", "Error while adding book");
			}

			resp.sendRedirect("admin/addBooks.jsp");

		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("failedMsg", "Error: " + e.getMessage());
			resp.sendRedirect("admin/addBooks.jsp");
		}
	}

	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		for (String content : contentDisp.split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf("=") + 2, content.length() - 1);
			}
		}
		return "default.png";
	}
}
