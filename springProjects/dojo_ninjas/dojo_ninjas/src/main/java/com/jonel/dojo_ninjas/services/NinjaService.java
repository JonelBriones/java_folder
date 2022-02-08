package com.jonel.dojo_ninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import com.jonel.dojo_ninjas.models.Ninja;
import com.jonel.dojo_ninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
 // adding the book repository as a dependency
	private final NinjaRepository ninjaRepository;
 
 public NinjaService (NinjaRepository ninjaRepository) {
	 this.ninjaRepository = ninjaRepository;
 }
 // returns all the books
 public List<Ninja> all() {
     return ninjaRepository.findAll();
 }
 // creates a book
 public Ninja create(Ninja b) {
     return ninjaRepository.save(b);
 }
// update a book
 public Ninja update(Ninja b) {
     return ninjaRepository.save(b);
 }
 
 // retrieves a book by id
 public Ninja findId(Long id) {
     Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
     if(optionalNinja.isPresent()) {
         return optionalNinja.get();
     } else {
         return null;
     }
 }
// deletes a book
  public void delete(Long id) {
	  ninjaRepository.deleteById(id);
  }

}