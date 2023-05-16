package com.hostmdy.shop.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UsernameAlreadyExistsExceptionResponse {
	private String message;
}
