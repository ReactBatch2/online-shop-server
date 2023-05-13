package com.hostmdy.shop.payload;

import java.util.List;

import com.hostmdy.shop.domain.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class JwtLoginSuccessResponse {
	
	private boolean success;
	private String token;
	private User user;
	private List<String> roleList;

}
