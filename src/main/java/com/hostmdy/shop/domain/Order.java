package com.hostmdy.shop.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_order")
@Getter @Setter @NoArgsConstructor
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDateTime orderDate;
	private LocalDateTime shippingDate;
	private String shippingMethod;
	private String orderStatus;
	private BigDecimal orderTotal;
	
	@OneToMany(mappedBy = "order", cascade=CascadeType.ALL )
	private List<CartItem> cartItemList = new ArrayList<>();
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "shipping_address_id")
	private ShippingAddress shippingAddress;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "payment_id")
	private Payment payment;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;


}
