package com.hostmdy.shop.service;

import java.util.Optional;

import com.hostmdy.shop.domain.UserPayment;

public interface UserPaymentService {
	Optional<UserPayment> findById(Long id);
	
	void removeById(Long id);
}
