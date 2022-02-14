package com.jonel.authentication.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.jonel.authentication.models.Book;
import com.jonel.authentication.models.User;
import com.jonel.authentication.services.BookService;
import com.jonel.authentication.services.UserService;
//import com.jonel.authentication.validator.UserValidator;

//.. don't forget to inlcude all your imports! ..

@Controller
public class BookController {
 
 // Add once service is implemented:
 @Autowired
 private UserService userService;
 
 @Autowired
 private BookService bookService;
 
	 @GetMapping("/home")
	 public String home( Model model, HttpSession session) {
		 if(session.getAttribute("userId")!=null) {
			 User userId = userService.findUserById((Long)session.getAttribute("userId"));
			 model.addAttribute("user",userId);
			 model.addAttribute("books", bookService.all());		
			 return "home.jsp";
		 }
		 else {
			 return "redirect:/";
		 }
		 
	 }
     
	@GetMapping("/add/{user_id}")
	public String add(@ModelAttribute("newBook") Book book, HttpSession session, Model model) {
		 if(session.getAttribute("userId")!=null) {
			 User userId = userService.findUserById((Long)session.getAttribute("userId"));
			 model.addAttribute("user",userId);
			 	return "addBook.jsp";
		 }
		 else {
			 return "redirect:/";
		 }
	}
	

	@PostMapping("/add/book")
	public String addBook(@Valid @ModelAttribute("newBook") Book book, BindingResult result) {
		 if (result.hasErrors() ) {
			 return "addBook.jsp";
		 }
		 else {
			 bookService.create(book);
			 return "redirect:/home";
		 }
	}
	
	@GetMapping("/show/{user_id}")
	public String add(@PathVariable("user_id") Long id, HttpSession session, Model model) {
		 if(session.getAttribute("userId")!=null) {
			 User userId = userService.findUserById((Long)session.getAttribute("userId"));
			 model.addAttribute("user",userId);
			 model.addAttribute("book", bookService.findId(id));
			 	return "show.jsp";
		 }
		 else {
			 return "redirect:/";
		 }
	}
	
//@PostMapping("/add/book")
//public String addBook(@Valid @ModelAttribute("newBook") Book book, BindingResult result) {
//	 if (result.hasErrors() ) {
//		 return "addBook.jsp";
//	 }
//	 else {
//		 bookService.create(book);
//		 return "redirect:/home";
//	 }
//}
	
		 
		 
		 
		 
	 
	
	 
}

