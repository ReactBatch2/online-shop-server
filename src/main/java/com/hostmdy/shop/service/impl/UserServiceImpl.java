package com.hostmdy.shop.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hostmdy.shop.domain.User;
import com.hostmdy.shop.repository.UserRepository;
import com.hostmdy.shop.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
	
	private final UserRepository userRepository;

	@Override
	public Optional<User> findByUsername(String username) {
		// TODO Auto-generated method stub
		return userRepository.findByUsername(username);
	}

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		return saveUser(user);
	}

	@Override
	public Optional<User> findById(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}

}
