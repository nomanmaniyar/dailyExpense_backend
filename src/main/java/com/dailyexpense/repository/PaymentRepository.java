package com.dailyexpense.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.dailyexpense.entity.Payment;



public interface PaymentRepository extends  JpaRepository<Payment, Long> {

    Optional<Payment> findByPaymentModeAndDetails(String paymentMode, String details);        
    
}

