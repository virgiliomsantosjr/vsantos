/**
 * @author Virgilio Santos Jr
 *
 * 
 */
package com.amaysim.shoppingcart.service.promotion;

import java.math.BigDecimal;

import com.amaysim.shoppingcart.domain.CartItem;
import com.amaysim.shoppingcart.domain.PricingRule;

public class Unli5GBBulkCalculator implements PromoPriceCalculator{

	/*
	 * Unli 5GB (Type Price Discount)
	 * Condition:If Unli 5GB qty more than 3
	 * Price = Discounted price * count
	 */
	public BigDecimal applyPromo(CartItem item, PricingRule pricingRule) {

		BigDecimal totalDiscount = new BigDecimal(0);
		
		if(item.getQuantity() > pricingRule.getMinimumRequiredItem()){
			BigDecimal discount = item.getProduct().getPrice().subtract(pricingRule.getDiscountedPrice());
			totalDiscount = discount.multiply(new BigDecimal(item.getQuantity()));
		}
		
		return totalDiscount;
		
	}

}
