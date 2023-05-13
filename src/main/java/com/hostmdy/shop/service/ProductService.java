package com.hostmdy.shop.service;

import java.util.List;
import java.util.Optional;

import com.hostmdy.shop.domain.Product;

public interface ProductService {
	Product save(Product product);
	
	Optional<Product> findById(Long id);
	
	List<Product> findAll();
	
	void delete(Long id);
	
}
