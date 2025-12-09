package com.payment.simulator.config; 
 
import org.springframework.context.annotation.Bean; 
import org.springframework.context.annotation.Configuration; 
import org.springframework.security.config.annotation.web.builders.HttpSecurity; 
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity; 
import org.springframework.security.web.SecurityFilterChain; 
import org.springframework.web.client.RestTemplate; 
 
@Configuration 
@EnableWebSecurity 
public class SecurityConfig { 
 
    @Bean 
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception { 
        http 
        	.csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth 
                .requestMatchers(
                   "/swagger-ui/index.html",                   
                    "/api-docs/**"                                       
                ).permitAll() 
                .anyRequest().authenticated() 
            ) 
            .httpBasic(httpBasic -> {}); // Enable HTTP Basic authentication
            //.headers(headers -> headers.frameOptions().sameOrigin()); // Allow H2 console frames
 
        return http.build(); 
    } 
 
    @Bean 
    public RestTemplate restTemplate() { 
        return new RestTemplate(); 
    } 
}