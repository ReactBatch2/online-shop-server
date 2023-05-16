package com.hostmdy.shop.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hostmdy.shop.domain.Product;
import com.hostmdy.shop.service.ProductService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
	
	private final ProductService productService;
	
	@PostMapping("/create")
	public ResponseEntity<?> createProduct(@Valid @RequestBody Product product){
		Product savedProduct = productService.save(product);
		
		return new ResponseEntity<Product>(savedProduct,HttpStatus.CREATED);
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<?> findProductById(@PathVariable Long id){
		Optional<Product> productOpt = productService.findById(id);
		
		if(productOpt.isEmpty())
			return new ResponseEntity<String>("product not found",HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Product>(productOpt.get(),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteProductById(@PathVariable Long id) {
		
		productService.delete(id);
		
		return new ResponseEntity<String>("deleted",HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllProduct(){
		List<Product> productList = productService.findAll();
		
		if(productList.isEmpty())
			return new ResponseEntity<String>("no product found",HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<List<Product>>(productList,HttpStatus.OK);
	}
	
	

}
