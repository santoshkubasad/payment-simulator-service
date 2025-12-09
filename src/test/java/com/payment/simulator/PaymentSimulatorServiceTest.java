package com.payment.simulator; 
 
import com.payment.simulator.dto.SimulatePaymentRequest; 
import com.payment.simulator.service.PaymentSimulatorService; 
import org.junit.jupiter.api.Test; 
import org.junit.jupiter.api.extension.ExtendWith; 
import org.mockito.InjectMocks; 
import org.mockito.Mock; 
import org.mockito.junit.jupiter.MockitoExtension; 
import org.springframework.web.client.RestTemplate; 
import org.springframework.web.client.RestClientException;
import java.math.BigDecimal; 
import static org.junit.jupiter.api.Assertions.*; 
import static org.mockito.ArgumentMatchers.*; 
import static org.mockito.Mockito.when; 
 
@ExtendWith(MockitoExtension.class) 
public class PaymentSimulatorServiceTest { 
 
    @Mock 
    private RestTemplate restTemplate; 
 
    @InjectMocks 
    private PaymentSimulatorService paymentSimulatorService; 

    @Test
    public void testSimulatePayment_Success() {
       
        SimulatePaymentRequest request = new SimulatePaymentRequest();
        request.setBookingId("BK001");
        request.setAmountPaid(BigDecimal.valueOf(500.00));
        
        String expectedResponse = "Payment processed";
        when(restTemplate.postForObject(anyString(), any(), eq(String.class)))
                .thenReturn(expectedResponse);
        
       
        String result = paymentSimulatorService.simulatePayment(request);
        
       
        assertNotNull(result);
        assertEquals(expectedResponse, result);
    }

   

    @Test
    public void testSimulatePayment_RestTemplateException() {
       
        SimulatePaymentRequest request = new SimulatePaymentRequest();
        request.setBookingId("BK003");
        request.setAmountPaid(BigDecimal.valueOf(250));
        
        when(restTemplate.postForObject(anyString(), any(), eq(String.class)))
                .thenThrow(new RestClientException("Connection timeout"));
        
      
        RuntimeException exception = assertThrows(RuntimeException.class, 
                () -> paymentSimulatorService.simulatePayment(request));
        
        assertTrue(exception.getMessage().contains("Failed to send webhook"));
        assertTrue(exception.getMessage().contains("Connection timeout"));
    }

    @Test
    public void testSimulatePayment_NullResponse() {
        // Arrange
        SimulatePaymentRequest request = new SimulatePaymentRequest();
        request.setBookingId("BK004");
        request.setAmountPaid(BigDecimal.valueOf(100.00));
        
        when(restTemplate.postForObject(anyString(), any(), eq(String.class)))
                .thenReturn(null);
        
        
        String result = paymentSimulatorService.simulatePayment(request);
        
        
        assertNull(result);
    }

   
}