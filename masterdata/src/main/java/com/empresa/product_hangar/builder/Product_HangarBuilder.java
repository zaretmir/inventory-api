package com.empresa.product_hangar.builder;

import com.empresa.product_hangar.model.ProductOfHangar;
import com.empresa.product_hangar.model.Product_Hangar;

public class Product_HangarBuilder {
	
	static public Product_Hangar convertToEntity(ProductOfHangar dto) {
		Product_Hangar entity = new Product_Hangar();
		
		entity.setHangarPk(dto.getHangarpk());
		entity.setProductPk(dto.getProductpk());
		entity.setQty(dto.getQty());
		
		return entity;
	}

}
