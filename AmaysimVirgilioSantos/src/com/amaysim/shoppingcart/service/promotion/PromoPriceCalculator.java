/**
 * @author Virgilio Santos Jr
 *
 * 
 */

package com.amaysim.shoppingcart.service.promotion;

import java.math.BigDecimal;

import com.amaysim.shoppingcart.domain.CartItem;
import com.amaysim.shoppingcart.domain.PricingRule;

public interface PromoPriceCalculator {

	BigDecimal applyPromo(CartItem item, PricingRule pricingRule);
	
}
