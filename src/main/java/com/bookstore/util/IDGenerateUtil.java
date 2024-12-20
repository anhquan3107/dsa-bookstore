package com.bookstore.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class IDGenerateUtil {

	public static String generateUserId() {
		String userId = null;

		SimpleDateFormat date = new SimpleDateFormat("yyyyMMddmmSSS");
		userId = date.format(new Date()) + (int)(Math.random()*1000);
		userId = "IU" + userId;

		return userId;
	}
	
	public static String generateBookId() {
		String bookId = null;

		SimpleDateFormat date = new SimpleDateFormat("mmSSSyyyyMMdd");
		bookId = date.format(new Date()) + (int)(Math.random()*1000);
		bookId = "B" + bookId;

		return bookId;
	}
	
	public static String generateCartId() {
		String cartId = null;

		SimpleDateFormat date = new SimpleDateFormat("mmSSSyyyyMMdd");
		cartId = date.format(new Date()) + (int)(Math.random()*1000);
		cartId = "CA" + cartId;

		return cartId;
	}
	public static String generateOrderId() {
		String orderId = null;

		SimpleDateFormat date = new SimpleDateFormat("mmSSSyyyyMMdd");
		orderId = date.format(new Date()) + (int)(Math.random()*1000);
		orderId = "ORD" + orderId;

		return orderId;
	}

}
