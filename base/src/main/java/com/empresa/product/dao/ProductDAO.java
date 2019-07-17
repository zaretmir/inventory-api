package com.empresa.product.dao;

import java.util.List;

import com.empresa.product.model.Product;

public interface ProductDAO {
	
	Product getProductById(Long productId);
	
	List<Product> getProducts();
	
	Boolean existsById(Long productId);
	
	Product save(Product product);

	//List<Product> findByHangar(Long id);

}
