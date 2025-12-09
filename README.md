# payment-simulator-service

# Travel Booking and Payment Simulator Services 
 
## Applications 
 
 
### 2. Payment Simulator Service (Port 8081) 
- Simulates a payment gateway 
- Triggers webhook calls to Travel Booking Service 
- Exposes authenticated REST APIs 
- Swagger UI: http://localhost:8081/swagger-ui/index.html
 
## Prerequisites 
 
- Java 17 or higher 
- Maven 3.6+ 
 
## Running the Applications 
  
### Step 1: Start Payment Simulator Service 
``` 
cd payment-simulator-service 
mvn spring-boot:run 
``` 
 
## API Endpoints 
 
 
### Payment Simulator Service (http://localhost:8081) 
 
- **POST /api/payments/simulate** - Simulate payment (triggers webhook) 
 
## Authentication 
 
Both applications use Basic Authentication: 
- Username: santosh 
- Password: password123
 
## Testing the Webhook Communication 
 
 
### Example 2: Simulate Payment (Triggers Webhook) 
``` 
curl -X POST http://localhost:8081/api/payments/simulate \ 
  -H "Content-Type: application/json" \ 
  -H "Authorization: Basic c2FudG9zaDpwYXNzd29yZDEyMw==" \ 
  -d "{" 
  "\"bookingId\": \"BK001\"," 
  "\"amountPaid\": 500.00" 
  "}" 
``` 
 
 
 

