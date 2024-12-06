package com.bookstore.dao;
import com.bookstore.model.Users;

public interface UserDao {
	public String signupUser(String username, String password, String fullname, String email, String phone, String address);
	public String signupUser(Users user);
	public boolean isRegistered(String value, String type);
	public boolean isValidUser(String emailOrUserName, String password);
	public Users getUserInfo(String emailOrUserName, String password);
}
