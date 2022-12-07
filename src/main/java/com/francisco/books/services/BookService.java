package com.francisco.books.services;

import java.util.List;
import java.util.Optional;

//...
import org.springframework.stereotype.Service;

import com.francisco.books.models.Book;
import com.francisco.books.repositories.BookRepository;

@Service
public class BookService {
	// adding the book repository as a dependency
	private final BookRepository bookRepo;

	public BookService(BookRepository bookRepo) {
		this.bookRepo = bookRepo;
	}

	// returns all the books
	public List<Book> getAll() {
		return bookRepo.findAll();
	}

	// creates a book
	public Book create(Book book) {
		return bookRepo.save(book);
	}

	// retrieves a book
	public Book findOne(Long id) {
		Optional<Book> optionalBook = bookRepo.findById(id);
		if (optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}
	public Book update(Long id, String title, String description, String language, Integer numberOfPages) {
		Book bookToBeUpdated = new Book(id, title, description, language, numberOfPages);
		return bookRepo.save(bookToBeUpdated);
	}
	
	public String deleteByID(Long id) {
		bookRepo.deleteById(id);
		return "you deleted the record with the id of: " + id;
	}
}
