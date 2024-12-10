package com.bookstore.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bookstore.dao.UserDao;
import com.bookstore.model.Users;
import com.bookstore.util.DBUtil;

public class UserDaoImpl implements UserDao {
	@Override
	public String signupUser(String username, String password, String fullname, String email, String phone, String address) {
		Users user = new Users(username, password, fullname, email, phone, address);
		String status = signupUser(user);
		return status;
	}
		

	@Override
	public String signupUser(Users user) {
	    String statusMessage = "User Signup Failed";
	    String errorMessage = "";

	    boolean isEmailReg = isRegistered(user.getEmail(), "email");
	    boolean isUsernameReg = isRegistered(user.getUsername(), "username");
	    boolean isPhoneReg = isRegistered(user.getPhone(), "phone");

	    if (isEmailReg) {
	        errorMessage = "Email has already been used";
	    } else if (isUsernameReg) {
	        errorMessage = "Username has already been taken";
	    } else if (isPhoneReg) {
	        errorMessage = "Phone number has already been registered";
	    }

	    if (!errorMessage.isEmpty()) {
	        statusMessage = errorMessage;
	    } else {
	        statusMessage = "Signup Successful";
	    }
	    
	    return statusMessage;
	}

	@Override
	public boolean isRegistered(String value, String type) {
	    boolean isReg = false;
	    Connection connection = DBUtil.openConnection();
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    try {
	        String query = "";
	        if (type.equals("email")) {
	            query = "SELECT * FROM BookUsers WHERE email = ?";
	        } else if (type.equals("username")) {
	            query = "SELECT * FROM BookUsers WHERE userName = ?";
	        } else if (type.equals("phone")) {
	            query = "SELECT * FROM BookUsers WHERE phone = ?";
	        }

	        ps = connection.prepareStatement(query);
	        ps.setString(1, value);
	        rs = ps.executeQuery();
	        if (rs.next()) {
	            isReg = true;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        DBUtil.closeConnection(rs);
	        DBUtil.closeConnection(ps);
	        DBUtil.closeConnection(connection);
	    }
	    return isReg;
	}


	@Override
	public boolean isValidUser(String emailOrUserName, String password) {
		// TODO Auto-generated method stub\
		
		boolean loginSuccess = false;
		Connection con = DBUtil.openConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			ps = con.prepareStatement("SELECT * FROM BookUsers WHERE (email = ? OR username = ?) AND password = ?");

			ps.setString(1, emailOrUserName);
			ps.setString(2, emailOrUserName);
			ps.setString(3, password);

			rs = ps.executeQuery();

			if (rs.next())
				loginSuccess = true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtil.closeConnection(ps);
		DBUtil.closeConnection(rs);
		DBUtil.closeConnection(con);

		return loginSuccess;
	}

	@Override
	public Users getUserInfo(String emailOrUserName, String password) {
		// TODO Auto-generated method stub
		Users user = null;

		Connection con = DBUtil.openConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement("SELECT * FROM BookUsers WHERE (email = ? OR username = ?) AND password = ?");
			ps.setString(1, emailOrUserName);
			ps.setString(2, emailOrUserName);
			ps.setString(3, password);
			rs = ps.executeQuery();

			if (rs.next()) {
				user = new Users();
				user.setFullname(rs.getString("fullName"));
				user.setUsername(rs.getString("userName"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setPhone(rs.getString("phone"));
				user.setAddress(rs.getString("address"));
				user.setUserID(rs.getString("user_ID"));

				return user;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		DBUtil.closeConnection(ps);
		DBUtil.closeConnection(rs);
		DBUtil.closeConnection(con);

		return user;
	}


	@Override
	public boolean updateUserIntoDB(Users user) {
	    String updateQuery = "UPDATE BookUsers SET fullName = ?, email = ?, phone = ?, address = ? WHERE user_ID = ?";
	    Connection connection = null;
	    PreparedStatement ps = null;

	    try {
	        connection = DBUtil.openConnection();
	        ps = connection.prepareStatement(updateQuery);
	        ps.setString(1, user.getFullname());
	        ps.setString(2, user.getEmail());
	        ps.setString(3, user.getPhone());
	        ps.setString(4, user.getAddress());
	        ps.setString(5, user.getUserID());

	        int rowsUpdated = ps.executeUpdate();
	        System.out.println("Rows updated in database: " + rowsUpdated); 

	        return rowsUpdated > 0;

	    } catch (SQLException e) {
	        System.err.println("Database update failed: " + e.getMessage());
	        e.printStackTrace();
	        return false;

	    } finally {
			DBUtil.closeConnection(ps);
			DBUtil.closeConnection(connection);	   
		}
	}

	


}
