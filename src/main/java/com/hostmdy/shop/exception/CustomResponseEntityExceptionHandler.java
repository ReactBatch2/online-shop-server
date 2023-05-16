package com.hostmdy.shop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
@ControllerAdvice
public class CustomResponseEntityExceptionHandler {
	
	@ExceptionHandler
	public final ResponseEntity<Object> handleUsernameAlreadyExistException(
			UsernameAlreadyExistsException ex,WebRequest request){
		UsernameAlreadyExistsExceptionResponse response = new UsernameAlreadyExistsExceptionResponse(ex.getMessage());
		
		return new ResponseEntity<Object>(response,HttpStatus.BAD_REQUEST);	
	}
	
	@ExceptionHandler
	public final ResponseEntity<Object> handleUsernameNotFoundException(
			UsernameNotFoundException ex,WebRequest request){
		UsernameNotFoundExceptionResponse response = new UsernameNotFoundExceptionResponse(ex.getMessage());
		
		return new ResponseEntity<Object>(response,HttpStatus.BAD_REQUEST);	
	}

}
