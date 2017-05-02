/**
 * @author Virgilio Santos Jr
 *
 * 
 */
package com.amaysim.shoppingcart.service.promotion;

import java.math.BigDecimal;

import com.amaysim.shoppingcart.domain.CartItem;
import com.amaysim.shoppingcart.domain.PricingRule;

public class ThreeForTwoCalculator implements PromoPriceCalculator {


	/*
	 * 3for2 Unli 1GB(Type Price discount)
	 * Condition:Atleast qty is 3 Unlimitted 1GB
	 * Price = 2 * origprice + ((Total count mod 2) * orig price))
	 * 
	 * @return 
	 * Price discount
	 */
	public BigDecimal applyPromo(CartItem item, PricingRule pricingRule) {
		
		BigDecimal priceDiscount = new BigDecimal(0);
		int minItem = pricingRule.getMinimumRequiredItem();
		int discountedItems = 0;
		
		if(item.getQuantity() >= minItem){
			discountedItems = (item.getQuantity() - (item.getQuantity() % minItem)) / minItem;
			priceDiscount = item.getProduct().getPrice().multiply(new BigDecimal(discountedItems));
		}

		return priceDiscount;
	}

}
