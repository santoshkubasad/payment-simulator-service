package com.payment.simulator.service; 
 
import com.payment.simulator.dto.SimulatePaymentRequest; 
import com.payment.simulator.dto.WebhookPayload; 
import org.springframework.beans.factory.annotation.Value; 
import org.springframework.http.HttpEntity; 
import org.springframework.http.HttpHeaders; 
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service; 
import org.springframework.web.client.RestTemplate; 
import java.math.BigDecimal; 
import java.time.LocalDateTime; 
import java.util.UUID; 
 
@Service 
public class PaymentSimulatorService { 
 
    @Value("${travel.booking.service.url:http://localhost:8080}") 
    private String travelBookingServiceUrl; 
 
    private final RestTemplate restTemplate; 
    
    // Constructor injection for better testability
    public PaymentSimulatorService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
 
    public String simulatePayment(SimulatePaymentRequest request) { 
        // Generate unique transaction ID 
        String transactionId = UUID.randomUUID().toString(); 
 
        // Create webhook payload 
        WebhookPayload payload = new WebhookPayload( 
            transactionId, 
            request.getBookingId(), 
            request.getAmountPaid(), 
            LocalDateTime.now() 
        ); 
 
        // Send webhook to Travel Booking Service 
        String webhookUrl = travelBookingServiceUrl + "/webhooks/payments"; 
        HttpHeaders headers = new HttpHeaders(); 
        headers.setContentType(MediaType.APPLICATION_JSON); 
        HttpEntity<WebhookPayload> entity = new HttpEntity<>(payload, headers); 
 
        try { 
           String response = restTemplate.postForObject(webhookUrl, entity, String.class); 
           return response; 
        } catch (Exception e) { 
            throw new RuntimeException("Failed to send webhook: " + e.getMessage(), e); 
        } 
    } 
}