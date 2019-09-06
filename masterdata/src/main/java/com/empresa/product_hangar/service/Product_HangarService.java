package com.empresa.product_hangar.service;

import java.util.List;

import javax.validation.Valid;

import com.empresa.product.projection.ProductSimplified;
import com.empresa.product_hangar.model.ProductOfHangar;
import com.empresa.product_hangar.model.Product_Hangar;

public interface Product_HangarService {

	Product_Hangar save(Product_Hangar entry);


	List<ProductSimplified> getProductsExcerpt(List<Product_Hangar> products_hangar);

	List<Product_Hangar> getEntriesByHangar(Long id);
	
	List<Product_Hangar> getEntriesByProduct(Long id);

	Product_Hangar updateQty(ProductOfHangar updateReq);

}
