package com.hostmdy.shop.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hostmdy.shop.domain.UserPayment;
import com.hostmdy.shop.repository.UserPaymentRepository;
import com.hostmdy.shop.service.UserPaymentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserPaymentServiceImpl implements UserPaymentService{

	private final UserPaymentRepository userPaymentRepository;
	
	@Override
	public Optional<UserPayment> findById(Long id) {
		// TODO Auto-generated method stub
		return userPaymentRepository.findById(id);
	}

	@Override
	public void removeById(Long id) {
		// TODO Auto-generated method stub
		userPaymentRepository.deleteById(id);
	}

}
