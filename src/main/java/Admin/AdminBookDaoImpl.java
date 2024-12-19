package Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.PseudoColumnUsage;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bookstore.model.Books;
import com.bookstore.util.DBUtil;
import com.bookstore.util.IDGenerateUtil;

public class AdminBookDaoImpl implements AdminBookDao {
	public boolean addBook(Books book) {
		boolean f = false;
		String query = "INSERT INTO Books (book_ID, title, author, description, price, coverImage) VALUES (?, ?, ?, ?, ?, ?)";
		try (Connection connection = DBUtil.openConnection();
				PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setString(1, book.getBookId());
			ps.setString(2, book.getTitle());
			ps.setString(3, book.getAuthor());
			ps.setString(4, book.getDescription());
			ps.setDouble(5, book.getPrice());
			ps.setString(6, book.getBookImage());

			/* return ps.executeUpdate() > 0; */

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return f;
	}

	public Books getBookById(String id) {
		Books book = null;
		String query = "SELECT * FROM Books WHERE book_id = ? ";
		try (Connection connection = DBUtil.openConnection();
				PreparedStatement ps = connection.prepareStatement(query)) {

			ps.setString(1, id);

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					book = new Books();
					book.setBookId(rs.getString("book_ID"));
					book.setAuthor(rs.getString("author"));
					book.setPrice(rs.getDouble("price"));
					book.setBookImage(rs.getString("coverImage"));
					book.setTitle(rs.getString("title"));
					book.setDescription(rs.getString("description"));

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return book;

	}

	@Override
	public boolean updateEditBooks(Books book) {
		boolean f = false;
		String query = "UPDATE Books SET title = ?, author = ?, description = ?, price = ? WHERE book_ID = ?";
		try (Connection connection = DBUtil.openConnection();
				PreparedStatement ps = connection.prepareStatement(query)) {

			ps.setString(1, book.getTitle());
			ps.setString(2, book.getAuthor());
			ps.setString(3, book.getDescription());
			ps.setDouble(4, book.getPrice());
			ps.setString(5, book.getBookId());

			/* return ps.executeUpdate() > 0; */

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return f;

	}

	@Override
	public boolean deleteBooks(String id) {
		boolean f = false;
		
		String query = "DELETE FROM Books WHERE book_ID = ?";
		try (Connection connection = DBUtil.openConnection();
				PreparedStatement ps = connection.prepareStatement(query)) {

			ps.setString(1, id);
			/* return ps.executeUpdate() > 0; */

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	
	

}
