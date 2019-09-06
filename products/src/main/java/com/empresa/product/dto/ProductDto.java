package com.empresa.product.dto;

import javax.validation.constraints.NotBlank;

public class ProductDto {
	
	private long id;
	
	@NotBlank(message = "Product name cannot be empty")
	private String name;
	
	private String description;
	
	private boolean isState;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
	
	public boolean getIsState() {
		return isState;
	}
	
	public void setIsState(boolean state) {
		this.isState = state;
	}

}
