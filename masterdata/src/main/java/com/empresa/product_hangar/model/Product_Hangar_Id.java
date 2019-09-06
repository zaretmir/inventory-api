package com.empresa.product_hangar.model;

import java.io.Serializable;
import java.util.Objects;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Product_Hangar_Id implements Serializable {
	
	private static final long serialVersionUID = -6267293444346995566L;

	private Long hangarPk;
	
	private Long productPk;

	public Product_Hangar_Id(Long hangarpk, Long productpk) {
		this.hangarPk = hangarpk;
		this.productPk = productpk;
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
		
		return (product_hangar.getHangarPk() == this.hangarPk && product_hangar.getProductPk() == this.productPk);
		
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getProductPk(), getHangarPk());
	}

}
