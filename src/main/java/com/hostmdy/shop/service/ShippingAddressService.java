package com.hostmdy.shop.service;

import com.hostmdy.shop.domain.ShippingAddress;
import com.hostmdy.shop.domain.UserShipping;

public interface ShippingAddressService {
	ShippingAddress setByUserShipping(UserShipping userShipping, ShippingAddress shippingAddress);
}
