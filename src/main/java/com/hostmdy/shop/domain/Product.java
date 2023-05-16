package com.hostmdy.shop.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Title is required")
	private String title;
	
	@NotBlank(message = "Description is required")
	@Lob
	private String description;
	
	@NotBlank(message = "Brand is required")
	private String brand;
	
	@NotNull(message = "ListPrice is required")
	private Double listPrice;
	
	@NotNull(message = "OurPrice is required")
	private Double ourPrice;
	
	@NotNull(message = "InStockNumber is required")
	private Integer inStockNumber;
	
	private String imageName;
	
	private String category;
	
	@NotBlank(message = "Availability is required")
	@Enumerated(EnumType.STRING)
	private Availability availability;
	
	@Lob
	@NotBlank(message = "Specifications is required")
	private String specifications;
	
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	@OneToMany(mappedBy = "product")
	@JsonIgnore
	private List<ProductToCartItem> productToCartItem = new ArrayList<>();
	
	@PrePersist
	public void onCreate() {
		this.createdAt = LocalDateTime.now();
	}
	
	@PreUpdate
	public void onUpdate() {
		this.updatedAt = LocalDateTime.now();
	}
	
}
