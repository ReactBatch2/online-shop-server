package com.hostmdy.shop.service;

import java.util.Optional;
import java.util.Set;

import com.hostmdy.shop.domain.User;
import com.hostmdy.shop.domain.UserBilling;
import com.hostmdy.shop.domain.UserPayment;
import com.hostmdy.shop.domain.UserShipping;
import com.hostmdy.shop.domain.security.UserRoles;

public interface UserService {
	Optional<User> findByUsername(String username);
	
	User saveUser(User user);
	
	User createUser(User user,Set<UserRoles> userRoles);
	
	Optional<User> findById(Long id);
	
	void updateUserBilling(UserBilling userBilling, UserPayment userPayment, User user);
	
	void updateUserShipping(UserShipping userShipping, User user);
	
	void setUserDefaultPayment(Long userPaymentId, User user);
	
	void setUserDefaultShipping(Long userShippingId, User user);
}
