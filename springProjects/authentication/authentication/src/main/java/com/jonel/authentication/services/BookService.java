package com.jonel.authentication.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jonel.authentication.models.Book;
import com.jonel.authentication.models.User;
import com.jonel.authentication.repositories.BookRepository;


@Service
public class BookService {

    @Autowired //auto injecting repository
    private BookRepository bookRepo;
    // register/create a user from submitting user form
    // TO-DO: Write register and login methods!
    // returns all the books
    public List<Book> all() {
        return bookRepo.findAll();
    }
    
    // creates a book
    public Book create(Book b) {
        return bookRepo.save(b);
    }
   // update a book
    public Book update(Book b) {
        return bookRepo.save(b);
    }
    

    
    // retrieves a book by id
    public Book findId(Long id) {
        Optional<Book> optionalBook = bookRepo.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    
    public void borrowBook(Book book, User user) {
    	List<User> borrows = book.getBorrows();
    	borrows.add(user);
    	bookRepo.save(book);
    }
    public void returnBook(Book book, User user) {
    	List<User> borrows = book.getBorrows();
    	borrows.remove(user);
    	bookRepo.save(book);
    }
    
   // deletes a book
     public void delete(Long id) {
    	 bookRepo.deleteById(id);
     }

}

