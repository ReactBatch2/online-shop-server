package com.hostmdy.shop.service;

import java.util.Optional;

import com.hostmdy.shop.domain.User;

public interface UserService {
	Optional<User> findByUsername(String username);
	
	User saveUser(User user);
	
	User createUser(User user);
	
	Optional<User> findById(Long id);
}
