package com.tidz.expenseManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tidz.expenseManager.model.Expense;
import com.tidz.expenseManager.repository.ExpenseRepository;

@Service
public class ExpenseService {

	@Autowired
	private ExpenseRepository expenseRepo;

	public List<Expense> getAllExpenses() {
		return this.expenseRepo.findAll();
	}

	public void saveExpense(Expense expense) {
		this.expenseRepo.save(expense);
	}

	public Expense getExpenseById(Long id) {
		Expense expense = this.expenseRepo.findById(id).orElse(null);
		return expense;
	}
	
	public void deleteExpense(Long id) {
		this.expenseRepo.deleteById(id);
	}
}
