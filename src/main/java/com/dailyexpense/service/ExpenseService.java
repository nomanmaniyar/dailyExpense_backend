package com.dailyexpense.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dailyexpense.dto.ExpenseDTO;
import com.dailyexpense.entity.Expense;
import com.dailyexpense.entity.Payment;
import com.dailyexpense.repository.ExpenseRepository;
import com.dailyexpense.repository.PaymentRepository;

@Service
public class ExpenseService {

    @Autowired
    ExpenseRepository expenseRepository;

    @Autowired
    PaymentRepository paymentRepository;

    public List<ExpenseDTO> getAllExpense() {
        return expenseRepository.findAll().stream().map(expense -> mapToDTO(expense)).collect(Collectors.toList());
    }

    public ExpenseDTO savExpense(ExpenseDTO expenseDTO) {
        Payment payment = paymentRepository.findById(expenseDTO.getPaymentId()).orElseThrow(() -> new RuntimeException("Payment Not Found"));

        Expense expense = new Expense();
        expense.setExpenseType(expenseDTO.getExpenseType());
        expense.setPayee(expenseDTO.getPayee());
        expense.setCategory(expenseDTO.getCategory());
        expense.setDate(expenseDTO.getDate());
        expense.setAmount(expenseDTO.getAmount());
        expense.setPayment(payment);

        Expense savedExpense = expenseRepository.save(expense);
        return mapToDTO(savedExpense);
    }

    private ExpenseDTO mapToDTO(Expense expense) {
        ExpenseDTO expenseDTO = new ExpenseDTO();

        expenseDTO.setId(expense.getId());
        expenseDTO.setExpenseType(expense.getExpenseType());
        expenseDTO.setPayee(expense.getPayee());
        expenseDTO.setAmount(expense.getAmount());
        expenseDTO.setCategory(expense.getCategory());
        expenseDTO.setDate(expense.getDate());
        expenseDTO.setPaymentId(expense.getPayment().getId());

        return expenseDTO;
    }

}
