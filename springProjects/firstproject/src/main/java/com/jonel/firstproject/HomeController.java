package com.jonel.firstproject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Annotations //
@RestController //  A convenient annotation that allows our controller to respond with data (ie. strings, json)
@RequestMapping("/hello") // will respond to any path after " / "
public class HomeController {
	@RequestMapping("")
	public String hello() {
			return "Hello World";
	}
	
	@RequestMapping("/home")
	public String home() {
			return "This is Home!";
	}
	
	// HOT KEYES // 
	// * Import all dependencies - Command + shift + o
}