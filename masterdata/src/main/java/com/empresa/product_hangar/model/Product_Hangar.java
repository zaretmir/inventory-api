package com.empresa.product_hangar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(Product_Hangar_Id.class)
@Table(name="product_hangar")
public class Product_Hangar {

	
	@Id
	@Column(name="hangarpk")
	private Long hangarpk;
	
	@Id
	@Column(name="productpk")
	private Long productpk;
	
	@Column(name="qtyph")
	private Integer qtyph;

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

	public Integer getQtyph() {
		return qtyph;
	}

	public void setQtyph(Integer qtyph) {
		this.qtyph = qtyph;
	}

	
}
