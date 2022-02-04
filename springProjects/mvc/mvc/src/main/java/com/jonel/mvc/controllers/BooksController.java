package com.jonel.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.jonel.mvc.services.BookService;
@Controller
public class BooksController {
	 @GetMapping("/api")
	 public String home() {
		 return "index.jsp";
	 }
}
