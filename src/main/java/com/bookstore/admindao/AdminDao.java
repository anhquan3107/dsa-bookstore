package com.bookstore.admindao;

public interface AdminDao {
    public boolean isAdmin(String emailOrUserName, String password);
}
