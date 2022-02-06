package com.jonel.safetravels.services;
import java.util.List;
import java.util.Optional;

//...
import org.springframework.stereotype.Service;

import com.jonel.safetravels.models.Expense;
import com.jonel.safetravels.repositories.ExpenseRepository;
@Service
public class ExpenseService {
 // adding the book repository as a dependency
	private final ExpenseRepository expenseRepository;
 
 public ExpenseService(ExpenseRepository expenseRepository) {
	 this.expenseRepository = expenseRepository;
 }
 // returns all the books
 public List<Expense> allExpenses() {
     return expenseRepository.findAll();
 }
 // creates a book
 public Expense createExpense(Expense b) {
     return expenseRepository.save(b);
 }
 public Expense updateExpense(Expense b) {
     return expenseRepository.save(b);
 }

 // retrieves a book
 public Expense findExpense(Long id) {
     Optional<Expense> optionalExpense = expenseRepository.findById(id);
     if(optionalExpense.isPresent()) {
         return optionalExpense.get();
     } else {
         return null;
     }
 }

  public void deleteExpense(Long id) {
	  expenseRepository.deleteById(id);
  }

}