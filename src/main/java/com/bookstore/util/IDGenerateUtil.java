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

}
