package com.hostmdy.shop.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hostmdy.shop.domain.Product;

public interface ProductRepository extends CrudRepository<Product,Long>{
		List<Product> findByTitleContaining(String title);
}
