package com.jonel.dojo_ninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jonel.dojo_ninjas.models.Dojo;
import com.jonel.dojo_ninjas.repositories.DojoRepository;

@Service
public class DojoService {
 // adding the book repository as a dependency
	private final DojoRepository dojoRepository;
 
 public DojoService(DojoRepository dojoRepository) {
	 this.dojoRepository = dojoRepository;
 }
 // returns all the books
 public List<Dojo> all() {
     return dojoRepository.findAll();
 }
 // creates a book
 public Dojo create(Dojo b) {
     return dojoRepository.save(b);
 }

// update a book
 public Dojo update(Dojo b) {
     return dojoRepository.save(b);
 }

 // retrieves a book by id
 public Dojo findId(Long id) {
     Optional<Dojo> optionalDojo = dojoRepository.findById(id);
     if(optionalDojo.isPresent()) {
         return optionalDojo.get();
     } else {
         return null;
     }
 }
// deletes a book
  public void delete(Long id) {
	  dojoRepository.deleteById(id);
  }

}