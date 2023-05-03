package com.hostmdy.shop.repository;

import org.springframework.data.repository.CrudRepository;

import com.hostmdy.shop.domain.security.Role;

public interface RoleRepository extends CrudRepository<Role,Long>{

}
