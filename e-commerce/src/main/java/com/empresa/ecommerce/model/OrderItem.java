package com.empresa.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.empresa.product_hangar.model.Product_Hangar;

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
	@ManyToOne
	private Product_Hangar itemOrigin;
	
	@Column(name = "qtyOrdered")
	private int orderedQuantity;
	
	public OrderItem() { }
	
	public OrderItem(Long orderPk, Product_Hangar itemOrigin) {
		this.orderPk = orderPk;
		this.itemOrigin = itemOrigin;
	}
	
	public OrderItem(Long orderPk, Product_Hangar itemOrigin, int orderedQuantity) {
		this.orderPk = orderPk;
		this.itemOrigin = itemOrigin;
		this.orderedQuantity = orderedQuantity;
	}
	

}
