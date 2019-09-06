package com.empresa.product_hangar.dao;

import java.util.List;

import com.empresa.product.projection.ProductSimplified;
import com.empresa.product_hangar.model.ProductOfHangar;
import com.empresa.product_hangar.model.Product_Hangar;

public interface Product_HangarDAO {

	Product_Hangar save(Product_Hangar relationship);

	ProductSimplified getSimplifiedProductById(Long id);

	List<Product_Hangar> getEntriesByProduct(Long productId);

	List<Product_Hangar> getEntriesByHangar(Long hangarId);

	Product_Hangar getEntry(Long hangarId, Long productId);

	boolean existsByHangarpkAndProductpk(ProductOfHangar updateReq);

}
