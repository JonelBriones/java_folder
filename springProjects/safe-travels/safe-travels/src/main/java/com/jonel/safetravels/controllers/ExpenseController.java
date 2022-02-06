package com.jonel.safetravels.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.jonel.safetravels.models.Expense;
import com.jonel.safetravels.services.ExpenseService;

@Controller
public class ExpenseController {
	@Autowired
	ExpenseService expenseService;

	@GetMapping("/expenses")
	public String newExpense(@ModelAttribute("expense") Expense expense) {

		return "form.jsp";
	}
	@GetMapping("/expenses/show")
	public String showExpense(Model model) {
	model.addAttribute("expenses", expenseService.allExpenses());
		return "show.jsp";
	}
	
	// passes in the id for the object
	@GetMapping("/expense/edit/{id}")
	public String editExpense(@PathVariable("id") Long id, Model model) {
		Expense expense = expenseService.findExpense(id);
		model.addAttribute("expense", expense);
		return "edit.jsp";
	}
	
	@PostMapping("/expense/update")
	public String updateExpense(@Valid @ModelAttribute("expense") Expense expense,
		BindingResult result) 
	{
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
	    // CODE TO MAKE A NEW BOOK AND SAVE TO THE DB
	  
	    expenseService.updateExpense(expense);
	    return "redirect:/expenses/show";
		}
	
	}
//	@GetMapping("/expense/update/{id}")
//	public String updateExpense(Model model, @PathVariable Long id) {
//		model.addAttribute("expense", expenseService.findExpense(id));
//		return "edit.jsp";
//	}
//	@PutMapping("/expense/update/{id}")
//	public String updateExpense(@Valid @ModelAttribute("expense") Expense expense,
//		BindingResult result, @RequestParam(value="item") String item, @RequestParam(value="vendor") String vendor,@RequestParam(value="amount") Integer amount,@RequestParam(value="description") String description) 
//	{
//		if (result.hasErrors()) {
//			return "edit.jsp";
//		} else {
//	    // CODE TO MAKE A NEW BOOK AND SAVE TO THE DB
//			Expense updatedExpense = expenseService.updateExpense(item, vendor, amount, description);
//		expenseService.updateExpense(updatedExpense);
//	    return "redirect:/expenses/show";
//		}
//	
//	}
	
	// Note: We'll be altering this a bit after we introduce data binding.
	@PostMapping("/expenses/new")
	public String createExpense(@Valid @ModelAttribute("expense") Expense expense,
		BindingResult result) 
	{
		if (result.hasErrors()) {
			return "form.jsp";
		} else {
	    // CODE TO MAKE A NEW BOOK AND SAVE TO THE DB
	  
	    expenseService.createExpense(expense);
	    return "redirect:/expenses";
		}
	
	}
}
