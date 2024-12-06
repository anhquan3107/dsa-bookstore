package com.bookstore.model;
import com.bookstore.util.IDGenerateUtil;

public class Users{
	private	String userID;
	private	String username;
	private	String password;
	private	String fullname;
	private	String email;
	private	String phone;
	private	String address;

    public Users(){
    }

    public Users(String username, String password, String fullname, String email, String phone, String address) {
        this.userID = IDGenerateUtil.generateUserId();
    	this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


    
}
