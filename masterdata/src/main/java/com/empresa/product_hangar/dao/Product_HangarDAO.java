package com.empresa.product_hangar.dao;

import java.util.List;

import com.empresa.product.projection.ProductSimplified;
import com.empresa.product_hangar.model.Product_Hangar;

public interface Product_HangarDAO {

	Product_Hangar save(Product_Hangar relationship);

	List<Product_Hangar> getProductsByHangar(Long hangarID);

	ProductSimplified getSimplifiedProductById(Long id);

}
