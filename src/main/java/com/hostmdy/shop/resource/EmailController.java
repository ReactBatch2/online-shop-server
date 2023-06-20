package com.hostmdy.shop.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hostmdy.shop.payload.OrderConfirmEmailRequest;
import com.hostmdy.shop.payload.SimpleEmailRequest;
import com.hostmdy.shop.service.EmailService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/email")
public class EmailController {
	private final EmailService emailService;
	
	@PostMapping("/contact")
	public ResponseEntity<String> sendEmail(@RequestBody SimpleEmailRequest emailRequest){
		emailService.sendEmail(emailRequest);
		
		return ResponseEntity.ok("Email Sent");
	}
	
	@PostMapping("/order")
	public ResponseEntity<String> sendOrderConfirmEmail(@RequestBody OrderConfirmEmailRequest emailRequest){
		emailService.sendTemplateEmail(emailRequest);
		
		return ResponseEntity.ok("Email Sent");
	}

}
