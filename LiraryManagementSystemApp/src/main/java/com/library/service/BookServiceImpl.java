package com.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.models.Book;


@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private com.library.repository.BookRepository bookRepository;

	@Override
	public Book createBook(String title, boolean availableCopies) {
		
		Book book = new Book();
		
		book.setTitle(title);
	    book.setAvailable(availableCopies);
	    
	    return bookRepository.save(book);
	}

	@Override
	public Book getBookById(Long bookId) {
		
		return bookRepository.findById(bookId).orElse(null);
	}
	
	
}
