/**
 * @author Virgilio Santos Jr
 *
 * 
 */
package com.amaysim.shoppingcart.domain;

import java.math.BigDecimal;

public class PricingRule {

	public PricingRule(){
		super();
	}
	
	public PricingRule(String promoId, PromoType promoType, String descriptiion, int minimumRequiredItem,
			Product productOnPromo, BigDecimal discountedPrice) {
		super();
		this.promoId = promoId;
		this.promoType = promoType;
		this.descriptiion = descriptiion;
		this.minimumRequiredItem = minimumRequiredItem;
		this.productOnPromo = productOnPromo;
		this.discountedPrice = discountedPrice;
		
	}

	String promoId;
	PromoType promoType;
	String descriptiion;
	int minimumRequiredItem;
	Product productOnPromo;
	BigDecimal discountedPrice = new BigDecimal(0);
	
	public String getPromoId() { 
		return promoId;
	}
	
	public void setPromoId(String promoId) {
		this.promoId = promoId;
	}
	
	public PromoType getPromoType() {
		return promoType;
	}
	
	public void setPromoType(PromoType promoType) {
		this.promoType = promoType;
	}
	
	public String getDescriptiion() {
		return descriptiion;
	}
	
	public void setDescriptiion(String descriptiion) {
		this.descriptiion = descriptiion;
	}
	
	public int getMinimumRequiredItem() {
		return minimumRequiredItem;
	}
	
	public void setMinimumRequiredItem(int minimumRequiredItem) {
		this.minimumRequiredItem = minimumRequiredItem;
	}
	
	public Product getProductOnPromo() {
		return productOnPromo;
	}
	
	public void setProductOnPromo(Product productOnPromo) {
		this.productOnPromo = productOnPromo;
	}

	public BigDecimal getDiscountedPrice() {
		return discountedPrice;
	}

	public void setDiscountedPrice(BigDecimal discountedPrice) {
		this.discountedPrice = discountedPrice;
	}
	
}
