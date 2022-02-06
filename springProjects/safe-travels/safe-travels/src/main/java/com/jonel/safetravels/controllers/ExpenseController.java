package com.jonel.safetravels.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jonel.safetravels.models.Expense;
import com.jonel.safetravels.services.ExpenseService;

@Controller
public class ExpenseController {
	@Autowired
	ExpenseService expenseService;
	
//	@GetMapping("/expenses/new") 
//	public String index(Model model) {
//		model.addAttribute("expense", expenseService.allExpenses());
//			return "form.jsp";
//		}
//	@PostMapping("/expense")
//	public String create(
//	    @RequestParam("item") String item,
//	    @RequestParam("vendor") String vendor,
//	    @RequestParam("amount") int amount,
//	    @RequestParam("description") String desc) 
//	{
//	    // CODE TO MAKE A NEW BOOK AND SAVE TO THE DB
//	    Expense expense = new Expense(item, vendor, amount, desc);
//	    expenseService.createExpense(expense);
//	    return "redirect:/expense/new";
//	}
	@GetMapping("/expenses/new")
	public String newExpense(@ModelAttribute("expense") Expense expense) {
		return "form.jsp";
	}
	
	// Note: We'll be altering this a bit after we introduce data binding.
	@PostMapping("/expenses")
	public String createExpense(@Valid @ModelAttribute("expense") Expense expense,
		BindingResult result) 
	{
		if (result.hasErrors()) {
			return "form.jsp";
		} else {
	    // CODE TO MAKE A NEW BOOK AND SAVE TO THE DB
	  
	    expenseService.createExpense(expense);
	    return "redirect:/expenses/new";
		}
	
	}
}
