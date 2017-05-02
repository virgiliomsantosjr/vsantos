/**
 * @author Virgilio Santos Jr
 *
 * 
 */
package com.amaysim.shoppingcart.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import com.amaysim.shoppingcart.domain.CartItem;
import com.amaysim.shoppingcart.domain.Product;

public interface ShoppingCart {

	void add(CartItem item);
	void add(CartItem item, String promoCode);
	BigDecimal total();
	List<CartItem> getItems();
	void displayTransaction();
	
}
