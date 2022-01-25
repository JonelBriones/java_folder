package com.jonel.daikichiroutes;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/daikichi", method=RequestMethod.GET)
public class HomeController {
	
	@RequestMapping("")
	public String welcome() {
			return "Welcome";
	}
	@RequestMapping(value="/today", method=RequestMethod.GET) 
	public String today() {
			return "Today you will find luck in all your endeavors!";
	}
	@RequestMapping(value="/tomorrow", method=RequestMethod.GET)
	public String tomorrow() {
			return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas!";
	}	
	@RequestMapping(value="/travel", method=RequestMethod.GET)
	public String travel() {
		return "Choose a location in the URL after /";
	}
	@RequestMapping(value="/travel/{destination}", method=RequestMethod.GET)
	public String travelTo(@PathVariable("destination") String destination) {
			return "Congratulations! You will soon travel to " + destination + "!";
	}
	
	// using a conditional statement with a integer parameter
	@RequestMapping(value="lotto/{number}", method=RequestMethod.GET) 
	public String lotto(@PathVariable("number") int number) {
			if (number%2 == 0) {
				return "You will take a grand journey in the near future, but be weary of tempting offers.";
			}
			else {
				return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";
			}
			
	}
}
