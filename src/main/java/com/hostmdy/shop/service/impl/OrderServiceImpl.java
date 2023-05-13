package com.hostmdy.shop.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hostmdy.shop.domain.BillingAddress;
import com.hostmdy.shop.domain.CartItem;
import com.hostmdy.shop.domain.Order;
import com.hostmdy.shop.domain.Payment;
import com.hostmdy.shop.domain.Product;
import com.hostmdy.shop.domain.ShippingAddress;
import com.hostmdy.shop.domain.ShoppingCart;
import com.hostmdy.shop.domain.User;
import com.hostmdy.shop.repository.OrderRepository;
import com.hostmdy.shop.service.CartItemService;
import com.hostmdy.shop.service.OrderService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

	private final OrderRepository orderRepository;
	
	private final CartItemService cartItemService;
	
	@Override
	public synchronized Order createOrder(ShoppingCart shoppingCart,
			ShippingAddress shippingAddress,
			BillingAddress billingAddress,
			Payment payment,
			String shippingMethod,
			User user) {
		Order order = new Order();
		order.setBillingAddress(billingAddress);
		order.setOrderStatus("created");
		order.setPayment(payment);
		order.setShippingAddress(shippingAddress);
		order.setShippingMethod(shippingMethod);
		
		List<CartItem> cartItemList = cartItemService.findByShoppingCart(shoppingCart);
		
		for(CartItem cartItem : cartItemList) {
			Product product = cartItem.getProduct();
			cartItem.setOrder(order);
			product.setInStockNumber(product.getInStockNumber() - cartItem.getQty());
		}
		
		order.setCartItemList(cartItemList);
		order.setOrderDate(LocalDateTime.now());
		order.setOrderTotal(shoppingCart.getGrandTotal());
		shippingAddress.setOrder(order);
		billingAddress.setOrder(order);
		payment.setOrder(order);
		order.setUser(user);
		order = orderRepository.save(order);
		
		return order;
	}
	
	@Override
	public Optional<Order> findById(Long id) {
		return orderRepository.findById(id);
	}
}
