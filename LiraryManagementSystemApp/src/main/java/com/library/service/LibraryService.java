package com.library.service;

import com.library.models.Book;
import com.library.models.Transaction;
import com.library.models.User;

public interface LibraryService {

	public Transaction borrowBook(User user, Book book);
	
	public Transaction returnBook(Transaction transaction);
	
}
