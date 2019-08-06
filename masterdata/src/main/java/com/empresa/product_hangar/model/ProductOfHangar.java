package com.empresa.product_hangar.model;

public class ProductOfHangar {
	
	private Long hangarpk;
	private Long productpk;
	
	private int qtyph;

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

	public int getQtyph() {
		return qtyph;
	}

	public void setQtyph(int qtyph) {
		this.qtyph = qtyph;
	}


}
