package com.jonel.mvcdemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//...
import org.springframework.stereotype.Service;

import com.jonel.mvcdemo.models.Book;
import com.jonel.mvcdemo.repositories.BookRepository;
@Service
public class BookService {
	
 @Autowired
 // adding the book repository as a dependency
 private final BookRepository bookRepository;
 
 public BookService(BookRepository bookRepository) {
     this.bookRepository = bookRepository;
 }
 // returns all the books
 public List<Book> allBooks() {
     return bookRepository.findAll();
 }
 // creates a book
 public Book createBook(Book b) {
     return bookRepository.save(b);
 }
 // retrieves a book
 public Book findBook(Long id) {
     Optional<Book> optionalBook = bookRepository.findById(id);
     if(optionalBook.isPresent()) {
         return optionalBook.get();
     } else {
         return null;
     }
 }
public void deleteBook(Long id) {
	// TODO Auto-generated method stub
	bookRepository.deleteById(id);
 }
//public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
//	return bookRepository.save(title,desc,lang,numOfPages);
//	}
}

