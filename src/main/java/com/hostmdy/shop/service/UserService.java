package com.hostmdy.shop.service;

import java.util.Optional;
import java.util.Set;

import com.hostmdy.shop.domain.User;
import com.hostmdy.shop.domain.security.UserRoles;

public interface UserService {
	Optional<User> findByUsername(String username);
	
	User saveUser(User user);
	
	User createUser(User user,Set<UserRoles> userRoles);
	
	Optional<User> findById(Long id);
}
