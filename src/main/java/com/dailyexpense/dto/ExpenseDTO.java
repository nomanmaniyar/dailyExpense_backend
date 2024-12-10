package com.dailyexpense.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

public class ExpenseDTO {

    @Setter
    @Getter
    private long id;
    @Setter
    @Getter
    @NotNull(message = "Something is worng with the expenseType")
    @Size(min = 1, max = 50)
    private String expenseType;
    @Setter
    @Getter
    @NotNull
    @Size(min = 1, max = 50)
    private String payee;
    @Setter
    @Getter
    @NotNull
    @Size(min = 1, max = 50)
    private String category;
    @Setter
    @Getter
    @NotNull
    private LocalDate date;
    @Setter
    @Getter
    @Positive
    private Double amount;
    @Setter
    @Getter
    private Long paymentId; // Optional, can be null if creating a new payment
    @Setter
    @Getter
    private String paymentMode; // Required for new payment
    @Setter
    @Getter
    private String paymentDetails; // Required for new payment

}
