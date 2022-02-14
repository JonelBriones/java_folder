package com.jonel.authentication.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jonel.authentication.models.Book;

//.. imports .. //

//.. imports .. //

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
 
 List<Book> findAll();
 
 
 

 
}


