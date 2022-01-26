package com.jonel.hellohuman;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // this is to render a template or to VIEW USE FOR HTML rendering
public class DemoJps {

	@RequestMapping("/demo")
	public String demo() {
		return "demo.jsp";
	}
	@RequestMapping("/fruit")
	public String fruit(Model model) { 
		model.addAttribute("fruit", "banana");//model object is to save information to be passed into html file key : value
			return "demo.jsp";
		}
}
