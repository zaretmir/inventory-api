package com.empresa.product.model;

import com.empresa.hangar.model.Hangar;

public class ProductRequest {
	
	private String name;
	
	private String description;
	
	private int qty;
	
	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	private Long hangarId;
	
	private Hangar hangar;
	
	
	
	Hangar getHangar() {
		return hangar;
	}

	void setHangar(Hangar hangar) {
		this.hangar = hangar;
	}

	public void setHangarId(Long hangarId) {
		this.hangarId = hangarId;
	}
	
	public Long getHangarId() {
		return hangarId;
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

	public ProductRequest() { }
	
	public ProductRequest(String name) {
		this.name = name;
	}

}
