# BasicLibraryManagementSystem
The Library Management System is a Java-based application designed to manage the operations of a library, including book management, user management, and transaction tracking. This system leverages the Spring Boot framework, JPA for database operations, and provides a RESTful API for interacting with the system.

## Features
- Book Management: Add new books to the library, retrieve book information by ID.
- User Management: Create new library users, retrieve user information by ID.
- Transaction Handling: Borrow and return books, track transaction details such as checkout date, due date, return date, and fine amount.

## Tech Stack
- Java
- Spring Framework
- Spring Boot with JPA
- MySQL Database

## Installation
 1. Clone the repository to your local machine.
    git clone https://github.com/Kapil7982/BasicLibraryManagementSystem.git
 2. Create a MySQL database named library.
 3. ## MySql database details

Install and connect with database

```bash
#db specific properties
spring.datasource.url=jdbc:mysql://localhost:8888/event
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=port
```
 
## API Endpoints

- Books:
    GET /api/books/{bookId}: Get book information by ID.
    POST /api/books: Create a new book.
- Users:
    GET /api/users/{userId}: Get user information by ID.
    POST /api/users: Create a new user.
- Transactions:
    POST /api/transactions/borrow?userId={userId}&bookId={bookId}: Borrow a book.
    POST /api/transactions/return?transactionId={transactionId}: Return a book.

## Example Usage
```bash
1. Create a new user:
   url: http://localhost:8888/api/users
   {
    "name": "molik"
   }
2. Create a new book:
   url: http://localhost:8888/api/books
   {
    "title":"Half girlfriend",
    "available":true
   }
3. Borrow a book:
   url: http://localhost:8888/api/transactions/borrow?userId=2&bookId=3
   {
    "userId": 2,
    "bookId": 3
   }
4. Return a book:
   url: http://localhost:8888/api/transactions/return?transactionId=2
   {
     "transactionId": 2
   }
```

## MySQL Database Data
```bash
 1. Tables
  +-------------------+
  | Tables_in_library |
  +-------------------+
  | book              |
  | book_seq          |
  | transaction       |
  | transaction_seq   |
  | user              |
  | user_seq          |
  +-------------------+

2. User
  +----+-------+
  | id | name  |
  +----+-------+
  |  1 | molik |
  |  2 | Ravi  |
  |  3 | Ronak |
  |  4 | Geeta |
  +----+-------+

3. Book
  +----+----------------------------+-----------------+
  | id | is_available               | title           |
  +----+----------------------------+-----------------+
  |  1 | 0x00                       | Habit           |
  |  2 | 0x01                       | Wings of fire   |
  |  3 | 0x01                       | Wrong turn      |
  |  4 | 0x01                       | Half girlfriend |
  +----+----------------------------+-----------------+

4. Transaction (Before returning book)
  +----+---------------+------------+-------------+-------------+---------+---------+
  | id | checkout_date | due_date   | fine_amount | return_date | book_id | user_id |
  +----+---------------+------------+-------------+-------------+---------+---------+
  |  1 | 2023-08-18    | 2023-09-01 |        NULL | NULL        |       2 |       1 |
  +----+---------------+------------+-------------+-------------+---------+---------+

5. Transaction (After returning book)
  +----+---------------+------------+-------------+-------------+---------+---------+
  | id | checkout_date | due_date   | fine_amount | return_date | book_id | user_id |
  +----+---------------+------------+-------------+-------------+---------+---------+
  |  1 | 2023-08-18    | 2023-09-01 |         -28 | 2023-08-18  |       2 |       1 |
  |  2 | 2023-08-18    | 2023-09-01 |         -28 | 2023-08-18  |       3 |       2 |
  +----+---------------+------------+-------------+-------------+---------+---------+
```
## PostMan Api Test

   ![WhatsApp Image 2023-08-18 at 2 10 49 PM](https://github.com/Kapil7982/BasicLibraryManagementSystem/assets/103938868/c92be118-d0ae-47c7-ac39-9f6e61bd6752)
   ![WhatsApp Image 2023-08-18 at 2 11 17 PM](https://github.com/Kapil7982/BasicLibraryManagementSystem/assets/103938868/c764ea95-af8f-4f8c-9e10-a8df7126153e)
   ![WhatsApp Image 2023-08-18 at 2 11 53 PM](https://github.com/Kapil7982/BasicLibraryManagementSystem/assets/103938868/e833ed70-04ff-49ac-8993-9bebe638cbd7)
   ![WhatsApp Image 2023-08-18 at 2 12 16 PM](https://github.com/Kapil7982/BasicLibraryManagementSystem/assets/103938868/f3799aff-9230-471a-bcdc-62edcf1a4db1)


