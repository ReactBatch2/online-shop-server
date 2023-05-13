package com.hostmdy.shop.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.hostmdy.shop.domain.CartItem;
import com.hostmdy.shop.domain.Order;
import com.hostmdy.shop.domain.ShoppingCart;

public interface CartItemRepository extends CrudRepository<CartItem,Long> {
	List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);
	
	List<CartItem> findByOrder(Order order);
}
