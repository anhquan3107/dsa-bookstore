package com.bookstore.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bookstore.dao.CartDao;
import com.bookstore.model.Books;
import com.bookstore.model.Cart;
import com.bookstore.util.DBUtil;

public class CartDaoImpl implements CartDao {
    public boolean incrementQuantity(String userId, String bookId) {
        Connection con = DBUtil.openConnection();
        PreparedStatement ps = null;
        String sql = "UPDATE UserCart SET quantity = quantity + 1 WHERE user_ID = ? AND book_ID = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, userId);
            ps.setString(2, bookId);
            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;
            
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            DBUtil.closeConnection(ps);
            DBUtil.closeConnection(con);
        }
        return false;
    }

    public boolean decrementQuantity(String userId, String bookId) {
        Connection con = DBUtil.openConnection();
        PreparedStatement ps = null;
        String sql = "UPDATE UserCart SET quantity = GREATEST(quantity - 1, 1) WHERE user_ID = ? AND book_ID = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, userId);
            ps.setString(2, bookId);
            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            DBUtil.closeConnection(ps);
            DBUtil.closeConnection(con);
        }
        return false;
    }
    

    public boolean deleteItem(String userId, String bookId) {
        Connection con = DBUtil.openConnection();
        PreparedStatement ps = null;
        String sql = "DELETE FROM UserCart WHERE user_ID = ? AND book_ID = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, userId);
            ps.setString(2, bookId);
            int rowsDeleted = ps.executeUpdate();
            return rowsDeleted > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DBUtil.closeConnection(ps);
            DBUtil.closeConnection(con);
        }
        return false;
    }
    
    

    public int getItemQuantity(String userId, String bookId) {
        Connection con = DBUtil.openConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT quantity FROM UserCart WHERE user_ID = ? AND book_ID = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, userId);
            ps.setString(2, bookId);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("quantity");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(rs);
            DBUtil.closeConnection(ps);
            DBUtil.closeConnection(con);
        }
        return 0;   
    }
    


    public double getCartTotal(String userId) {
        Connection con = DBUtil.openConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT SUM(c.quantity * b.price) AS totalPrice " +
                     "FROM UserCart c JOIN Books b ON c.book_ID = b.book_ID " +
                     "WHERE c.user_ID = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, userId);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getDouble("totalPrice");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(rs);
            DBUtil.closeConnection(ps);
            DBUtil.closeConnection(con);
        
        }
        return 0.0;  
    }

    public boolean restoreItem(String cartId, String userId, Cart cart) {
        Connection con = DBUtil.openConnection();
        PreparedStatement ps = null;
        String sql = "INSERT INTO UserCart (cart_ID, user_ID, book_ID, quantity) VALUES (?, ?, ?, ?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, cartId);
            ps.setString(2, userId);
            ps.setString(3, cart.getBook().getBookId()); // Get book ID from Books object
            ps.setInt(4, cart.getQuantity()); // Get quantity
            int rowsInserted = ps.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(ps);
            DBUtil.closeConnection(con);
        }
        return false;
    }
    

    public Cart getCartItem(String userId, String bookId) {
        Connection con = DBUtil.openConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT b.author, b.description, b.coverImage, b.book_ID, b.title, b.price, c.quantity "
                   + "FROM UserCart c JOIN Books b ON c.book_ID = b.book_ID "
                   + "WHERE c.user_ID = ? AND c.book_ID = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, userId);
            ps.setString(2, bookId);
            rs = ps.executeQuery();
            if (rs.next()) {
                Books book = new Books();
                book.setBookId(rs.getString("book_ID"));
				book.setAuthor(rs.getString("author"));
				book.setPrice(rs.getFloat("price"));
				book.setBookImage(rs.getString("coverImage"));
				book.setTitle(rs.getString("title"));
				book.setDescription(rs.getString("description"));
                return new Cart(rs.getInt("quantity"), book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(rs);
            DBUtil.closeConnection(ps);
            DBUtil.closeConnection(con);
        }
        return null;
    }
    
}
