package com.hostmdy.shop.domain.security;

import org.springframework.security.core.GrantedAuthority;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Authority implements GrantedAuthority{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2563323055287141262L;
	private final String authority;
	
	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return authority;
	}
	
}
