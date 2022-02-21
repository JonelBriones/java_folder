package com.jonel.ProjectManager.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jonel.ProjectManager.models.Project;
import com.jonel.ProjectManager.models.User;
import com.jonel.ProjectManager.services.ProjectService;
import com.jonel.ProjectManager.services.UserService;

@Controller
@RequestMapping("project")
public class ProjectController {
	
	@Autowired
	private UserService userS;
	
	@Autowired
	private ProjectService projectS;
	

	//  Register & Login creaded with form:form
	
	@GetMapping("/new")
	public String projectHome(@ModelAttribute("project") Project project,Model model,HttpSession session) {
		if(session.getAttribute("userId")!=null) {
		User userId  = userS.findId((Long)session.getAttribute("userId"));
		model.addAttribute("user", userId);
		
		return "newProject.jsp";
		}
		else {
			return "redirect:/user/create";
		}
	}
	
	@PostMapping("/new/project")
	public String createProject(@Valid @ModelAttribute("project") Project newProject,
			BindingResult result) {
		
		// If has results, render page with model errors
		if (result.hasErrors()) {
			return "newProject.jsp";
		} else {
			// Registers New users with correct Validations
			projectS.create(newProject);
			// Create user in session before redirecting
			// Make sure userId the same for the next routes!
			return "redirect:/user/home";
		}

	}
	
	@GetMapping("/edit/project/{project_id}")
	public String editProject(@PathVariable("project_id") Long id,@ModelAttribute("updateProject") Project project,Model model, HttpSession session) {
		if(session.getAttribute("userId")!=null) {
		User userId  = userS.findId((Long)session.getAttribute("userId"));
		model.addAttribute("user", userId);
		// To render edit page with data from the id
		model.addAttribute("updateProject", projectS.findId(id));
		return "editProject.jsp";
		}
		else {
			return "redirect:/project/home";
		}
	}
	
//	@PostMapping("/edit/project/{project_id}")
//	public String updateProject(@Valid @ModelAttribute("updateProject") Project project,BindingResult result,
//			 Model model,@PathVariable ("project_id") Long id) {
//		// If has results, render page with model errors
//		if (result.hasErrors()) {
//			model.addAttribute("updateProject", projectS.findId(id));
//			return "editProject.jsp";
//		} else {
//			// Registers New users with correct Validations
//			this.projectS.update(project);
//			// Create user in session before redirecting
//			// Make sure userId the same for the next routes!
//			return "redirect:/user/home";
//		}

//	}
	
	@PostMapping("/edit/project/update")
	public String updateProject(@Valid @ModelAttribute("updateProject") Project updateProject,
			BindingResult result,
			@RequestParam(value = "title") String title,
			@RequestParam(value = "description") String description,
			@RequestParam(value = "date") String date) {
		
		// If has results, render page with model errors
		if (result.hasErrors()) {
			return "editProject.jsp";
		} else {
			Project update = projectS.findId(updateProject.getId());
			update.setTitle(updateProject.getTitle());
			update.setDescription(updateProject.getDescription());
			update.setDate(updateProject.getDate());
			// Registers New users with correct Validations
			projectS.update(update);
			System.out.println(updateProject.getId());
			// Create user in session before redirecting
			// Make sure userId the same for the next routes!
			return "redirect:/user/home";
		}
	}
	
	
	
	@DeleteMapping("/delete/project/{project_id}")
	public String deleteProject(@PathVariable("project_id") Long id, HttpSession session, Model model) {
		if(session.getAttribute("userId")!=null) {
			User userId  = userS.findId((Long)session.getAttribute("userId"));
			model.addAttribute("user", userId);
			
		}
		projectS.delete(id);
		return "redirect:/user/home";
	}
	
	
	@GetMapping("/logout")
	 public String logout(HttpSession session) {
		 session.invalidate();
		 return "redirect:/user/create";
	 }
	
}