package com.jonel.omikujiform.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	
	// Redirect to the main site //
	@RequestMapping("/")
	public String index() {
		return "redirect:/omikuji";
	}
	// Home Page //
	@RequestMapping("/omikuji")
	public String omikujiHome() {
		return "index.jsp";
	}
	
	@PostMapping("/omikuji/form")
	public String omikujiForm(
			@RequestParam(value="number") int number,
			@RequestParam("city") String city,
			@RequestParam("fullName") String fullName,
			@RequestParam("hobby") String hobby,
			@RequestParam("thing") String thing,
			@RequestParam("niceNote") String niceNote, HttpSession session) {
		session.setAttribute("number", number);
		session.setAttribute("city", city);
		session.setAttribute("fullName", fullName);
		session.setAttribute("hobby", hobby);
		session.setAttribute("thing", thing);
		session.setAttribute("niceNote", niceNote);
		return "redirect:/omikuji/show";
	}
	@GetMapping("/omikuji/show")
	public String show(HttpSession session, Model model) {
		int number = (int) session.getAttribute("number");
		String city = (String) session.getAttribute("city");
		String fullName = (String) session.getAttribute("fullName");
		String hobby = (String) session.getAttribute("hobby");
		String thing = (String) session.getAttribute("thing");
		String niceNote = (String) session.getAttribute("niceNote");
		model.addAttribute("number", number);
		model.addAttribute("city", city);
		model.addAttribute("fullName", fullName);
		model.addAttribute("hobby", hobby);
		model.addAttribute("thing", thing);
		model.addAttribute("niceNote", niceNote);
		return "show.jsp";
	}
}
