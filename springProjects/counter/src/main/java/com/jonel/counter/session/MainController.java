package com.jonel.counter.session;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String home() {
		return "redirect:/your_server";
	}
	@GetMapping("/your_server")
	public String index(HttpSession session) {
		if (session.getAttribute("count") == null) {
			// Use setAttribute to initialize the count in session
			int count = 0;
			session.setAttribute("count", count);
		} else {
			int count = (int) session.getAttribute("count");
			count++;
			session.setAttribute("count", count);
			}
		return "index.jsp";
	}
	@GetMapping("/your_server/counter")
	public String counter(HttpSession session, Model model) {
		if (session.getAttribute("count") == null) {
			// Use setAttribute to initialize the count in session
			return "redirect:/your_server";
		} else {
			int count = (int) session.getAttribute("count");
		model.addAttribute("count", count);
		System.out.print(count);
		return "showCount.jsp";
		}
		
	}
	@GetMapping("/your_server/reset")
	public String reset(HttpSession session) {
		session.invalidate();
		return "showCount.jsp";
	}
}
