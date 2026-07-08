package com.example.payment_service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PayementService {

    private final PaymentRepository paymentRepository;

    public PayementService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Payment getPaymentById(Long id) {
        return paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found with id: " + id));
    }

    public Payment updatePayment(Long id, Payment paymentDetails) {
        Payment existingPayment = getPaymentById(id);
        existingPayment.setOrderId(paymentDetails.getOrderId());
        existingPayment.setAmount(paymentDetails.getAmount());
        existingPayment.setPaymentStatus(paymentDetails.getPaymentStatus());
        return paymentRepository.save(existingPayment);
    }

    public void deletePayment(Long id) {
        Payment existingPayment = getPaymentById(id);
        paymentRepository.delete(existingPayment);
    }
}
