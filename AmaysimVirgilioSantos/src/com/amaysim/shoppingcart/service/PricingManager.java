package com.amaysim.shoppingcart.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.amaysim.shoppingcart.domain.CartItem;
import com.amaysim.shoppingcart.domain.PricingRule;
import com.amaysim.shoppingcart.domain.Product;
import com.amaysim.shoppingcart.domain.PromoCode;

public interface PricingManager {

	void setPricingRules(List<PricingRule> pricingRules);
	BigDecimal getTotalPriceDiscount(List<CartItem> regularItems);
	BigDecimal getActualTotalPrice(List<CartItem> regularItems);
	List<CartItem> getPromotionalItems(List<CartItem> item);
	BigDecimal getPromoCodeDiscount(Map<String, PromoCode> promoCodes, BigDecimal totalAmount);
	
}
