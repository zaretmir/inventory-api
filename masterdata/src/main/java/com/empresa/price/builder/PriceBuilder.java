package com.empresa.price.builder;

import com.empresa.price.dto.PriceDto;
import com.empresa.price.model.Price;

public class PriceBuilder {
	
	static public PriceDto convertToDto(Price price) {
		PriceDto dto = new PriceDto();
		dto.setPrice_id(price.getPrice_id());
		dto.setPrice(price.getPrice());
		dto.setProduct(price.getProduct());
		dto.setDateUpdated(price.getDateUpdated());
		
		return dto;
	}
	
	static public Price convertToEntity(PriceDto dto) {
		Price price = new Price();
		price.setPrice_id(dto.getPrice_id());
		price.setPrice(dto.getPrice());
		price.setProduct(dto.getProduct());
		price.setDateUpdated(dto.getDateUpdated());
		
		return price;
	}

}
