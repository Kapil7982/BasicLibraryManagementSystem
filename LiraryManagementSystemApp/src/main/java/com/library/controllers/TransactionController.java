package com.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.library.models.Book;
import com.library.models.Transaction;
import com.library.models.User;
import com.library.repository.BookRepository;
import com.library.repository.TransactionRepository;
import com.library.repository.UserRepository;
import com.library.service.LibraryService;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private TransactionRepository transactionRepository;
	
    @Autowired
    private LibraryService libraryService;

    @PostMapping("/borrow")
    public ResponseEntity<Transaction> borrowBook(@RequestParam Long userId, @RequestParam Long bookId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new IllegalArgumentException("Book not found"));
        Transaction transaction = libraryService.borrowBook(user, book);
        return ResponseEntity.ok(transaction);
    }

    @PostMapping("/return")
    public ResponseEntity<Transaction> returnBook(@RequestParam Long transactionId) {
        Transaction transaction = transactionRepository.findById(transactionId)
                .orElseThrow(() -> new IllegalArgumentException("Transaction not found"));
        Transaction returnedTransaction = libraryService.returnBook(transaction);
        return ResponseEntity.ok(returnedTransaction);
    }
}
