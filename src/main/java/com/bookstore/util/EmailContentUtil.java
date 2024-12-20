package com.bookstore.util;

import java.util.List;
import com.bookstore.model.Cart;
import com.bookstore.model.Users;

public class EmailContentUtil {

    public static String generateOrderConfirmationEmail(Users userinfo, List<Cart> cartItems, double shippingFee, String orderId) {
        StringBuilder emailContent = new StringBuilder();

        emailContent.append("Dear ").append(userinfo.getFullname()).append(",\n\n");
        emailContent.append("Thank you for your order! Here are the details:\n\n");
        emailContent.append("Order ID: ").append(orderId).append("\n\n");

        double total = 0.0;
        for (Cart item : cartItems) {
            emailContent.append("- ").append(item.getBook().getTitle())
                        .append(" (Quantity: ").append(item.getQuantity())
                        .append(", Price: $").append(item.getBook().getPrice()).append(")\n");
            total += item.getQuantity() * item.getBook().getPrice();
        }

        double finalTotal = total + shippingFee;

        emailContent.append("\nSubtotal: $").append(total).append("\n");
        emailContent.append("Shipping Fee: $").append(shippingFee).append("\n");
        emailContent.append("Total (including shipping): $").append(finalTotal).append("\n\n");
        emailContent.append("We hope to serve you again soon!\n\nBest regards,\nBookstore DSA Team");

        return emailContent.toString();
    }
}
