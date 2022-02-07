package com.jonel.languages.controllers;

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

import com.jonel.languages.models.Language;
import com.jonel.languages.services.LanguageService;


@Controller
public class LanguageController {

	@Autowired
	LanguageService languageService; 
   
	@GetMapping("/")
	public String index() {
		return "redirect:/languages";
	}
	
    @GetMapping("/languages")
    public String newBook(@ModelAttribute("language") Language language) {

    	return "index.jsp";
    }
    
    // CREATE DATA TO BE ADDED TO DATA BASE
    @PostMapping("/languages/create")
    public String create(@Valid @ModelAttribute("language") Language language, BindingResult result) {
        if (result.hasErrors()) {
            return "index.jsp";
        } else {
            languageService.create(language);
            return "redirect:/languages/show";
        }
    }
    
    // RETRIEVE ALL DATA 
    @GetMapping("/languages/show")
    public String showLanguages(Model model) {
    	model.addAttribute("languages", languageService.all());
    	return "languages.jsp";
    	
    }  
    // SHOW DATA WITH ID
    @GetMapping("/languages/show/{id}")
    public String showLanguages(@PathVariable("id") Long id,Model model) {
    	model.addAttribute("language", languageService.findId(id));
    	return "showOne.jsp";
    	
    }
 
    // SHOWS THE RECENT DATA IN THE FORM TO BE UPDATED
    @GetMapping("/languages/edit/{id}")
    public String editLanguage(@PathVariable("id") Long id,Model model) {
    	model.addAttribute("language", languageService.findId(id));
    	return "update.jsp";
    	
    }
    
    // UPDATE DATA FROM ID
    @PutMapping("/languages/update")
    public String updating(@Valid @ModelAttribute("language") Language language, BindingResult result) {
        if (result.hasErrors()) {
            return "index.jsp";
        } else {
            languageService.update(language);
            return "redirect:/languages/show";
        }
    }
    
    // DELETE DATA
	@DeleteMapping("/language/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		languageService.delete(id);
		return "redirect:/languages/show";
	}

}
