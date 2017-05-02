/**
 * @author Virgilio Santos Jr
 *
 * 
 */
package com.amaysim.shoppingcart.data;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.amaysim.shoppingcart.domain.PricingRule;
import com.amaysim.shoppingcart.domain.Product;
import com.amaysim.shoppingcart.domain.PromoCode;
import com.amaysim.shoppingcart.domain.PromoType;

public class DataSourceUtil {
	
	private static Map<String, Product> products = new HashMap<>();
	private static Map<String, PricingRule> rules = new HashMap<>();
	private static Map<String, PromoCode> promoCodes = new HashMap<>();
	
	static{
		
		Product product1 = new Product("ult_small", "Unlimited 1GB", new BigDecimal(24.90));
		Product product2 = new Product("ult_medium", "Unlimited 2GB", new BigDecimal(29.90));
		Product product3 = new Product("ult_large", "Unlimited 5GB", new BigDecimal(44.90));
		Product product4 = new Product("1gb", "1 GB Data-pack", new BigDecimal(9.90));
		
		products.put("ult_small", product1);
		products.put("ult_medium", product2);
		products.put("ult_large", product3);
		products.put("1gb", product4);
	
		
		rules.put("1", new PricingRule("1", PromoType.PRICE_DISCOUNT, "A 3 for 2 deal on Unlimited 1GB Sims.", 3, product1, new BigDecimal(0)));
		rules.put("2", new PricingRule("2", PromoType.PRICE_DISCOUNT, "The Unlimited 5GB Sim will have a bulk discount applied", 3, product3, new BigDecimal(39.90)));
		rules.put("3", new PricingRule("3", PromoType.FREE_ITEM, "We will bundle in a free 1 GB Data-pack free-of-charge with every Unlimited 2GB sold", 1, product2, new BigDecimal(0)));
				
		promoCodes.put("I<3AMAYSIM", new PromoCode("I<3AMAYSIM",10.00d, "Aapply a 10% discount across the board"));
	}

	public static  Map<String, Product> getProducts(){
		return products;
	}
	
	public static  Map<String, PricingRule> getRules(){
		return rules;
		
	}
	
	public static Map<String, PromoCode> getPromoCodes(){
		return promoCodes;
	}
}