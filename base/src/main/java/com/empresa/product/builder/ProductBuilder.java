package com.empresa.product.builder;

import com.empresa.product.dto.ProductDto;
import com.empresa.product.model.Product;

public class ProductBuilder {
	
	static public Product convertToEntity(ProductDto dto) {
		Product product = new Product();
		product.setName(dto.getName());
		product.setDescription(dto.getDescription());
		return product;
	}
	
	static public ProductDto convertToDto(Product product) {
		ProductDto dto = new ProductDto();
		dto.setId(product.getId());
		dto.setName(product.getName());
		dto.setDescription(product.getDescription());
		return dto;
	}

}
