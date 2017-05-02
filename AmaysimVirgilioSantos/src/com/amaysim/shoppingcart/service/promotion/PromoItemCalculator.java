/**
 * @author Virgilio Santos Jr
 *
 * 
 */
package com.amaysim.shoppingcart.service.promotion;

import java.util.List;

import com.amaysim.shoppingcart.domain.CartItem;
import com.amaysim.shoppingcart.domain.PricingRule;
import com.amaysim.shoppingcart.domain.Product;

public interface PromoItemCalculator {

	CartItem applyPromo(CartItem item, PricingRule pricingRule);
}
