package com.empresa.product_hangar.model;

import javax.validation.constraints.PositiveOrZero;

public class ProductOfHangar {
	
	@PositiveOrZero(message = "Hangar id not valid")
	private Long hangarpk;
	
	@PositiveOrZero(message = "Product id not valid")
	private Long productpk;
	
	@PositiveOrZero(message = "Quantity cannot be negative")
	private int qty;

	public Long getHangarpk() {
		return hangarpk;
	}

	public void setHangarpk(Long hangarpk) {
		this.hangarpk = hangarpk;
	}

	public Long getProductpk() {
		return productpk;
	}

	public void setProductpk(Long productpk) {
		this.productpk = productpk;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}


}
