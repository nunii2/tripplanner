package com.unamurko.tripplanner.controller;

import com.unamurko.tripplanner.entity.Expense;
import com.unamurko.tripplanner.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("/api/trips")
@RequiredArgsConstructor
public class ExpenseController {

    private final ExpenseService expenseService;

    // GET /api/trips/1/expenses - get all expenses for a trip
    @GetMapping("/{tripId}/expenses")
    public List<Expense> getExpenses(@PathVariable Long tripId) {
        return expenseService.getExpensesByTripId(tripId);
    }

    // GET /api/trips/1/expenses/2 - get one specific expense
    @GetMapping("/{tripId}/expenses/{id}")
    public Expense getExpense(@PathVariable Long tripId, @PathVariable Long id) {
        return expenseService.getExpenseById(id);
    }

    // POST /api/trips/1/expenses - create expense for a trip
    @PostMapping("/{tripId}/expenses")
    public Expense createExpense(@PathVariable Long tripId, @RequestBody Expense expense) {
        expense.setTripId(tripId);  // automatically set the tripId from the URL
        return expenseService.createExpense(expense);
    }

    // DELETE /api/trips/1/expenses/2 - delete a specific expense
    @DeleteMapping("/{tripId}/expenses/{id}")
    public String deleteExpense(@PathVariable Long tripId, @PathVariable Long id) {
        expenseService.deleteExpense(id);
        return "Expense deleted";
    }
}
