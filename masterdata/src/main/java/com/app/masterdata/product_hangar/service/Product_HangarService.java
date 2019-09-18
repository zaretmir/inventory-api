package com.app.masterdata.product_hangar.service;

import java.util.List;

import com.app.masterdata.product_hangar.model.Product_Hangar;
import com.app.products.projection.ProductSimplified;

public interface Product_HangarService {

	Product_Hangar save(Product_Hangar entry);


	List<ProductSimplified> getProductsExcerpt(List<Product_Hangar> products_hangar);

	List<Product_Hangar> getStockByHangar(Long id);
	
	List<Product_Hangar> getStockByProduct(Long id);

	Product_Hangar updateStockEntry(Product_Hangar updateReq);

	Product_Hangar getStockEntry(Long hangarId, Long productId);


	Product_Hangar updateStockEntry(Long hangarId, Long productId, int updatedQty);

}
