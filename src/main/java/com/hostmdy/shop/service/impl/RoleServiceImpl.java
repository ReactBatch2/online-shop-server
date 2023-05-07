package com.hostmdy.shop.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hostmdy.shop.domain.security.Role;
import com.hostmdy.shop.repository.RoleRepository;
import com.hostmdy.shop.service.RoleService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService{
	private final RoleRepository roleRepository;
	

	@Override
	public Optional<Role> findById(Long id) {
		// TODO Auto-generated method stub
		return roleRepository.findById(id);
	}

}
