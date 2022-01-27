package com.jonel.displaydate;
import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DisplayController {
	@RequestMapping("/")
	public String home() {
		return "index.jsp";
	}

	@RequestMapping("/date")
	public String date(Model model) {
		Date date = new Date();
		
		model.addAttribute("date", date);
		return "index.jsp";
	}
//	@RequestMapping("/time")
//	public String date(Model model) {
//		Time time = new Time();
//		
//		model.addAttribute("time", time);
//		return "index.jsp";
//	}
}
