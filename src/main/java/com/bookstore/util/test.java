package com.bookstore.util;

public class test {
    public static void main(String[] args) {
        // Test generateUserId
        String userId = IDGenerateUtil.generateUserId();
        System.out.println("Generated User ID: " + userId);

        // Test generateBookId
        String bookId = IDGenerateUtil.generateBookId();
        System.out.println("Generated Book ID: " + bookId);
    }
}
