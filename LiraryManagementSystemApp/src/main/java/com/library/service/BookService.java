package com.library.service;

import com.library.models.Book;

public interface BookService {

	public  Book createBook(String title, boolean availableCopies);
	
	public Book getBookById(Long bookId);
}
