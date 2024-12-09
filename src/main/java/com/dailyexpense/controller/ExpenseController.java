package com.dailyexpense.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dailyexpense.dto.ExpenseDTO;
import com.dailyexpense.service.ExpenseService;

@RestController
@RequestMapping("/api/expense")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping
    public List<ExpenseDTO> getAllExpense() {
        return expenseService.getAllExpense();
    }

    @PostMapping
    public ResponseEntity<ExpenseDTO> savExpenseDTO(@RequestBody ExpenseDTO expenseDTO) {
        ExpenseDTO savedExpense = expenseService.savExpense(expenseDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedExpense);
    }

}
