package com.empresa.ecommerce.model;

import java.io.Serializable;

import com.empresa.product_hangar.model.Product_Hangar_Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@EqualsAndHashCode
public class OrderItemId implements Serializable {
	
	private static final long serialVersionUID = -4351475789696540461L;
	
	private Long orderPk;
	private Product_Hangar_Id itemOrigin;

	public OrderItemId(Product_Hangar_Id itemOrigin, Long orderPk) {
		super();
		this.itemOrigin = itemOrigin;
		this.orderPk = orderPk;
	}
	
	public OrderItemId() { }

}
