package com.example.Expensetracking.Controller;

import com.example.Expensetracking.Model.Expense;
import com.example.Expensetracking.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    // Display the list of expenses and the total
    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listExpenses", expenseService.getAllExpenses());
        model.addAttribute("totalExpenses", expenseService.getTotalExpenses());
        return "index"; // This will look for index.html in the templates folder
    }

    // Show the form to add a new expense
    @GetMapping("/showNewExpenseForm")
    public String showNewExpenseForm(Model model) {
        Expense expense = new Expense();
        model.addAttribute("expense", expense);
        return "new_expense"; // Looks for new_expense.html
    }

    // Save an expense to the database
    @PostMapping("/saveExpense")
    public String saveExpense(@ModelAttribute("expense") Expense expense) {
        expenseService.saveExpense(expense);
        return "redirect:/"; // Redirect back to the home page
    }

    // Show the form to update an expense
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        Expense expense = expenseService.getExpenseById(id);
        model.addAttribute("expense", expense);
        return "update_expense"; // Looks for update_expense.html
    }

    // Delete an expense
    @GetMapping("/deleteExpense/{id}")
    public String deleteExpense(@PathVariable(value = "id") long id) {
        this.expenseService.deleteExpenseById(id);
        return "redirect:/"; // Redirect back to the home page
    }
}
