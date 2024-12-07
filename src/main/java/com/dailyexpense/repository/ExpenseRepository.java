package com.dailyexpense.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dailyexpense.entity.Expense;
import java.util.List;
import java.time.LocalDate;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    List<Expense> findByCategory(String category);

    List<Expense> findByDate(LocalDate date);

    List<Expense> findByPaymentId(Long paymentId);

}
