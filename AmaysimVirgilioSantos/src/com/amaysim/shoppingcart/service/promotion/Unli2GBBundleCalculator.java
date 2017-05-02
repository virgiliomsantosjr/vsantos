/**
 * @author Virgilio Santos Jr
 *
 * 
 */
package com.amaysim.shoppingcart.service.promotion;

import java.util.ArrayList;
import java.util.List;

import com.amaysim.shoppingcart.data.DataSourceUtil;
import com.amaysim.shoppingcart.domain.CartItem;
import com.amaysim.shoppingcart.domain.PricingRule;

public class Unli2GBBundleCalculator implements PromoItemCalculator{

	/*
	 * 
	 * 1GB free for each 2GB unli (Type New Item)
	 * Condition:If 2GB unli qty >=1
	 * Items = 2gb qty * 1 GB DataPack
	 */
	public CartItem applyPromo(CartItem item, PricingRule pricingRule) {

		CartItem cartItem = new CartItem();
		
		if(item.getQuantity() > 0){
			cartItem.setProduct(DataSourceUtil.getProducts().get("1gb"));
			cartItem.setQuantity(item.getQuantity());
		}
		
		return cartItem;
	}

}
