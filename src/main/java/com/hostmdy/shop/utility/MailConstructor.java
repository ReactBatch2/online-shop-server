package com.hostmdy.shop.utility;

import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.hostmdy.shop.payload.OrderRequest;

import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage.RecipientType;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MailConstructor {
	
	private final Environment env;
	private final TemplateEngine templateEngine;
	
	public SimpleMailMessage constructSimpleMail(String to,String subject,String text) {
		SimpleMailMessage email = new SimpleMailMessage();
		email.setFrom(env.getProperty("support.mail"));
		email.setTo(to);
		email.setSubject(subject);
		email.setText(text);
		return email;
	}
	
	public MimeMessagePreparator constructTemplateMail(String to,String subject,OrderRequest orderRequest) {
		MimeMessagePreparator messagePreparator = mimeMessage -> {
			Context context = new Context();
			context.setVariable("order", orderRequest);
			
			String text = templateEngine.process("order-confirm", context);
			
			MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
			
			messageHelper.setFrom(env.getProperty("support.mail"));
			messageHelper.setTo(new InternetAddress(to));
			messageHelper.setSubject(subject);
			messageHelper.setText(text,true);
		};
		
		return messagePreparator;
	}
	
}
