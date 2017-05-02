package com.amaysim.shoppingcart.service;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.amaysim.shoppingcart.data.DataSourceUtil;
import com.amaysim.shoppingcart.domain.CartItem;
import com.amaysim.shoppingcart.domain.PricingRule;

public class ShoppingCartTest {

	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void testScenarioOne() {

		System.out.println("********** Testing Scenario One **************");
		List<PricingRule> pricingRules = new ArrayList<>(DataSourceUtil.getRules().values());
		ShoppingCart shoppingCart = new ShoppingCartImplV2(pricingRules);
		
		CartItem item1 = new CartItem();
		
		item1.setQuantity(3);
		item1.setProduct(DataSourceUtil.getProducts().get("ult_small"));
		shoppingCart.add(item1);
				
		CartItem item2 = new CartItem();
		
		item2.setQuantity(1);
		item2.setProduct(DataSourceUtil.getProducts().get("ult_large"));
		shoppingCart.add(item2);
		
		assertEquals(new BigDecimal(94.70).setScale(2, RoundingMode.FLOOR), shoppingCart.total());
		
		shoppingCart.displayTransaction();

	}

	@Test
	public void testScenarioTwo() {

		System.out.println("********** Testing Scenario Two **************");
		List<PricingRule> pricingRules = new ArrayList<>(DataSourceUtil.getRules().values());
		ShoppingCart shoppingCart = new ShoppingCartImplV2(pricingRules);
		
		CartItem item1 = new CartItem();
		
		item1.setQuantity(2);
		item1.setProduct(DataSourceUtil.getProducts().get("ult_small"));
		shoppingCart.add(item1);
				
		CartItem item2 = new CartItem();
		
		item2.setQuantity(4);
		item2.setProduct(DataSourceUtil.getProducts().get("ult_large"));
		shoppingCart.add(item2);
		
		assertEquals(new BigDecimal(209.40).setScale(2, RoundingMode.FLOOR), shoppingCart.total());
		
		shoppingCart.displayTransaction();

	}
	
	@Test
	public void testScenarioThree() {

		System.out.println("********** Testing Scenario Three **************");
		List<PricingRule> pricingRules = new ArrayList<>(DataSourceUtil.getRules().values());
		ShoppingCart shoppingCart = new ShoppingCartImplV2(pricingRules);
		
		CartItem item1 = new CartItem();
		
		item1.setQuantity(1);
		item1.setProduct(DataSourceUtil.getProducts().get("ult_small"));
		shoppingCart.add(item1);
				
		CartItem item2 = new CartItem();
		
		item2.setQuantity(2);
		item2.setProduct(DataSourceUtil.getProducts().get("ult_medium"));
		shoppingCart.add(item2);
		
		assertEquals(new BigDecimal(84.70).setScale(2, RoundingMode.FLOOR), shoppingCart.total());
		
		shoppingCart.displayTransaction();

	}
	
	@Test
	public void testScenarioFour() {

		System.out.println("********** Testing Scenario Four **************");
		List<PricingRule> pricingRules = new ArrayList<>(DataSourceUtil.getRules().values());
		ShoppingCart shoppingCart = new ShoppingCartImplV2(pricingRules);
		
		CartItem item1 = new CartItem();
		
		item1.setQuantity(1);
		item1.setProduct(DataSourceUtil.getProducts().get("ult_small"));
		shoppingCart.add(item1);
				
		CartItem item2 = new CartItem();
		
		item2.setQuantity(1);
		item2.setProduct(DataSourceUtil.getProducts().get("1gb"));
		shoppingCart.add(item2,"I<3AMAYSIM");
		
		assertEquals(new BigDecimal(31.32).setScale(2, RoundingMode.FLOOR), shoppingCart.total());
		
		shoppingCart.displayTransaction();

	}
}
