package com.hostmdy.shop.payload;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OrderRequest {
	
	private String orderId;
	private String orderBy;
	private Double totalPrice;
	private Integer orderQty;
}
