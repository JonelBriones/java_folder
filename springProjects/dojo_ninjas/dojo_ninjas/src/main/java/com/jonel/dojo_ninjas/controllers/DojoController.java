package com.jonel.dojo_ninjas.controllers;




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

import com.jonel.dojo_ninjas.models.Dojo;
import com.jonel.dojo_ninjas.models.Ninja;
import com.jonel.dojo_ninjas.services.DojoService;
import com.jonel.dojo_ninjas.services.NinjaService;

@Controller
public class DojoController {
	//Dependency Injections
	@Autowired
	private DojoService dojoService; 
	
	@Autowired
	private NinjaService ninjaService;
   
	// Redirect to dojo 
	
	@GetMapping("/")
	public String index() {
		return "redirect:/dojo";
	}
	
	// DOJO CREATE
	
    @GetMapping("/dojo")
    public String newDojo(@ModelAttribute("dojo") Dojo dojo,Model model) {
    	model.addAttribute("dojos", dojoService.all()); // will retrieve all dojo data
    	return "createDojo.jsp";
    }
    
    // CREATE DATA TO BE ADDED TO DATA BASE
    
    @PostMapping("/dojo/create")
    public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result, Model model) {
        if (result.hasErrors()) {
        	model.addAttribute("dojos", dojoService.all()); // this will continue the data for dojos after updating if has error
            return "createDojo.jsp";
        } else {
            dojoService.create(dojo);
            return "redirect:/dojo";
        }
    }
    
    // NINJA CREATE
    
    @GetMapping("/ninja")
    public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
    	model.addAttribute("dojos", dojoService.all()); // this brings the data into the form:select
    	return "createNinja.jsp";
    }
    
    // CREATE DATA TO BE ADDED TO DATA BASE
    
    @PostMapping("/ninja/create")
    public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
        if (result.hasErrors()) {
            return "createNinja.jsp";
        } else {
            ninjaService.create(ninja);
            return "redirect:/dojo";
        }
    }
    
    // Display One dojo with only ninjas if dojo_id == dojo.id
    @GetMapping("/dojo/{id}")
    public String showDojos(@PathVariable("id") Long id,Model model) {
    	model.addAttribute("dojo", dojoService.findId(id)); //using dojo.ninja.(data)
    	return "showDojo.jsp";
    	
    }



// Was not used
//    // UPDATE DATA FROM ID
//    @PutMapping("/languages/update")
//    public String updating(@Valid @ModelAttribute("language") Dojo dojo, BindingResult result) {
//        if (result.hasErrors()) {
//            return "index.jsp";
//        } else {
//            dojoService.update(dojo);
//            return "redirect:/languages/show";
//        }
//    }
//    
//    // DELETE DATA
//	@DeleteMapping("/language/delete/{id}")
//	public String delete(@PathVariable("id") Long id) {
//		dojoService.delete(id);
//		return "redirect:/languages/show";
//	}

}