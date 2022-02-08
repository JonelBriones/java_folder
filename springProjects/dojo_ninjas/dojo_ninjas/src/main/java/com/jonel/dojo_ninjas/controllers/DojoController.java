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
   
	@GetMapping("/")
	public String index() {
		return "redirect:/dojo";
	}
	
	// DOJO CREATE
    @GetMapping("/dojo")
    public String newDojo(@ModelAttribute("dojo") Dojo dojo,Model model) {
    	model.addAttribute("dojos", dojoService.all());
    	return "createDojo.jsp";
    }
    
    // CREATE DATA TO BE ADDED TO DATA BASE
    
    @PostMapping("/dojo/create")
    public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result, Model model) {
        if (result.hasErrors()) {
        	model.addAttribute("dojos", dojoService.all());
            return "createDojo.jsp";
        } else {
            dojoService.create(dojo);
            return "redirect:/dojo";
        }
    }
    
    // NINJA CREATE
    
    @GetMapping("/ninja")
    public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
    	model.addAttribute("dojos", dojoService.all());
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
    @GetMapping("/dojo/{id}")
    public String showDojos(@PathVariable("id") Long id,Model model) {
    	model.addAttribute("dojo", dojoService.findId(id));
//    	model.addAttribute("ninjas", ninjaService.findId(id));
    	return "showDojo.jsp";
    	
    }



    
    // UPDATE DATA FROM ID
    @PutMapping("/languages/update")
    public String updating(@Valid @ModelAttribute("language") Dojo dojo, BindingResult result) {
        if (result.hasErrors()) {
            return "index.jsp";
        } else {
            dojoService.update(dojo);
            return "redirect:/languages/show";
        }
    }
    
    // DELETE DATA
	@DeleteMapping("/language/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		dojoService.delete(id);
		return "redirect:/languages/show";
	}

}