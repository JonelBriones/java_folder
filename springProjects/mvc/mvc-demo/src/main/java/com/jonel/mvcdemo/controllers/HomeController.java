package com.jonel.mvcdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.jonel.mvcdemo.models.Book;
import com.jonel.mvcdemo.services.BookService;
@Controller
public class HomeController {
	@Autowired
	BookService bookService;
	
	@GetMapping("/api/books/{id}")
	public String home(Model model, @PathVariable("id") Long id) {
		System.out.println(id);
		Book book = bookService.findBook(id);
		System.out.println(book);
		
		model.addAttribute("book", book);
		return "index.jsp";
	}
}
