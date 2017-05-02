/**
 * @author Virgilio Santos Jr
 *
 * 
 */
package com.amaysim.shoppingcart.service.promotion;

import com.amaysim.shoppingcart.domain.PricingRule;

public class PromoItemCalculatorFactory {
	
	public static PromoItemCalculator getPromoItemCalculator(PricingRule pricingRule){
		
		if(pricingRule.getProductOnPromo().getProductCode().equals("ult_medium")){
			return new Unli2GBBundleCalculator();
		}
		
		return null;
	}

}
