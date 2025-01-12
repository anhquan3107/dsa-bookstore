CREATE DATABASE bookstore
GO

USE bookstore

-- BookUsers Table
CREATE TABLE BookUsers (
  user_ID VARCHAR(50) NOT NULL,
  fullName VARCHAR(100) NOT NULL,
  userName VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL,
  password VARCHAR(100) NOT NULL,
  phone VARCHAR(15) NOT NULL, -- Phone numbers as text
  address VARCHAR(255) NOT NULL,
  PRIMARY KEY (user_ID)
);

-- Admins Table
CREATE TABLE Admins (
  adminID VARCHAR(50) NOT NULL,
  userName VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL,
  password VARCHAR(100) NOT NULL,
  PRIMARY KEY (adminID)

);

-- Orders Table
CREATE TABLE Orders (
  orderID VARCHAR(50) NOT NULL,
  totalPrice FLOAT NOT NULL,
  totalBook INT NOT NULL,
  Status VARCHAR(50) NOT NULL,
  user_ID VARCHAR(50) NOT NULL,
  distance INT NOT NULL,
  PRIMARY KEY (orderID),
 FOREIGN KEY (user_ID) REFERENCES BookUsers(user_ID)

  
);

-- Books Table
CREATE TABLE Books (
  book_ID VARCHAR(50) NOT NULL,
  title VARCHAR(50) NOT NULL, -- Fixed typo
  author VARCHAR(50) NOT NULL,
  price FLOAT NOT NULL,
  description VARCHAR(MAX) NOT NULL,
  coverImage VARCHAR(MAX) NOT NULL, -- Updated from IMAGE
  PRIMARY KEY (book_ID)
);

-- UserCart Table
CREATE TABLE UserCart (
  quantity INT NOT NULL,
  cart_ID VARCHAR(50) NOT NULL,
  user_ID VARCHAR(50) NOT NULL,
  book_ID VARCHAR(50) NOT NULL,
  PRIMARY KEY (cart_ID, user_ID, book_ID),
  FOREIGN KEY (user_ID) REFERENCES BookUsers(user_ID),
  FOREIGN KEY (book_ID) REFERENCES Books(book_ID)
);

-- Transactions Table
CREATE TABLE Transactions (
  TransactionID VARCHAR(50) NOT NULL,
  user_ID VARCHAR(50) NOT NULL,
  orderID VARCHAR(50) NOT NULL,
  CreatedTime DATETIME DEFAULT getdate(),
  PRIMARY KEY (TransactionID),
  FOREIGN KEY (user_ID) REFERENCES BookUsers(user_ID),
  FOREIGN KEY (orderID) REFERENCES Orders(orderID)
);
