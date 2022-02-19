package com.jonel.products_and_categories.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jonel.products_and_categories.models.Category;
import com.jonel.products_and_categories.models.Product;
import com.jonel.products_and_categories.models.User;
import com.jonel.products_and_categories.services.CategoryService;
import com.jonel.products_and_categories.services.ProductService;
import com.jonel.products_and_categories.services.UserService;

@Controller
@RequestMapping("categories")
public class Categories {
	
	@Autowired
	private ProductService productS;
	
	@Autowired
	private CategoryService categoryS;
	
	@Autowired
	private UserService userS;
	
	@GetMapping("/add")
	public String add(@ModelAttribute("newCategory") Category category, HttpSession session, Model model) {
		if(session.getAttribute("userId")!=null) {
			User userId = userS.findId((Long)session.getAttribute("userId"));
			model.addAttribute("user", userId);
			return "newCategory.jsp";
		} else {
			return "redirect:/user/create";
		}
	}
	
	@PostMapping("/add/category")
	public String addCategory(@Valid @ModelAttribute("newCategory") Category category, BindingResult result) {
		if (result.hasErrors()) {
			return "newCategory.jsp";
		}
		else {
			categoryS.create(category);
			return "redirect:/categories/all";
		}
		
	}
	
	@GetMapping("/all")
	public String allCategory(Model model, HttpSession session) {
		if(session.getAttribute("userId")!=null) {
			User userId = userS.findId((Long)session.getAttribute("userId"));
			model.addAttribute("user", userId);
			model.addAttribute("categories", categoryS.all());
			return "categories.jsp";
		} 
		else {
			return "redirect:/user/create";
		}
	}
	
	@GetMapping("/show/{category_id}")
	public String show(@PathVariable("category_id") Long id, Model model, HttpSession session) {
		if(session.getAttribute("userId")!=null) {
			User userId = userS.findId((Long)session.getAttribute("userId"));
			model.addAttribute("user", userId);
			Category categoryId = categoryS.findId(id);
			session.setAttribute("categoryId", categoryId.getId());
			
//			if(productS.all().size() > 0) {
//				List<Long> excludeProducts = new ArrayList<Long>();
//			}
			model.addAttribute("category", categoryS.findId(id));
			model.addAttribute("products", productS.all());
			return "showCategory.jsp";
		} else {
			return "redirect:/user/create";
		}
	}
	
	@PostMapping("/add/product/{product_id}")
	public String addProductToCategory(@PathVariable("product_id") Long id,
			HttpSession session, Model model) {
		if((session.getAttribute("userId")!=null) && (session.getAttribute("category") !=null)) {
			User userId = userS.findId((Long)session.getAttribute("userId"));
			Category categoryId = categoryS.findId((Long)session.getAttribute("category_id"));
			model.addAttribute("cat", userId);
			Product productId = productS.findId(id);
			categoryS.addProduct(categoryId,productId);
			return "redirect:/categories/all";
		} else {
			return"redirect:/categories/all";
		}
	}

}