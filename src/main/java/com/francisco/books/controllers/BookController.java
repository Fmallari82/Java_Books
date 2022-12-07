package com.francisco.books.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.francisco.books.models.Book;
import com.francisco.books.services.BookService;

@Controller
@RequestMapping("/books")
public class BookController {
	
	public final BookService bookServ;
	public BookController(BookService bookServ) {
		this.bookServ = bookServ;
	}
	
	@GetMapping("/all")
	public String allBooks(Model model) {
		model.addAttribute("allBooks", bookServ.getAll());
		return "index.jsp";
	}
	
	@GetMapping("/{id}")
	public String oneBook(@PathVariable("id") Long id, Model model) {
		Book oneBook = bookServ.findOne(id);
		model.addAttribute("oneBook", oneBook);
		return "showOne.jsp";
	}
}
