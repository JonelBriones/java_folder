package com.jonel.hellohuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	@RequestMapping("")
	public String Human() {
		return "Hello Human";
	}
	@RequestMapping("/first_name") 
	public String firstName(@RequestParam(value="name", required=false) String firstName) {
		return "Hello " + firstName;
	}
	@RequestMapping("/full_name")
	public String name(@RequestParam(value="name", required=false) String firstName,@RequestParam(value="last_name", required=false) String lastName) {
		return "Hello " + firstName + " " + lastName;
	}

}
