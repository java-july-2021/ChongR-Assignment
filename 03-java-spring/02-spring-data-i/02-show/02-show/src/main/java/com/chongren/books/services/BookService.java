package com.chongren.books.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.chongren.books.models.Book;
import com.chongren.books.repositories.BookRepository;

@Service
public class BookService {
	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}	
	
	//Return all books
	public List<Book> allBooks() {
        return bookRepository.findAll();
    }
	
	//Create book
	public Book createBook(Book b) {
		return bookRepository.save(b);
	}
	
	//Retrieves a book
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		}
		else {
			return null;
		}
	}
	
	//Update a book
	public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
		return null;
	}
	
	public Book updateBook(Book book) {
		return null;
	}
	
	
	//Delete a book
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}
	

	
}
