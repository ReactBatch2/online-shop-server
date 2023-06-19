package com.hostmdy.shop.service;

import com.hostmdy.shop.payload.EmailRequest;

public interface EmailService {
	
	void sendEmail(EmailRequest email);

}
