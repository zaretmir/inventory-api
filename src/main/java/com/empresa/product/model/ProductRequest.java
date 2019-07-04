package com.empresa.product.model;

import com.empresa.hangar.model.Hangar;

public class ProductRequest {
	
	private String name;
	
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
	
	// CONSTRUCTORS
	
	public ProductRequest() { }
	
	public ProductRequest(String name) {
		this.name = name;
	}

}
