package com.hostmdy.shop;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.hostmdy.shop.domain.User;
import com.hostmdy.shop.domain.security.Role;
import com.hostmdy.shop.domain.security.UserRoles;
import com.hostmdy.shop.service.RoleService;
import com.hostmdy.shop.service.UserService;

@SpringBootApplication
public class OnlineShopServerApplication implements CommandLineRunner{
	
//	@Autowired
//	UserService userService;
//	
//	@Autowired
//	RoleService roleService;
//	
//	@Autowired
//	BCryptPasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(OnlineShopServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		Role role1 = new Role();
//		role1.setId(1L);
//		role1.setName("ROLE_USER");
//		
//		User user1 = new User();
//		user1.setFirstname("Mg");
//		user1.setLastname("Mg");
//		user1.setFullname("MgMg007");
//		user1.setUsername("mgmg@gmail.com");
//		user1.setPassword(passwordEncoder.encode("1234"));
//		
//		Set<UserRoles> userRoles1 = new HashSet<>();
//		userRoles1.add(new UserRoles(user1, role1));
//		
//		userService.createUser(user1, userRoles1);
//		
//		Role role2 = new Role();
//		role2.setId(2L);
//		role2.setName("ROLE_ADMIN");
//		
//		User user2 = new User();
//		user2.setFirstname("Shop");
//		user2.setLastname("Admin");
//		user2.setFullname("ShopAdmin1");
//		user2.setUsername("shopadmin1@gmail.com");
//		user2.setPassword(passwordEncoder.encode("1234"));
//		
//		Set<UserRoles> userRoles2 = new HashSet<>();
//		userRoles2.add(new UserRoles(user2, role2));
//		
//		userService.createUser(user2, userRoles2);
	}

}
