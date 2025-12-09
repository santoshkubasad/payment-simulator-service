package com.payment.simulator.controller; 
 
import com.payment.simulator.dto.SimulatePaymentRequest; 
import com.payment.simulator.service.PaymentSimulatorService; 
import io.swagger.v3.oas.annotations.Operation; 
import io.swagger.v3.oas.annotations.tags.Tag; 
import jakarta.validation.Valid; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.*; 
 
@RestController 
@RequestMapping("/api/payments") 
@Tag(name = "Payment Simulation", description = "APIs for simulating payment gateway operations") 
public class PaymentController { 
 
    @Autowired 
    private PaymentSimulatorService paymentSimulatorService; 
 
    @PostMapping("/simulate") 
    @Operation(summary = "Simulate a payment and trigger webhook") 
    public ResponseEntity<String> simulatePayment(@Valid @RequestBody SimulatePaymentRequest request) { 
        try { 
            String result = paymentSimulatorService.simulatePayment(request); 
            return ResponseEntity.ok(result); 
        } catch (Exception e) { 
            return ResponseEntity.badRequest().body("Payment simulation failed: " + e.getMessage()); 
        } 
    } 
}
