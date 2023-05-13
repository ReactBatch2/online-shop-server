package com.hostmdy.shop.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hostmdy.shop.domain.UserShipping;
import com.hostmdy.shop.repository.UserShippingRepository;
import com.hostmdy.shop.service.UserShippingService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserShippingServiceImpl implements UserShippingService{
	
	private final UserShippingRepository userShippingRepository;
	
	@Override
	public Optional<UserShipping> findById(Long id) {
		// TODO Auto-generated method stub
		return userShippingRepository.findById(id);
	}

	@Override
	public void removeById(Long id) {
		// TODO Auto-generated method stub
		userShippingRepository.deleteById(id);
	}

}
