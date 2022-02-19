package com.jonel.authentication.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
 
 	
 	// After logging in, return to the home page with user in session
 	// Using user session, you can retrieve the user's data
  	// Retrieve all books from service
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
     // User can go add a book
	 // book will be added from the form, as well with a hidden user.id form
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
		
	// Checks for validations, if not rerender with errors
	// Creates the book after submitting form
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
	
	// Will show one book with the book.id
	// uses conditionals to check if book.user.id matches user.id, gives edit and delete options
	@GetMapping("/show/{book_id}")
	public String add(@PathVariable("book_id") Long id, HttpSession session, Model model) {
		 if(session.getAttribute("userId")!=null) {
			 User userId = userService.findUserById((Long)session.getAttribute("userId"));
			 model.addAttribute("user",userId);
			 model.addAttribute("book", bookService.findId(id));
			 model.addAttribute("user_id",(Long)session.getAttribute("userId"));
			 	return "show.jsp";
		 }
		 else {
			 return "redirect:/";
		 }
	}
	
	//Books that are created by the user may delete and edit
	//Book that are not created by the user may borrow and return books.
	 @GetMapping("/bookmarket")
	 public String bookmarketHome(Model model, HttpSession session) {
		 if(session.getAttribute("userId")!=null) {
			 User userId = userService.findUserById((Long)session.getAttribute("userId"));
			 model.addAttribute("user",userId);
			 model.addAttribute("books", bookService.all());
			 
			 return "bookmarket.jsp";
		 }
		 else {
			 return "redirect:/";
		 }
		 
	 }
	 // User may borrow a book that does not match with the book.user.id
		@GetMapping("/bookmarket/borrow/{book_id}")
		public String bookmarketBorrow(@PathVariable("book_id") Long id, HttpSession session, Model model) {
			 if(session.getAttribute("userId")!=null) {
				 User userId = userService.findUserById((Long)session.getAttribute("userId"));
				 Book bookId = bookService.findId(id);
				 bookService.borrowBook(bookId, userId);
				 model.addAttribute("user",userId);
				 model.addAttribute("book", bookId);
				 	return "redirect:/bookmarket";
			 }
			 else {
				 return "redirect:/";
			 }
		}
		
		// User may borrow a book that does not match with the book.user.id
		@GetMapping("/bookmarket/return/{book_id}")
		public String bookmarketReturn(@PathVariable("book_id") Long id, HttpSession session, Model model) {
			 if(session.getAttribute("userId")!=null) {
				 User userId = userService.findUserById((Long)session.getAttribute("userId"));
				 Book bookId = bookService.findId(id);
				 bookService.returnBook(bookId, userId);
				 model.addAttribute("user",userId);
				 model.addAttribute("book", bookId);
				 	return "redirect:/bookmarket";
			 }
			 else {
				 return "redirect:/";
			 }
		}
	
		// Will render an edit form with the last saved data //
		//PathVariable is to gather the book's data
		@GetMapping("/edit/book/{book_id}")
		public String edit(@PathVariable("book_id") Long id, HttpSession session, Model model){
			 if(session.getAttribute("userId")!=null) {
				 User userId = userService.findUserById((Long)session.getAttribute("userId"));
				 model.addAttribute("user",userId);
				 model.addAttribute("editBook", bookService.findId(id)); //this will pre populate the form//
				 	return "editBook.jsp";
			 }
			 else {
				 return "redirect:/";
			 }
		}
		
		// Update the form with validations //
		@PutMapping("/edit/book/update")
		public String update(@Valid @ModelAttribute("editBook") Book book,  BindingResult result, Model model) {
			if (result.hasErrors() ) {
				model.addAttribute("editBook",book);
				 return "editBook.jsp";
			 }
			 else {
				 bookService.update(book);
				 return "redirect:/home";
			 }
		}
		
		// DELETE BOOK //
		@DeleteMapping("/delete/{book_id}")
		public String deleteFromHome(@PathVariable("book_id") Long id, HttpSession session, Model model) {
			if(session.getAttribute("userId")!=null) {
				 User userId = userService.findUserById((Long)session.getAttribute("userId"));
				 model.addAttribute("user",userId);
			}
			bookService.delete(id);
			return "redirect:/home";
		}
		
		@DeleteMapping("/delete/bookmarket/{book_id}")
		public String deleteFromBookMarket(@PathVariable("book_id") Long id, HttpSession session, Model model) {
			if(session.getAttribute("userId")!=null) {
				 User userId = userService.findUserById((Long)session.getAttribute("userId"));
				 model.addAttribute("user",userId);
			}
			bookService.delete(id);
			return "redirect:/home";
		}
		 

}

