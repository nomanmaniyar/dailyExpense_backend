package com.dailyexpense.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dailyexpense.dto.PaymentDTO;
import com.dailyexpense.entity.Payment;
import com.dailyexpense.repository.PaymentRepository;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public List<PaymentDTO> getAllPayment() {
        return paymentRepository.findAll().stream().map(payment -> mapToDto(payment)).collect(Collectors.toList());
    }

    public PaymentDTO savePayment(PaymentDTO paymentDTO) {

        Payment payment = new Payment();
        payment.setDetails(paymentDTO.getDetails());
        payment.setPaymentMode(paymentDTO.getPaymentMode());

        Payment savedPayment = paymentRepository.save(payment);
        return mapToDto(savedPayment);
    }

    private PaymentDTO mapToDto(Payment payment) {
        PaymentDTO paymentDTO = new PaymentDTO();

        paymentDTO.setId(payment.getId());
        paymentDTO.setPaymentMode(payment.getPaymentMode());
        paymentDTO.setDetails(payment.getDetails());

        return paymentDTO;
    }
}
