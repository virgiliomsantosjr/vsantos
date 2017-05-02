/**
 * @author Virgilio Santos Jr
 *
 * 
 */
package com.amaysim.shoppingcart.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.amaysim.shoppingcart.domain.CartItem;
import com.amaysim.shoppingcart.domain.PricingRule;
import com.amaysim.shoppingcart.domain.Product;
import com.amaysim.shoppingcart.domain.PromoCode;
import com.amaysim.shoppingcart.domain.PromoType;
import com.amaysim.shoppingcart.service.promotion.PromoItemCalculator;
import com.amaysim.shoppingcart.service.promotion.PromoItemCalculatorFactory;
import com.amaysim.shoppingcart.service.promotion.PromoPriceCalculator;
import com.amaysim.shoppingcart.service.promotion.PromoPriceCalculatorFacotory;

public class DefaultPricingManager implements PricingManager {

	List<PricingRule> pricingRules = null;
	
	public void setPricingRules(List<PricingRule> pricingRules) {

		this.pricingRules = pricingRules;
		
	}

	public BigDecimal getTotalPriceDiscount(List<CartItem> regularItems) {

		BigDecimal totalPriceDiscount = new BigDecimal(0);
		
		for(CartItem item: regularItems){
			PricingRule rule = getPricingRule(item);
			if(rule !=null){
				
				if(rule.getPromoType().equals(PromoType.PRICE_DISCOUNT)){
					PromoPriceCalculator priceCalculator = PromoPriceCalculatorFacotory.getPromoCalculator(rule);
					totalPriceDiscount = totalPriceDiscount.add(priceCalculator.applyPromo(item, rule));
				}

			}
		}
		
		return totalPriceDiscount;
	}

	public List<CartItem> getPromotionalItems(List<CartItem> regularItems) {

		
		List<CartItem> promoItems = new ArrayList<CartItem>();
		
		for(CartItem item: regularItems){
			
			PricingRule rule = getPricingRule(item);
			
			if(rule !=null){
				
				if(rule.getPromoType().equals(PromoType.FREE_ITEM)){
					
					PromoItemCalculator itemCalculator = PromoItemCalculatorFactory.getPromoItemCalculator(rule);
					CartItem cartItem = itemCalculator.applyPromo(item, rule);
			
					if(promoItems.size() > 0){
						for(CartItem c: promoItems){
							if(c.getProduct().equals(cartItem.getProduct())){
								c.setQuantity(c.getQuantity() + item.getQuantity());
							}else{
								promoItems.add(itemCalculator.applyPromo(item, rule));
							}
						}
					}else{
						promoItems.add(itemCalculator.applyPromo(item, rule));
					}

				}

				
			}
		}
		
		return promoItems;
	}

	private PricingRule getPricingRule(CartItem item){

		if(pricingRules !=null){
			for(PricingRule rule: pricingRules){
				if (rule.getProductOnPromo().equals(item.getProduct())){
					return rule;
				}
			}
		}
		
		return null;
	}

	public BigDecimal getActualTotalPrice(List<CartItem> regularItems) {
		
		BigDecimal actualTotalPrice = new BigDecimal(0);
		
		for(CartItem item: regularItems){
			actualTotalPrice = actualTotalPrice.add(item.getProduct().getPrice().multiply(new BigDecimal(item.getQuantity())));
		}
		
		return actualTotalPrice;
		
	}


	public BigDecimal getPromoCodeDiscount(Map<String, PromoCode> promoCodes, BigDecimal totalAmount) {

		Double promoCodeDiscount = 0.00d;
		BigDecimal discount = new BigDecimal(0);
		
		for(PromoCode promoCode: promoCodes.values()){
			promoCodeDiscount += promoCode.getDiscountPercentage();
		}
		
		discount  = totalAmount.multiply(new BigDecimal(promoCodeDiscount/100));
		
		return discount;
	}
}
