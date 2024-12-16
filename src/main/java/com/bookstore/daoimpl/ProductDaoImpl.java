	package com.bookstore.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.bookstore.dao.ProductDao;
import com.bookstore.util.DBUtil;
import com.bookstore.util.IDGenerateUtil;

public class ProductDaoImpl implements ProductDao {

	@Override
	public boolean checkCartItem(String userID, String bookID, String cartID) {
		// TODO Auto-generated method stub
		Connection con = DBUtil.openConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "SELECT TOP 1 * FROM UserCart WHERE user_ID = ? AND book_ID = ? AND cart_ID = ?";
		try {
	        ps = con.prepareStatement(query);
	        ps.setString(1, userID);
	        ps.setString(2, bookID);	
	        ps.setString(3, cartID);
			rs = ps.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBUtil.closeConnection(rs);
		DBUtil.closeConnection(ps);
		DBUtil.closeConnection(con);
		return false;
	}
	
	@Override
    public void addCartItem(String userID, String bookID, String cartID, int quantity) {
        Connection con = DBUtil.openConnection();
        String query = "INSERT INTO UserCart (cart_ID, user_ID, book_ID, quantity) VALUES (?, ?, ?, ?)";
		PreparedStatement ps = null;
		ResultSet rs = null;
        try {
        	ps = con.prepareStatement(query);
        	ps.setString(1, cartID);
            ps.setString(2, userID);
            ps.setString(3, bookID);
            ps.setInt(4, quantity);
            ps.executeUpdate();
            System.out.print("Update successfully");
        	
        }catch(SQLException e) {
        	e.printStackTrace();
        }
		DBUtil.closeConnection(rs);
		DBUtil.closeConnection(ps);
		DBUtil.closeConnection(con);
    }
	@Override
    public void updateCartItem(String userId, String bookId, String cartId, int quantity) {
        String query = "UPDATE UserCart SET quantity = quantity + ? WHERE user_ID = ? AND book_ID = ? AND cart_ID = ?";
        Connection con = DBUtil.openConnection();
        PreparedStatement ps = null;
        try {
        	ps = con.prepareStatement(query);
        	ps.setInt(1, quantity);
        	ps.setString(2, userId);
        	ps.setString(3, bookId);
        	ps.setString(4, cartId);
        	ps.executeUpdate();
        	} catch(SQLException e) {
    	e.printStackTrace();
    	}
		DBUtil.closeConnection(ps);
		DBUtil.closeConnection(con);   
    }
	@Override
    public String createCartID(String userID) {
        Connection con = DBUtil.openConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String cartID = null;

        String query = "SELECT cart_ID FROM UserCart WHERE user_ID = ?";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, userID);
            rs = ps.executeQuery();

            if (rs.next()) {
                cartID = rs.getString("cart_ID");
            } else {
                cartID = IDGenerateUtil.generateCartId();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(rs);
            DBUtil.closeConnection(ps);
            DBUtil.closeConnection(con);
        }

        return cartID;
    }

	public Map<String, Integer> getCartItems(String userID) {
		// TODO Auto-generated method stub
		   Connection con = DBUtil.openConnection();
		    PreparedStatement ps = null;
		    ResultSet rs = null;
		    Map<String, Integer> cart = new HashMap<>();

		    String query = "SELECT book_ID, quantity FROM UserCart WHERE user_ID = ?";
		    try {
		        ps = con.prepareStatement(query);
		        ps.setString(1, userID);
		        rs = ps.executeQuery();

		        while (rs.next()) {
		            String bookID = rs.getString("book_ID");
		            int quantity = rs.getInt("quantity");
		            cart.put(bookID, quantity);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    } finally {
		        DBUtil.closeConnection(rs);
		        DBUtil.closeConnection(ps);
		        DBUtil.closeConnection(con);
		    }

		    return cart;	
}

}