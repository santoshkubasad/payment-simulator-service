package com.payment.simulator.dto; 
 
import jakarta.validation.constraints.NotBlank; 
import jakarta.validation.constraints.NotNull; 
import jakarta.validation.constraints.Positive; 
import java.math.BigDecimal; 
 
public class SimulatePaymentRequest { 
    @NotBlank 
    private String bookingId; 
 
    @NotNull 
    @Positive 
    private BigDecimal amountPaid; 
 
    // Constructors 
    public SimulatePaymentRequest() {} 
 
    // Getters and setters 
    public String getBookingId() { return bookingId; } 
    public void setBookingId(String bookingId) { this.bookingId = bookingId; } 
    public BigDecimal getAmountPaid() { return amountPaid; } 
    public void setAmountPaid(BigDecimal amountPaid) { this.amountPaid = amountPaid; } 
}
