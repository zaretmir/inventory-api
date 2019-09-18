package com.app.masterdata.price.builder;

import com.app.masterdata.price.dto.PriceDto;
import com.app.masterdata.price.model.Price;

public class PriceBuilder {
	
	static public PriceDto convertToDto(Price price) {
		PriceDto dto = new PriceDto();
		dto.setPrice_id(price.getPrice_id());
		dto.setPrice(price.getPrice());
		dto.setProductHangar(price.getStockEntry());
		dto.setDateUpdated(price.getDateUpdated());
		
		return dto;
	}
	
	static public Price convertToEntity(PriceDto dto) {
		Price price = new Price();
		price.setPrice_id(dto.getPrice_id());
		price.setPrice(dto.getPrice());
		price.setStockEntry(dto.getProductHangar());
		price.setDateUpdated(dto.getDateUpdated());
		
		return price;
	}

}
