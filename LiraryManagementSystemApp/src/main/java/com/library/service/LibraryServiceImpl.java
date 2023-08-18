package com.library.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.models.Book;
import com.library.models.FineConstants;
import com.library.models.Transaction;
import com.library.models.User;
import com.library.repository.BookRepository;
import com.library.repository.TransactionRepository;
import com.library.repository.UserRepository;

@Service
public class LibraryServiceImpl implements LibraryService{
	
	@Autowired
    private TransactionRepository transactionRepository;
    
    @Autowired
    private BookRepository bookRepository;
    
    @Autowired
    private UserRepository userRepository;

	@Override
	public Transaction borrowBook(User user, Book book) {
		
		if (book.isAvailable()) {
			
            
            LocalDate dueDate = LocalDate.now().plusDays(14);
            
           
            Transaction transaction = new Transaction();
            transaction.setUser(user);
            transaction.setBook(book);
            transaction.setCheckoutDate(LocalDate.now());
            transaction.setDueDate(dueDate);
            
           
            transactionRepository.save(transaction);
            
          
            book.setAvailable(false);
            bookRepository.save(book);
            
            return transaction;
        } else {
            throw new IllegalStateException("The book is not available for borrowing.");
        }
	}

	@Override
	public Transaction returnBook(Transaction transaction) {
		
		if (transaction.getReturnDate() == null) {
			
            
            long daysLate = ChronoUnit.DAYS.between(transaction.getDueDate(), LocalDate.now());
            double fineAmount = daysLate * FineConstants.FINE_PER_DAY;
            
            
            transaction.setReturnDate(LocalDate.now());
            transaction.setFineAmount(fineAmount);
            
            
            transactionRepository.save(transaction);
            
           
            Book book = transaction.getBook();
            book.setAvailable(true);
            bookRepository.save(book);
            
            return transaction;
        } else {
            throw new IllegalStateException("The book has already been returned.");
        }
	}

}
