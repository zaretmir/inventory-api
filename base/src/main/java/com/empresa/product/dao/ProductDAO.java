package com.empresa.product.dao;

import java.util.List;

import com.empresa.product.model.Product;

public interface ProductDAO {
	
	Product getProductById(Long productId);
	
	List<Product> getProductsTrueState();
	
	Boolean existsById(Long productId);
	
	Product save(Product product);

	Product delete(Product product);

	//List<Product> findByHangar(Long id);

}
