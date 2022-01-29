package com.jonel.counter.session;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
	@GetMapping("/your_server")
	public String index(HttpSession session) {
//		if (session.getAttribute("count") == null);
		if (session.getAttribute("count") == null) {
			// Use setAttribute to initialize the count in session
			session.setAttribute("count", 0);
			}
			else {
				Integer count = (Integer) session.getAttribute("count");
				count++;
			// increment the count by 1 using getAttribute and setAttribute
			}
		return "index.jsp";
	}
	@GetMapping("/your_server/counter")
	public String counter(HttpSession session, Model model) {
		Integer currentCount = (Integer) session.getAttribute("count");
		model.addAttribute("countToShow", currentCount);
		return "showCount.jsp";
	}
	@GetMapping("/your_server/reset")
	public String reset(HttpSession session) {
		session.invalidate();
		return "showCount.jsp";
	}
}
