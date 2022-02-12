package com.jonel.authentication.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jonel.authentication.models.LoginUser;
import com.jonel.authentication.models.User;
import com.jonel.authentication.services.UserService;
//import com.jonel.authentication.validator.UserValidator;

//.. don't forget to inlcude all your imports! ..

@Controller
public class HomeController {
 
 // Add once service is implemented:
 @Autowired
 private UserService userService;
 
// @Autowired
// private UserValidator userValidator;
 // private UserService userServ;
 
 @GetMapping("/")
 public String index(Model model) {
     // Bind empty User and LoginUser objects to the JSP
     // to capture the form input
     model.addAttribute("newUser", new User());
     model.addAttribute("newLogin", new LoginUser());
     return "index.jsp";
 }
 
 @PostMapping("/register")
 public String register(@Valid @ModelAttribute("newUser") User newUser, 
         BindingResult result, Model model, HttpSession session) {
     
     // TO-DO Later -- call a register method in the service 
     // to do some extra validations and create a new user!
//     userValidator.validate(newUser, result);
     if(result.hasErrors()) {
        // Be sure to send in the empty LoginUser before 
        // re-rendering the page.
    	model.addAttribute("newLogin", new LoginUser());
     	return "index.jsp";
     }      
     
//	 if (!newUser.getPassword().equals(newUser.getConfirm())) {
//		result.rejectValue("confirm", "Matches", "Password must match!");
//   	 	model.addAttribute("newLogin", new LoginUser());
//		return "index.jsp";
//	 }
//
//	 if(userService.findByEmail(newUser.getEmail()) != null) {
//			result.rejectValue("email", "Match", "Email is already taken!");
//	   	 	model.addAttribute("newLogin", new LoginUser());
//			return "index.jsp";
//	 }
     User user = userService.register(newUser,result);
     session.setAttribute("userId", user.getId());
     
     return "redirect:/home";
 }
     
     // No errors! 
     // TO-DO Later: Store their ID from the DB in session, 
     // in other words, log them in.
     
     
 
 
 @PostMapping("/login")
 public String login(@RequestParam("email") String email, @RequestParam("password") String password, 
		 Model model, HttpSession session, RedirectAttributes redirectAttributes) {
     
     // Add once service is implemented:
     // User user = userServ.login(newLogin, result);
 
     if(userService.authenticate(email, password)) {
         User user = userService.findByEmail(email);
         session.setAttribute("userId", user.getId());
         return "redirect:/home";
     }
     else {
     redirectAttributes.addFlashAttribute("error", "Invalid Email/Password");
	 
	 return "redirect:/";
     }
 }
 
	 @GetMapping("/home")
	 public String home(Model model, HttpSession session) {
		 if(session.getAttribute("userId")!=null) {
			 User user = userService.findUserById((Long)session.getAttribute("userId"));
			 model.addAttribute("user",user);
			 return "home.jsp";
		 }
		 else {
			 return "redirect:/";
		 }
	 }
	 @GetMapping("/logout")
	 public String logout(HttpSession session) {
		 session.invalidate();
		 return "redirect:/";
	 }
	 
}

