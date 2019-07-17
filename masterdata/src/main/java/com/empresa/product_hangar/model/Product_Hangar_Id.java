package com.empresa.product_hangar.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

//@Embeddable
public class Product_Hangar_Id implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6267293444346995566L;

	private Long hangar_pk;
	
	private Long product_pk;
	
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


	public Product_Hangar_Id(Long hangar_pk, Long product_pk) {
		this.hangar_pk = hangar_pk;
		this.product_pk = product_pk;
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
		
		return (product_hangar.getHangar_pk() == this.hangar_pk && product_hangar.getProduct_pk() == this.product_pk);
		
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getProduct_pk(), getHangar_pk());
	}

}
