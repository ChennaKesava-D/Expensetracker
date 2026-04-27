package com.example.Expensetracking.service;

import com.example.Expensetracking.Model.Expense;
import com.example.Expensetracking.repository.ExpenseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Override
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    @Override
    public void saveExpense(Expense expense) {
        expenseRepository.save(expense);
    }

    @Override
    public Expense getExpenseById(Long id) {
        Optional<Expense> optional = expenseRepository.findById(id);
        Expense expense = null;
        if (optional.isPresent()) {
            expense = optional.get();
        } else {
            throw new RuntimeException("Expense not found for id :: " + id);
        }
        return expense;
    }

    @Override
    public void deleteExpenseById(Long id) {
        this.expenseRepository.deleteById(id);
    }

    @Override
    public BigDecimal getTotalExpenses() {
        return expenseRepository.findAll().stream()
                .map(Expense::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
