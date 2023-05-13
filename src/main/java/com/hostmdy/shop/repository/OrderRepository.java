package com.hostmdy.shop.repository;

import org.springframework.data.repository.CrudRepository;

import com.hostmdy.shop.domain.Order;

public interface OrderRepository extends CrudRepository<Order,Long>{

}
