/**
 * @author Virgilio Santos Jr
 *
 * 
 */
package com.amaysim.shoppingcart.domain;

public class PromoCode {

	String code;
	double discountPercentage;
	String description;
	
	public PromoCode(String code, double discountPercentage, String description) {
		super();
		this.code = code;
		this.discountPercentage = discountPercentage;
		this.description = description;
	}
	
	public PromoCode(){
		super();
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public double getDiscountPercentage() {
		return discountPercentage;
	}
	public void setDiscountPercentage(double discountPercentage) {
		this.discountPercentage = discountPercentage;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
