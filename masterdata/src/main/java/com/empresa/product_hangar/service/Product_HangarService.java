package com.empresa.product_hangar.service;

import java.util.List;

import com.empresa.product_hangar.model.Product_Hangar;

public interface Product_HangarService {

	Product_Hangar save(Product_Hangar relationship);

	List<Product_Hangar> getProductsByHangar(Long hangarId);

}
