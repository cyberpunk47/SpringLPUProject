package com.example.payment_service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PayementService payementService;

    public PaymentController(PayementService payementService) {
        this.payementService = payementService;
    }

    @PostMapping("/create")
    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
        return new ResponseEntity<>(payementService.createPayment(payment), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Payment>> getAllPayments() {
        return ResponseEntity.ok(payementService.getAllPayments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable Long id) {
        return ResponseEntity.ok(payementService.getPaymentById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Payment> updatePayment(@PathVariable Long id, @RequestBody Payment payment) {
        return ResponseEntity.ok(payementService.updatePayment(id, payment));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable Long id) {
        payementService.deletePayment(id);
        return ResponseEntity.noContent().build();
    }
}
