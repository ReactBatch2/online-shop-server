package com.hostmdy.shop.service;

import com.hostmdy.shop.payload.AttachmentEmailRequest;
import com.hostmdy.shop.payload.OrderConfirmEmailRequest;
import com.hostmdy.shop.payload.SimpleEmailRequest;

public interface EmailService {
	
	void sendEmail(SimpleEmailRequest email);
	
	void sendTemplateEmail(OrderConfirmEmailRequest email);
	
	void sendAttachmentEmail(AttachmentEmailRequest email);

}
