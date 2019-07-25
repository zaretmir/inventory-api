package com.empresa.product.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import com.empresa.hangar.model.Hangar;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_id")
	private long id;
	
	@Column
	@NotEmpty
	private String name;
	
	@Column
	private String description;
	
	@Column
	private Integer qty;
	
	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}
	
	// CONSTRUCTORS

	public Product() { }
	
	public Product(String name) {
		this.name = name;
	}
	
	public Product(Long id, String name, String description, int qty, Hangar hangar) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.qty = qty;
		// this.hangar = hangar;
	}
	
	public Product(String name, String description, int qty, Hangar hangar) {
		this.name = name;
		this.description = description;
		this.qty = qty;
		// this.hangar = hangar;
	}

	public Product(Hangar hangar, String name) {
		// this.hangar = hangar;
		this.name = name;
	}

}
