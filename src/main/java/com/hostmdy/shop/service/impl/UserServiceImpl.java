package com.hostmdy.shop.service.impl;

import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hostmdy.shop.domain.User;
import com.hostmdy.shop.domain.security.UserRoles;
import com.hostmdy.shop.exception.UsernameAlreadyExistsException;
import com.hostmdy.shop.repository.RoleRepository;
import com.hostmdy.shop.repository.UserRepository;
import com.hostmdy.shop.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
	
	private final UserRepository userRepository;
	private final RoleRepository roleRepository;

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
	@Transactional
	public User createUser(User user,Set<UserRoles> userRoles) throws UsernameAlreadyExistsException{
		// TODO Auto-generated method stub
		Optional<User> userOpt = findByUsername(user.getUsername());
		
		if(userOpt.isPresent()) {
			throw new UsernameAlreadyExistsException("Username already exists!");
		}
		
		userRoles.forEach(ur -> roleRepository.save(ur.getRole()));
		
		//user associated userroles
		user.getUserRoles().addAll(userRoles);
		
		return saveUser(user);
	}

	@Override
	public Optional<User> findById(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}

}
