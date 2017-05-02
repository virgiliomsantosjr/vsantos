/**
 * @author Virgilio Santos Jr
 *
 * 
 */
package com.amaysim.shoppingcart.service.promotion;

import com.amaysim.shoppingcart.domain.PricingRule;

public class PromoPriceCalculatorFacotory {

	
	public static PromoPriceCalculator getPromoCalculator(PricingRule pricingRule){
		
		if(pricingRule.getProductOnPromo().getProductCode().equals("ult_small")){
			return new ThreeForTwoCalculator();
		}else if(pricingRule.getProductOnPromo().getProductCode().equals("ult_large")){
			return new Unli5GBBulkCalculator();
		}
		
		return null;
	}
}
