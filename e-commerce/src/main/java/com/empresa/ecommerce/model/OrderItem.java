package com.empresa.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "item")
@Getter @Setter
@IdClass(OrderItemId.class)
public class OrderItem {

	@Id
	@Column(name = "orderPk")
	private Long orderPk;
	
	@Id
	@Column(name = "productPk")
	private Long productPk;
	
	@Column(name = "qtyOrdered")
	private int orderedQuantity;
	
	public OrderItem() { }
	
	public OrderItem(Long orderPk, Long productPk) {
		this.orderPk = orderPk;
		this.productPk = productPk;
	}
	
	public OrderItem(Long orderPk, Long productPk, int orderedQuantity) {
		this.orderPk = orderPk;
		this.productPk = productPk;
		this.orderedQuantity = orderedQuantity;
	}
	

}
