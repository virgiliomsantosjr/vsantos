/**
 * @author Virgilio Santos Jr
 *
 * 
 */
package com.amaysim.shoppingcart.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amaysim.shoppingcart.data.DataSourceUtil;
import com.amaysim.shoppingcart.domain.CartItem;
import com.amaysim.shoppingcart.domain.PricingRule;
import com.amaysim.shoppingcart.domain.PromoCode;

public class ShoppingCartImplV2 implements ShoppingCart {

	private List<CartItem> regularItems = new ArrayList<>(); 
	private Map<String, PromoCode> promoCodes = new HashMap<>();
	
	private PricingManager pricingManager = null;
	
	public ShoppingCartImplV2(){
		super();
	}
	
	public ShoppingCartImplV2(List<PricingRule> pricingRules){
		
		super();
		pricingManager = new DefaultPricingManager();
		pricingManager.setPricingRules(pricingRules);
		
	}
	
	public void add(CartItem item) {
		
		for(CartItem c: regularItems){
			if(c.getProduct().equals(item.getProduct())){
				c.setQuantity(c.getQuantity() + item.getQuantity());
				return;
			}
			
		}
		
		regularItems.add(item);
				
	}

	public void add(CartItem item, String promoCode) {

		this.add(item);
		if(DataSourceUtil.getPromoCodes().containsKey(promoCode)){
			promoCodes.put(promoCode, DataSourceUtil.getPromoCodes().get(promoCode));
		}
		
	}

	public BigDecimal total() {
		
		BigDecimal actualPrice = pricingManager.getActualTotalPrice(regularItems);
		BigDecimal priceRuleDiscount = pricingManager.getTotalPriceDiscount(regularItems);
		BigDecimal totalPrice = actualPrice.subtract(priceRuleDiscount);
		BigDecimal promoDiscount = pricingManager.getPromoCodeDiscount(promoCodes, totalPrice);
	
		return totalPrice.subtract(promoDiscount).setScale(2, RoundingMode.CEILING);
		
	}


	public List<CartItem> getItems() {

		List<CartItem> promotionalItems = pricingManager.getPromotionalItems(regularItems);
		List<CartItem> allItems = new ArrayList<>();
		
		allItems.addAll(regularItems);
		allItems.addAll(promotionalItems);
		
		return allItems;
	}

	public void displayTransaction() {

		System.out.println("Items Added: ");
		
		for(CartItem item: regularItems){
			System.out.println(item.getQuantity() + " x " + item.getProduct().getProductName());
		}
		
		for(PromoCode promoCode: promoCodes.values()){
			System.out.println("'" +promoCode.getCode() + "' Promo Applied");
		}
		
		System.out.println("\nExpected Cart Items: ");
		for(CartItem item: getItems()){
			System.out.println(item.getQuantity() + " x " + item.getProduct().getProductName());
		}
		
		System.out.println("\nExpected Cart Total Price: " + total());
		
	}

}
