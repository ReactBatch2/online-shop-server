package com.hostmdy.shop.service.impl;

import org.springframework.stereotype.Service;

import com.hostmdy.shop.domain.Payment;
import com.hostmdy.shop.domain.UserPayment;
import com.hostmdy.shop.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService{

	@Override
	public Payment setByUserPayment(UserPayment userPayment, Payment payment) {
		payment.setType(userPayment.getType());
		payment.setHolderName(userPayment.getHolderName());
		payment.setCardNumber(userPayment.getCardNumber());
		payment.setExpiryMonth(userPayment.getExpiryMonth());
		payment.setExpiryYear(userPayment.getExpiryYear());
		payment.setCvc(userPayment.getCvc());
		
		return payment;
	}

}
