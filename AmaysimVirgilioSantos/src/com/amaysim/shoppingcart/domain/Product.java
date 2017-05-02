/**
 * @author Virgilio Santos Jr
 *
 * 
 */
package com.amaysim.shoppingcart.domain;

import java.math.BigDecimal;

public class Product {

	private String productCode;
	private String productName;
	private BigDecimal price = new BigDecimal(0);
	
	public Product(){
		
	}
	
	public Product(String productCode, String productName, BigDecimal price){
		this.productCode = productCode;
		this.productName = productName;
		this.price = price;
		
	}
	
	public String getProductCode() {
		return productCode;
	}
	
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	@Override
	public boolean equals(Object o){
		
		if(o instanceof Product){
			Product item = (Product) o;
			if(item.getProductCode().equals(this.productCode)){
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public int hashCode(){
		return this.productCode.hashCode();
	}
}
