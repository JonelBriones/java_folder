package com.jonel.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jonel.languages.models.Language;
import com.jonel.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
 // adding the book repository as a dependency
	private final LanguageRepository languageRepository;
 
 public LanguageService(LanguageRepository languageRepository) {
	 this.languageRepository = languageRepository;
 }
 // returns all the books
 public List<Language> all() {
     return languageRepository.findAll();
 }
 // creates a book
 public Language create(Language b) {
     return languageRepository.save(b);
 }
// update a book
 public Language update(Language b) {
     return languageRepository.save(b);
 }

 // retrieves a book by id
 public Language findId(Long id) {
     Optional<Language> optionalLanguage = languageRepository.findById(id);
     if(optionalLanguage.isPresent()) {
         return optionalLanguage.get();
     } else {
         return null;
     }
 }
// deletes a book
  public void delete(Long id) {
	  languageRepository.deleteById(id);
  }

}
