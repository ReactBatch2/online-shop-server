package com.hostmdy.shop.service;

import java.util.List;
import java.util.Optional;

import com.hostmdy.shop.domain.CartItem;
import com.hostmdy.shop.domain.Order;
import com.hostmdy.shop.domain.Product;
import com.hostmdy.shop.domain.ShoppingCart;
import com.hostmdy.shop.domain.User;

public interface CartItemService {
	List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);
	
	CartItem updateCartItem(CartItem cartItem);
	
	CartItem addProductToCartItem(Product product, User user, int qty);
	
	Optional<CartItem> findById(Long id);
	
	void removeCartItem(CartItem cartItem);
	
	CartItem save(CartItem cartItem);
	
	List<CartItem> findByOrder(Order order);

}
