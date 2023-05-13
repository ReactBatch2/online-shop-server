package com.hostmdy.shop.repository;

import org.springframework.data.repository.CrudRepository;
import com.hostmdy.shop.domain.CartItem;
import com.hostmdy.shop.domain.ProductToCartItem;

public interface ProductToCartItemRepository extends CrudRepository<ProductToCartItem,Long>{
	void deleteByCartItem(CartItem cartItem);
}
