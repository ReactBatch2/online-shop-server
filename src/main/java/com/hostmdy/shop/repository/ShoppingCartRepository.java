package com.hostmdy.shop.repository;

import org.springframework.data.repository.CrudRepository;

import com.hostmdy.shop.domain.ShoppingCart;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCart,Long>{

}
