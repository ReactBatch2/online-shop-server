package com.hostmdy.shop.service;

import java.util.Optional;

import com.hostmdy.shop.domain.security.Role;

public interface RoleService {
	Optional<Role> findById(Long id);
}
