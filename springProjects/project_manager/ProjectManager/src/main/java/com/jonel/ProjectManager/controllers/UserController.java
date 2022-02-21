package com.jonel.ProjectManager.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jonel.ProjectManager.models.Project;
import com.jonel.ProjectManager.models.User;
import com.jonel.ProjectManager.models.UserLogin;
import com.jonel.ProjectManager.services.ProjectService;
import com.jonel.ProjectManager.services.UserService;

@Controller
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserService userS;
	
	@Autowired
	private ProjectService projectS;
	

	//  Register & Login creaded with form:form
	
	@GetMapping("/create")
	public String userForm(@ModelAttribute("user") User user,Model model) {
		//Insert ModelAttributes to render Register & Login page
		model.addAttribute("newUser", new User());
		model.addAttribute("login", new UserLogin());
		return "/Registration & Login/index.jsp";
	}
	
	@PostMapping("/register")
	public String createUser(@Valid @ModelAttribute("user") User newUser,
			BindingResult result, Model model,
			HttpSession session) {
		
		// EXTRA VALIDATION USING REJECT VALUE
		if (userS.findByEmail(newUser.getEmail()) != null) {
			model.addAttribute("login", new UserLogin());
			result.rejectValue("email", "Match", "Email is already taken!");
		}
		if(!newUser.getPassword().equals(newUser.getConfirm())) {
			model.addAttribute("login", new UserLogin());
			result.rejectValue("confirm", "Match", "Password must match!");
		}
//		//  Will throw Errors from the model
		if (result.hasErrors()) {
			model.addAttribute("login", new UserLogin());
			return "/Registration & Login/index.jsp.jsp";
		} else {
			// Registers New users with correct Validations
			User user = userS.register(newUser, result);
			// Create user in session before redirecting
			// Make sure userId the same for the next routes!
			session.setAttribute("userId", user.getId());
			return "redirect:/user/home";
		}

	}
	
	//Request Param to retrieve email and password from ModelAttribute
	
	@PostMapping("/login")
	public String login(@RequestParam("email") String email, @RequestParam("password") String password, 
			RedirectAttributes redirectAttributes, Model model, HttpSession session) {
		if (userS.authenticate(email, password)) {
			
			User userId = userS.findByEmail(email);
			session.setAttribute("userId", userId.getId());
			return "redirect:/user/home";
		}
		else {
			redirectAttributes.addFlashAttribute("error", "Invalid Email/Password!");
			model.addAttribute("user", new User());
			return "redirect:/user/create";
		}
	}
	
	@GetMapping("/logout")
	 public String logout(HttpSession session) {
		 session.invalidate();
		 return "redirect:/user/create";
	 }
	
	@GetMapping("/home")
	public String home(Model model, HttpSession session) {
		if(session.getAttribute("userId")!=null) {
			User userId = userS.findId((Long)session.getAttribute("userId"));
			model.addAttribute("user", userId);
			model.addAttribute("projects", projectS.all());
			return "/Registration & Login/home.jsp";
		}
		return "redirect:/user/create";
	}
}