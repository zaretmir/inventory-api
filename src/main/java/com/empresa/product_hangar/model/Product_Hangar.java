package com.empresa.product_hangar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(Product_Hangar_Id.class)
public class Product_Hangar {

	
	@Id
	private Long hangar_pk;
	
	@Id
	private Long product_pk;
	
	@Column(name="qtyph")
	private Integer qtyph;

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
	
	
	public Integer getQtyph() {
		return qtyph;
	}

	public void setQtyph(int qty) {
		this.qtyph = qty;
	}
	
	/*
	@Id
	@ManyToOne
	@JoinColumn(name="hangar_id")
	private Hangar hangar;
	
	@Id
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
	*/
	
	
	
	
	
	/*
	@Override
	public boolean equals(Object o) {
		
		if (this == o)
			return true;
		if (o == null || o.getClass() != this.getClass())
			return false;
		
		Product_Hangar product_hangar = (Product_Hangar) o;
		
		return ( product_hangar.getHangar().getId() == this.getHangar().getId() && product_hangar.getProduct().getId() == this.getProduct().getId() );
		
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getProduct().getId(), getHangar().getId());
	}
	*/
	
}
