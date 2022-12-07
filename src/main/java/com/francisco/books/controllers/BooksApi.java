package com.francisco.books.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.francisco.books.models.Book;
import com.francisco.books.services.BookService;

@RestController
@RequestMapping("/api")
public class BooksApi {

	private final BookService bookServ;

	public BooksApi(BookService bookServ) {
		this.bookServ = bookServ;
	}

	// Create
	@PostMapping("/books")
	public Book createDonation(@RequestParam("title") String title, @RequestParam("description") String description,
			@RequestParam("language") String language, @RequestParam("numberOfPages") Integer numberOfPages) {
		Book newBook = new Book(title, description, language, numberOfPages);
		return bookServ.create(newBook);
	}

	// Read All
	@GetMapping("/books")
	public List<Book> findAllBooks() {
		return bookServ.getAll();
	}

	// Read one
	@GetMapping("/books/{id}")
	public Book findOneBook(@PathVariable("id") Long id) {
		return bookServ.findOne(id);
	}

	//Update one
	@PutMapping("/books/{id}")
	public Book findOneAndUpdate(@PathVariable("id") Long id, @RequestParam("title") String title,
			@RequestParam("description") String desc, @RequestParam("language") String lang,
			@RequestParam("numberOfPages") Integer numOfPages) {
		return bookServ.update(id, title, desc, lang, numOfPages);
	}

	//Delete 
	@DeleteMapping("/books/{id}")
	public void destroy(@PathVariable("id") Long id) {
		bookServ.deleteByID(id);
	}
}
