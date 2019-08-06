package com.empresa.product_hangar.model;

import java.io.Serializable;
import java.util.Objects;

//@Embeddable
public class Product_Hangar_Id implements Serializable {
	
	private static final long serialVersionUID = -6267293444346995566L;

	private Long hangarpk;
	
	private Long productpk;
	
	public Long getHangarPk() {
		return hangarpk;
	}


	public void setHangarPk(Long hangarpk) {
		this.hangarpk = hangarpk;
	}


	public Long getProductPk() {
		return productpk;
	}


	public void setProductpk(Long productpk) {
		this.productpk = productpk;
	}


	public Product_Hangar_Id(Long hangarpk, Long productpk) {
		this.hangarpk = hangarpk;
		this.productpk = productpk;
	}	
	
	public Product_Hangar_Id() {
	}


	@Override
	public boolean equals(Object o) {
		
		if (this == o)
			return true;
		if (o == null || o.getClass() != this.getClass())
			return false;
		
		Product_Hangar product_hangar = (Product_Hangar) o;
		
		return (product_hangar.getHangarpk() == this.hangarpk && product_hangar.getProductpk() == this.productpk);
		
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getProductPk(), getHangarPk());
	}

}
