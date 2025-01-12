<img width="1512" alt="Screenshot 2024-12-22 at 21 16 38" src="https://github.com/user-attachments/assets/bb023d8c-c498-4346-859f-a6580093a02c" />
# Online Book Shopping System

This project implements an **Online Book Shopping Website** that leverages **data structures and algorithms** to enhance user experience, efficiency, and scalability. Built as part of the **Data Structures and Algorithms course (IT013IU)**, the system showcases how theoretical concepts can be applied to real-world problems.

## Features

### For Buyers
- **User Authentication**: Secure sign-up and log-in.
- **Browse and Search Books**:
  - View featured and recommended books.
  - Search books with an intelligent **Trie-based prefix search**.
- **Shopping Cart**:
  - Add, update, or remove items.
  - **Undo actions** using a **stack-based undo feature**.
- **Order Management**:
  - Checkout with a simple delivery form.
  - Payment via Cash on Delivery (COD).
  - Plans to integrate online payment methods (e.g., PayPal, Apple Pay).
    
<img width="1512" alt="Screenshot 2024-12-22 at 21 16 38" src="https://github.com/user-attachments/assets/606e7fea-1039-480d-a8a8-9627b494fe56" />
<img width="1508" alt="Screenshot 2024-12-22 at 21 17 46" src="https://github.com/user-attachments/assets/488bce21-fe5e-474c-98b3-b0b58d93357f" />
<img width="1512" alt="Screenshot 2024-12-22 at 21 18 05" src="https://github.com/user-attachments/assets/91109048-7658-4e7d-8783-fc19df8f9956" />

### For Administrators
- **Inventory Management**:
  - Add, edit, and delete book entries.
  - Monitor book availability and ensure data integrity.
- **Order Tracking**:
  - Track shipping status and assist users.
<img width="1512" alt="Screenshot 2024-12-22 at 21 19 20" src="https://github.com/user-attachments/assets/12e2f65c-d5d9-498a-9472-52da33fe0bde" />
<img width="1512" alt="Screenshot 2024-12-22 at 21 19 30" src="https://github.com/user-attachments/assets/b3b58bb7-79a7-4d3a-956e-9d9a93ce19c7" />
<img width="1512" alt="Screenshot 2024-12-22 at 21 19 41" src="https://github.com/user-attachments/assets/e2bc3015-9a9e-480b-88d2-35896a78f7d8" />

## Technology Stack

### Frontend
- **HTML, CSS**: Structure and styling.
- **JavaScript**: Dynamic UI interactions.
- **JSP (Java Server Pages)**: Dynamic page content generation.

### Backend
- **Java and Servlets**: Core business logic and data processing.
- **Apache Tomcat**: Server for hosting the application.

### Database
- **SQL Server**: Storage for books, users, and orders.
- **Relational Schema**: Logical relationships between entities.

### Tools
- **Git/GitHub**: Version control and collaboration.
- **VSCode**: Development environment.

## How to Set Up the Project

### Prerequisites
1. **Apache Tomcat** (Version 9+ recommended)
2. **SQL Server** (Microsoft SQL Server or equivalent)
3. **Java Development Kit (JDK)** (Version 11+)
4. **VSCode** 

---

### 1. Setting Up Apache Tomcat
1. **Download and Setup Tomcat**:
   - Download the extension "Community Server Connectors" by Red Hat.
   - Create new server and download the Apache Tomcat 9.0.
2. **Deploy the Application**:
   - Download the extension pack [Extension pack for Java](https://code.visualstudio.com/docs/java/java-build).
   - Import the project into VSCode.
   - Build the project by using "install" in Maven.
4. **Start Tomcat**:
   - Publish server Tomcat.
   - Run the application.
   - Access the application at `http://localhost:8080/BooksShoppingOnline`.

---

### 2. Setting Up SQL Server
1. **Install SQL Server**:
   - Download and install [Microsoft SQL Server](https://www.microsoft.com/en-us/sql-server).
   - Use SQL Server Management Studio (SSMS) for managing your database.
2. **Create the Database**:
   - Open SSMS and connect to your server.
   - Create a new database (e.g., `bookstore`).
   - Use the provided SQL scripts in the `/sql` folder to set up tables and relationships.
3. **Update Database Configuration**:
   - Open the `DBUtil.java` file in your project.
   - Update the database connection string with your server's details:
     ```java
     String url = "jdbc:sqlserver://localhost:1433;databaseName=bookstore";
     String user = "your_username";
     String password = "your_password";
     ```
4. **Test the Connection**:
   - Ensure the database server is running.
   - Run the application and test queries.

---

## Key Algorithms and Data Structures
- **Dijkstra’s Algorithm**:
  - Calculates shortest delivery paths.
  - Used to optimize shipping fees.
- **Stacks**:
  - Supports undo functionality for user actions.
- **Priority Queues**:
  - Prioritize orders for efficient delivery.
- **Tries**:
  - Efficient prefix-based book search.
- **Arrays and ArrayLists**:
  - Manage book, user, and order data.

## Future Enhancements
- Integrate online payment gateways 
- Implement advanced book recommendations using user engagement metrics.
- Add filters for search results (e.g., genre, author, price).
- Optimize SQL queries and improve caching for scalability.

## Authors
- **Phan Trần Anh Quân** – ITITIU23019
- **Trần Thị Trúc Mai** – ITCSIU23024

## Course Information
- **Course**: Data Structure and Algorithm (IT013IU)
- **Lecturers**: Dr. Vi Chi Thanh, MSc. Thai Trung Tin

## References
- [GitHub: Online Bookstore Project](https://github.com/shashirajraja/onlinebookstore)
