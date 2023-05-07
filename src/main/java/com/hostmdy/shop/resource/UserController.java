package com.hostmdy.shop.resource;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hostmdy.shop.domain.User;
import com.hostmdy.shop.domain.security.Role;
import com.hostmdy.shop.domain.security.UserRoles;
import com.hostmdy.shop.service.RoleService;
import com.hostmdy.shop.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:3000"})
public class UserController {
	
	private final UserService userService;
	private final RoleService roleService;
	
	 @GetMapping("/username/{username}")
     public ResponseEntity<?> getUserByUsername(@PathVariable String username) {
		
		 Optional<User> userOpt = userService.findByUsername(username);
		 
		 if(userOpt.isEmpty()) {
			 return new ResponseEntity<String>("User not found!",HttpStatus.NOT_FOUND);
		 }
		  
		 return new ResponseEntity<User>(userOpt.get(), HttpStatus.OK);
	 }
	 
	 @GetMapping("/id/{id}")
     public ResponseEntity<?> getUserById(@PathVariable Long id) {
		
		 Optional<User> userOpt = userService.findById(id);
		 
		 if(userOpt.isEmpty()) {
			 return new ResponseEntity<String>("User not found!",HttpStatus.NOT_FOUND);
		 }
		  
		 return new ResponseEntity<User>(userOpt.get(), HttpStatus.OK);
	 }
	 
	 @PostMapping("/create")
	 public ResponseEntity<?> register(@Valid @RequestBody User user) {
		 Optional<Role> roleOpt = roleService.findById(1L);
		 
		 if(roleOpt.isEmpty()) {
			 return new ResponseEntity<String>("role not found",HttpStatus.INTERNAL_SERVER_ERROR);
		 }
		 
		 Set<UserRoles> userRoles = new HashSet<>();
		 userRoles.add(new UserRoles(user, roleOpt.get()));
		 
		 
		 return new ResponseEntity<User>(userService.createUser(user, userRoles), HttpStatus.CREATED);
	 }
}
