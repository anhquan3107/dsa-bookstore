package com.bookstore.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBUtil {

    private static Connection connection = null;

    public static Connection openConnection() {
        try {
        	if(connection == null || connection.isClosed()) {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		        String url = "jdbc:sqlserver://localhost:1433;databaseName=bookstore;encrypt=false;trustServerCertificate=false;";
		        String user = "SA";
		        String password = "AnhQuan@310722";
		        connection = DriverManager.getConnection(url, user, password);
        	}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;

    }
    public static void closeConnection(Connection con) {
        try {
        	if(con != null && !con.isClosed())
        		con.close();
        } catch (SQLException e) {
                e.printStackTrace();
        }
  }

    public static void closeConnection(ResultSet rs) {
            try {
            	if(rs != null && !rs.isClosed())
            		rs.close();
            } catch (SQLException e) {
	                e.printStackTrace();
            }
      }
	public static void closeConnection(PreparedStatement ps) {
	    try {
	    	if(ps != null && !ps.isClosed())
	    		ps.close();
	    } catch (SQLException e) {
	            e.printStackTrace();
	    }
	}
}

