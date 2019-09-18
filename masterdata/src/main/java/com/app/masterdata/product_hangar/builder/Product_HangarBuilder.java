package com.app.masterdata.product_hangar.builder;

import com.app.masterdata.product_hangar.model.Product_Hangar;
import com.app.masterdata.product_hangar.model.Product_HangarDto;

public class Product_HangarBuilder {
	
	static public Product_Hangar convertToEntity(Product_HangarDto dto) {
		Product_Hangar entity = new Product_Hangar();
		
		entity.setHangarPk(dto.getHangarpk());
		entity.setProductPk(dto.getProductpk());
		entity.setQuantity(dto.getQuantity());
		
		return entity;
	}

}
