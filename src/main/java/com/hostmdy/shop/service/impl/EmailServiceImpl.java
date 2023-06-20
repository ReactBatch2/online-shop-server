package com.hostmdy.shop.service.impl;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import com.hostmdy.shop.payload.OrderConfirmEmailRequest;
import com.hostmdy.shop.payload.SimpleEmailRequest;
import com.hostmdy.shop.service.EmailService;
import com.hostmdy.shop.utility.MailConstructor;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService{
	
	private final JavaMailSender sender;
	private final MailConstructor mailConstructor;

	@Override
	public void sendEmail(SimpleEmailRequest email) {
		// TODO Auto-generated method stub
		SimpleMailMessage mail = mailConstructor.constructSimpleMail(email.getTo(),email.getSubject(),email.getText());
		sender.send(mail);
	}

	@Override
	public void sendTemplateEmail(OrderConfirmEmailRequest email) {
		// TODO Auto-generated method stub
		MimeMessagePreparator mail = mailConstructor.constructTemplateMail(email.getTo(),email.getSubject(),email.getOrderRequest());
		sender.send(mail);
	}

}
