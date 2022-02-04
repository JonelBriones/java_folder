package com.jonel.mvc.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.jonel.mvc.models.Book;
import com.jonel.mvc.services.BookService;
@Controller
public class BooksController {
	
	@Autowired
	BookService bookService;
	
	 @GetMapping("/api")
	 public String home() {
		 return "index.jsp";
	 }
	 @GetMapping("/api/books/{id}")
	 public String book(Model model,@PathVariable(value="id")Long id) {
		 Book book = bookService.findBook(id);
		 System.out.println(book);
		 model.addAttribute("book", book);
		return "index.jsp";
	}
}
