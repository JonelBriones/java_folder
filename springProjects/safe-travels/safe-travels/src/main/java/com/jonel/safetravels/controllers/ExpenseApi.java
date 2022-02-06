package com.jonel.safetravels.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jonel.safetravels.models.Expense;
import com.jonel.safetravels.services.ExpenseService;

//..

public class ExpenseApi {
 private final ExpenseService expenseService;
 public ExpenseApi(ExpenseService expenseService){
     this.expenseService = expenseService;
 }
 @RequestMapping("/expenses")
 public List<Expense> index() {
     return expenseService.allExpenses();
 }
 
 @RequestMapping(value="/expenses", method=RequestMethod.POST)
 public Expense create(@RequestParam(value="item") String item, @RequestParam(value="vendor") String vendor, @RequestParam(value="amount") int amount, @RequestParam(value="description") String desc) {
	 Expense expense = new Expense(item, vendor, amount, desc);
     return expenseService.createExpense(expense);
 }
// @RequestMapping(value="/expenses/update/{id}", method=RequestMethod.PUT)
// public Expense updateExpense(@PathVariable("id") Long id, @RequestParam(value="item") String item, @RequestParam(value="vendor") String vendor,@RequestParam(value="amount") int amount,@RequestParam(value="description") String description) {
//     Expense expense = expenseService.update(item, vendor, amount, description);
//     return expense;
// }
 
 @RequestMapping(value="/expense/delete/{id}", method=RequestMethod.DELETE)
 public void destroy(@PathVariable("id") Long id) {
     expenseService.deleteExpense(id);
 }
}


