package com.hostmdy.shop.service;

import java.util.Optional;

import com.hostmdy.shop.domain.BillingAddress;
import com.hostmdy.shop.domain.Order;
import com.hostmdy.shop.domain.Payment;
import com.hostmdy.shop.domain.ShippingAddress;
import com.hostmdy.shop.domain.ShoppingCart;
import com.hostmdy.shop.domain.User;

public interface OrderService {
	Order createOrder(ShoppingCart shoppingCart,
			ShippingAddress shippingAddress,
			BillingAddress billingAddress,
			Payment payment,
			String shippingMethod,
			User user);
	
	Optional<Order> findById(Long id);
}
