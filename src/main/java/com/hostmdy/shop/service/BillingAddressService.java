package com.hostmdy.shop.service;

import com.hostmdy.shop.domain.BillingAddress;
import com.hostmdy.shop.domain.UserBilling;

public interface BillingAddressService {
	BillingAddress setByUserBilling(UserBilling userBilling, BillingAddress billingAddress);
}
