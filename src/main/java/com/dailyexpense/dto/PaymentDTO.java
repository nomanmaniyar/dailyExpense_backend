package com.dailyexpense.dto;

import lombok.Getter;
import lombok.Setter;

public class PaymentDTO {

    @Setter
    @Getter
    private Long id;
    @Setter
    @Getter
    private String paymentMode;
    @Setter
    @Getter
    private String details;

}
