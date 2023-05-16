package com.hostmdy.shop.resource;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.hostmdy.shop.domain.CartItem;
import com.hostmdy.shop.domain.Product;
import com.hostmdy.shop.domain.ShoppingCart;
import com.hostmdy.shop.domain.User;
import com.hostmdy.shop.service.CartItemService;
import com.hostmdy.shop.service.ProductService;
import com.hostmdy.shop.service.ShoppingCartService;
import com.hostmdy.shop.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/shoppingcart")
@RequiredArgsConstructor
public class ShoppingCartController {
	
	private final UserService userService;
	private final ShoppingCartService shoppingCartService;
	private final CartItemService cartItemService;
	private final ProductService productService;
	
	@GetMapping("/cart")
	public ResponseEntity<?> shoppingCart(Principal principal){
		Optional<User> userOpt = userService.findByUsername(principal.getName());
		
		if(userOpt.isEmpty()) {
			return new ResponseEntity<String>("Access denied",HttpStatus.FORBIDDEN);
		}
		
		ShoppingCart shoppingCart = userOpt.get().getShoppingCart();
		ShoppingCart updatedShoppingCart = shoppingCartService.updateShoppingCart(shoppingCart);
		List<CartItem> cartItemList = updatedShoppingCart.getCartItemList();
		
		return new ResponseEntity<List<CartItem>>(cartItemList,HttpStatus.OK);
	}
	
	@PostMapping("/addProduct/{id}/{qty}")
	public ResponseEntity<?> addToCart(@PathVariable Long id,@PathVariable Integer qty,Principal principal){
		Optional<User> userOpt = userService.findByUsername(principal.getName());
		
		if(userOpt.isEmpty()) {
			return new ResponseEntity<String>("access denied",HttpStatus.FORBIDDEN);
		}
		
		Optional<Product> productOpt = productService.findById(id);
		
		if(productOpt.isEmpty()) {
			return new ResponseEntity<String>("product not found",HttpStatus.NOT_FOUND);
		}
		
		Product product = productOpt.get();
		
		if(qty > product.getInStockNumber()) {
			return new ResponseEntity<String>("noenoughstock",HttpStatus.CONFLICT);
		}
		
		CartItem cartItem = cartItemService.addProductToCartItem(product,userOpt.get(),qty);
		return new ResponseEntity<String>("added to cart", HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}/{qty}")
	public ResponseEntity<?> updateCartItem(@PathVariable Long id,@PathVariable Integer qty,Principal principal){
		Optional<User> userOpt = userService.findByUsername(principal.getName());
		
		if(userOpt.isEmpty()) {
			return new ResponseEntity<String>("access denied",HttpStatus.FORBIDDEN);
		}
		
		Optional<CartItem> cartItemOpt = cartItemService.findById(id);
		
		if(cartItemOpt.isEmpty()) {
			return new ResponseEntity<String>("cartitem not found",HttpStatus.NOT_FOUND);
		}
		
		CartItem cartItem = cartItemOpt.get();
		cartItem.setQty(qty);
		
		CartItem updatedCartItem = cartItemService.updateCartItem(cartItem);
		
		return new ResponseEntity<CartItem>(updatedCartItem,HttpStatus.OK);
	}
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<?> removeCartItem(@PathVariable Long id,Principal principal){
		Optional<User> userOpt = userService.findByUsername(principal.getName());
		
		if(userOpt.isEmpty()) {
			return new ResponseEntity<String>("access denied",HttpStatus.FORBIDDEN);
		}
		
		Optional<CartItem> cartItemOpt = cartItemService.findById(id);
		
		if(cartItemOpt.isEmpty()) {
			return new ResponseEntity<String>("cartitem not found",HttpStatus.NOT_FOUND);
		}
		
		cartItemService.removeCartItem(cartItemOpt.get());
		
		return new ResponseEntity<CartItem>(cartItemOpt.get(),HttpStatus.OK);
	}

}
