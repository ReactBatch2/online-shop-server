package com.hostmdy.shop.service.impl;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.hostmdy.shop.payload.EmailRequest;
import com.hostmdy.shop.service.EmailService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService{
	
	private final JavaMailSender sender;

	@Override
	public void sendEmail(EmailRequest email) {
		// TODO Auto-generated method stub
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setFrom("flutter.sama@gmail.com");
		mail.setTo(email.getTo());
		mail.setSubject(email.getSubject());
		mail.setText(email.getMessage());
		
		sender.send(mail);
	}

}
