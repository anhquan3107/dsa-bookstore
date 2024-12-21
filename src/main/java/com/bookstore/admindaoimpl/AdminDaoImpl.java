package com.bookstore.admindaoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bookstore.admindao.AdminDao;
import com.bookstore.util.DBUtil;

public class AdminDaoImpl implements AdminDao {
    @Override
    public boolean isAdmin(String emailOrUserName, String password){
        boolean loginSuccess = false;
		Connection con = DBUtil.openConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			ps = con.prepareStatement("SELECT * FROM Admins WHERE (email = ? OR username = ?) AND password = ?");

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
    
}
