package com.tidz.expenseManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tidz.expenseManager.model.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

}
