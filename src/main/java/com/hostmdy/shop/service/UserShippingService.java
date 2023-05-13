package com.hostmdy.shop.service;

import java.util.Optional;

import com.hostmdy.shop.domain.UserShipping;

public interface UserShippingService {
	Optional<UserShipping> findById(Long id);
	
	void removeById(Long id);
}
