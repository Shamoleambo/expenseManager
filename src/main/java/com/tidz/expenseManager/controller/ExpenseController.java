package com.tidz.expenseManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.tidz.expenseManager.model.Expense;
import com.tidz.expenseManager.service.ExpenseService;

@Controller
public class ExpenseController {

	@Autowired
	private ExpenseService expenseService;

	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listExpenses", this.expenseService.getAllExpenses());
		return "index";
	}

	@GetMapping("/showNewExpenseForm")
	public String showNewExpenseForm(Model model) {
		Expense expense = new Expense();
		model.addAttribute("expense", expense);
		return "addExpense";
	}

	@PostMapping("/saveExpense")
	public String saveExpense(@ModelAttribute("expense") Expense expense) {
		this.expenseService.saveExpense(expense);
		return "redirect:/";
	}

	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable("id") Long id, Model model) {
		Expense expense = this.expenseService.getExpenseById(id);
		model.addAttribute("expense", expense);
		return "updateExpense";
	}

	@GetMapping("/deleteExpense/{id}")
	public String deleteExpense(@PathVariable("id") Long id) {
		this.expenseService.deleteExpense(id);
		return "redirect:/";
	}
}
