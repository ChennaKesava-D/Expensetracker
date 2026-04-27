package com.example.Expensetracking;

import com.example.Expensetracking.Model.Expense;
import com.example.Expensetracking.service.ExpenseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
public class ExpensetrackingApplication implements CommandLineRunner {

    @Autowired
    private ExpenseService expenseService;

    public static void main(String[] args) {
        SpringApplication.run(ExpensetrackingApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("----------- RUNNING LOGIC CHECK -----------");

//        // 1. Setup: Create and save some sample expenses
//        expenseService.saveExpense(new Expense("Groceries", new BigDecimal("150.75"), LocalDate.now()));
//        expenseService.saveExpense(new Expense("Fuel", new BigDecimal("300.00"), LocalDate.now()));
//        expenseService.saveExpense(new Expense("Coffee", new BigDecimal("25.50"), LocalDate.now()));

        // 2. Action: Call the method we want to check
//        BigDecimal total = expenseService.getTotalExpenses();
//        BigDecimal expectedTotal = new BigDecimal("476.25");
//
//        // 3. Verification: Print the results to the console
//        System.out.println("Calculated Total Expenses: " + total);
//        System.out.println("Expected Total Expenses:   " + expectedTotal);
//
//        if (total.equals(expectedTotal)) {
//            System.out.println("SUCCESS: The total is calculated correctly!");
//        } else {
//            System.out.println("FAILURE: The total is incorrect!");
//        }
//        System.out.println("----------- LOGIC CHECK COMPLETE -----------");
    }
}
