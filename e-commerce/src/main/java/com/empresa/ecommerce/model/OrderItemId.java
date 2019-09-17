package com.empresa.ecommerce.model;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@EqualsAndHashCode
public class OrderItemId implements Serializable {
	
	private static final long serialVersionUID = -4351475789696540461L;
	
	private Long productPk;
	private Long orderPk;

	public OrderItemId(Long productPk, Long orderPk) {
		super();
		this.productPk = productPk;
		this.orderPk = orderPk;
	}
	
	public OrderItemId() { }

}
