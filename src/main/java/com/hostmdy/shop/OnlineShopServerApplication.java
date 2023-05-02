package com.hostmdy.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hostmdy.shop.domain.User;
import com.hostmdy.shop.service.UserService;

@SpringBootApplication
public class OnlineShopServerApplication implements CommandLineRunner{
	
	@Autowired
	UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(OnlineShopServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		User user1 = new User();
		user1.setFirstname("Mg");
		user1.setLastname("Mg");
		user1.setFullname("MgMg007");
		user1.setUsername("mgmg@gmail.com");
		user1.setPassword("1234");
		
		userService.saveUser(user1);
	}

}
