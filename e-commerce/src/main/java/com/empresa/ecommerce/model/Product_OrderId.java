package com.empresa.ecommerce.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Product_OrderId implements Serializable {

	private static final long serialVersionUID = 8541536548330578946L;
	
	private Long productPk;
	
	private Long orderPk;

	public Product_OrderId(Long productPk, Long orderPk) {
		super();
		this.productPk = productPk;
		this.orderPk = orderPk;
	}
	
	public Product_OrderId() { }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderPk == null) ? 0 : orderPk.hashCode());
		result = prime * result + ((productPk == null) ? 0 : productPk.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product_OrderId other = (Product_OrderId) obj;
		if (orderPk == null) {
			if (other.orderPk != null)
				return false;
		} else if (!orderPk.equals(other.orderPk))
			return false;
		if (productPk == null) {
			if (other.productPk != null)
				return false;
		} else if (!productPk.equals(other.productPk))
			return false;
		return true;
	}
	
	
	
	

}
