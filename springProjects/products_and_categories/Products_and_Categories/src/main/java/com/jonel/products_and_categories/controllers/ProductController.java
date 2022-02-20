package com.jonel.products_and_categories.controllers;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jonel.products_and_categories.models.Category;
import com.jonel.products_and_categories.models.Product;
import com.jonel.products_and_categories.models.User;
import com.jonel.products_and_categories.services.CategoryService;
import com.jonel.products_and_categories.services.ProductService;
import com.jonel.products_and_categories.services.UserService;

@Controller
@RequestMapping("products")
public class ProductController {
	
	@Autowired
	private ProductService productS;
	
	@Autowired
	private CategoryService categoryS;
	
	@Autowired
	private UserService userS;
	
	@GetMapping("/add")
	public String add(@ModelAttribute("newProduct") Product product, Model model, HttpSession session) {
		if(session.getAttribute("userId")!=null) {
			User userId = userS.findId((Long)session.getAttribute("userId"));
			model.addAttribute("user", userId);
			return "newProduct.jsp";
		}
		else {
			return "redirect:user/create";
		}
	}
	
	@PostMapping("/add/product")
	public String addProduct(@Valid @ModelAttribute("newProduct") Product product, BindingResult result) {
		if (result.hasErrors()) {
			return "newProduct.jsp";
		}
		else {
			productS.create(product);
			return "redirect:/products/all";
		}
		
	}
	
	@GetMapping("/all")
	public String allProducts(Model model) {
		
		model.addAttribute("products", productS.all());
		return "products.jsp";
	}
	
	@GetMapping("/show/{product_id}")
	public String show(@PathVariable("product_id") Long id,@ModelAttribute("addProduct") Product product, Model model) {
		model.addAttribute("product", productS.findId(id));
		model.addAttribute("categories", categoryS.all());
		return "show.jsp";
	}
	
	@PostMapping("/add/category/{product_id}")
	public String addCategoryToProduct(@PathVariable("product_id") Long id,@RequestParam("category_id")Long category_id,
			HttpSession session, Model model, RedirectAttributes redirectAttributes) {
		if(session.getAttribute("userId")!=null) {
			User userId = userS.findId((Long)session.getAttribute("userId"));
			model.addAttribute("user", userId);
//			
			Category categoryId = categoryS.findId(category_id);
			Product productId = productS.findId(id);
			productS.addCategory(categoryId,productId);
			redirectAttributes.addFlashAttribute("message", "Product Added");
			return "redirect:/products/all";
		} else {
			return"redirect:/products/all";
		}
	}
	
	
}
