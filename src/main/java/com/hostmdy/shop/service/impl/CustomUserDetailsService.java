package com.hostmdy.shop.service.impl;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hostmdy.shop.domain.User;
import com.hostmdy.shop.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService{
	
	private final UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> userOpt = userRepository.findByUsername(username);
		
		if(userOpt.isEmpty()) {
			throw new UsernameNotFoundException("Username not found!");
		}
		
		return userOpt.get();
	}

}
