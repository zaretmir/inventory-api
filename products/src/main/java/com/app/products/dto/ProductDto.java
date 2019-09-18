package com.app.products.dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductDto {
	
	private long id;
	
	@NotBlank(message = "Product name cannot be empty")
	private String name;
	
	private String description;
	
	private boolean isState;

}
