package com.bookstore.model;

public class Admin {
	    private int adminId;
	    private String username;
	    private String email;
	    private String password;
	
	    public Admin(int adminId, String username, String email, String password) {
	        this.adminId = adminId;
	        this.username = username;
	        this.email = email;
	        this.password = password;
	    }
	
	    // Getters and Setters
	    public int getAdminId() {
	        return adminId;
	    }
	
	    public void setAdminId(int adminId) {
	        this.adminId = adminId;
	    }
	
	    public String getUsername() {
	        return username;
	    }
	
	    public void setUsername(String username) {
	        this.username = username;
	    }
	
	    public String getEmail() {
	        return email;
	    }
	
	    public void setEmail(String email) {
	        this.email = email;
	    }
	
	    public String getPassword() {
	        return password;
	    }
	
	    public void setPassword(String password) {
	        this.password = password;
	    }
	}
