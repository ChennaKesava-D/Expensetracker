package com.example.Expensetracking.service;

import com.example.Expensetracking.Model.Expense;
import java.util.List;
import java.math.BigDecimal;

public interface ExpenseService {
    List<Expense> getAllExpenses();
    void saveExpense(Expense expense);
    Expense getExpenseById(Long id);
    void deleteExpenseById(Long id);
    BigDecimal getTotalExpenses();
}