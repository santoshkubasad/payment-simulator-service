package com.payment.simulator.dto; 
 
import java.math.BigDecimal; 
import java.time.LocalDateTime; 
 
public class WebhookPayload { 
    private String transactionId; 
    private String bookingId; 
    private BigDecimal amountPaid; 
    private LocalDateTime paymentTime; 
 
    // Constructors 
    public WebhookPayload() {} 
 
    public WebhookPayload(String transactionId, String bookingId, BigDecimal amountPaid, LocalDateTime paymentTime) { 
        this.transactionId = transactionId; 
        this.bookingId = bookingId; 
        this.amountPaid = amountPaid; 
        this.paymentTime = paymentTime; 
    } 
 
    // Getters and setters 
    public String getTransactionId() { return transactionId; } 
    public void setTransactionId(String transactionId) { this.transactionId = transactionId; } 
    public String getBookingId() { return bookingId; } 
    public void setBookingId(String bookingId) { this.bookingId = bookingId; } 
    public BigDecimal getAmountPaid() { return amountPaid; } 
    public void setAmountPaid(BigDecimal amountPaid) { this.amountPaid = amountPaid; } 
    public LocalDateTime getPaymentTime() { return paymentTime; } 
    public void setPaymentTime(LocalDateTime paymentTime) { this.paymentTime = paymentTime; } 
}
