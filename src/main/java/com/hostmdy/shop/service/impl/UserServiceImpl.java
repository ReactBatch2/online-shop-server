package com.hostmdy.shop.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hostmdy.shop.domain.ShoppingCart;
import com.hostmdy.shop.domain.User;
import com.hostmdy.shop.domain.UserBilling;
import com.hostmdy.shop.domain.UserPayment;
import com.hostmdy.shop.domain.UserShipping;
import com.hostmdy.shop.domain.security.UserRoles;
import com.hostmdy.shop.exception.UsernameAlreadyExistsException;
import com.hostmdy.shop.repository.RoleRepository;
import com.hostmdy.shop.repository.UserPaymentRepository;
import com.hostmdy.shop.repository.UserRepository;
import com.hostmdy.shop.repository.UserShippingRepository;
import com.hostmdy.shop.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
	
	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	private final BCryptPasswordEncoder passwordEncoder;
	private final UserPaymentRepository userPaymentRepository;
	private final UserShippingRepository userShippingRepository;

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
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		ShoppingCart shoppingCart = new ShoppingCart();
		shoppingCart.setUser(user);
		user.setShoppingCart(shoppingCart);
		
		user.setUserShippingList(new ArrayList<UserShipping>());
		user.setUserPaymentList(new ArrayList<UserPayment>());
		
		return saveUser(user);
	}

	@Override
	public Optional<User> findById(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}
	
	@Override
	public void updateUserBilling(UserBilling userBilling, UserPayment userPayment, User user) {
		userPayment.setUser(user);
		userPayment.setUserBilling(userBilling);
		userPayment.setDefaultPayment(true);
		userBilling.setUserPayment(userPayment);
		user.getUserPaymentList().add(userPayment);
		saveUser(user);
	}
	
	@Override
	public void updateUserShipping(UserShipping userShipping, User user){
		userShipping.setUser(user);
		userShipping.setUserShippingDefault(true);
		user.getUserShippingList().add(userShipping);
		saveUser(user);
	}
	
	@Override
	public void setUserDefaultPayment(Long userPaymentId, User user) {
		List<UserPayment> userPaymentList = (List<UserPayment>) userPaymentRepository.findAll();
		
		for (UserPayment userPayment : userPaymentList) {
			if(userPayment.getId() == userPaymentId) {
				userPayment.setDefaultPayment(true);
				userPaymentRepository.save(userPayment);
			} else {
				userPayment.setDefaultPayment(false);
				userPaymentRepository.save(userPayment);
			}
		}
	}
	
	@Override
	public void setUserDefaultShipping(Long userShippingId, User user) {
		List<UserShipping> userShippingList = (List<UserShipping>) userShippingRepository.findAll();
		
		for (UserShipping userShipping : userShippingList) {
			if(userShipping.getId() == userShippingId) {
				userShipping.setUserShippingDefault(true);
				userShippingRepository.save(userShipping);
			} else {
				userShipping.setUserShippingDefault(false);
				userShippingRepository.save(userShipping);
			}
		}
	}


}
