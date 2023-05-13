package com.hostmdy.shop.service;

import com.hostmdy.shop.domain.Payment;
import com.hostmdy.shop.domain.UserPayment;

public interface PaymentService {
	Payment setByUserPayment(UserPayment userPayment, Payment payment);
}
