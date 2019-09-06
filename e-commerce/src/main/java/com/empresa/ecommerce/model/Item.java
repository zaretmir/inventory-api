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
@IdClass(value = Product_OrderId.class)
public class Item {
	
	/*
	@Id
	@Column(name = "item_id")
	private Long id;
	*/
	
	@Id
	@Column(name = "order_pk")
	private Long orderPk;
	
	@Id
	@Column(name = "product_pk", unique = true)
	private Long productPk;
	
	@Column(name = "qtyOrdered")
	private int qtyOrdered;
	
	
	//@ManyToOne
	//@JoinColumn(name = "order_id")
	//private Order order;

}
