package com.empresa.product_hangar.model;

public class ProductOfHangar {
	
	private Long hangar_pk;
	private Long product_pk;
	
	private int qtyph;

	public Long getHangar_pk() {
		return hangar_pk;
	}

	public void setHangar_pk(Long hangar_pk) {
		this.hangar_pk = hangar_pk;
	}

	public Long getProduct_pk() {
		return product_pk;
	}

	public void setProduct_pk(Long product_pk) {
		this.product_pk = product_pk;
	}

	public int getQtyph() {
		return qtyph;
	}

	public void setQtyph(int qty) {
		this.qtyph = qty;
	}

}
