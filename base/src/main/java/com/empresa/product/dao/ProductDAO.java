package com.empresa.product.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.empresa.product.model.Product;
import com.empresa.product.projection.ProductSimplified;

public interface ProductDAO {
	
	Product getProductById(Long productId);
	
	List<Product> getProductsTrueState();
	
	Boolean existsById(Long productId);
	
	Product save(Product product);

	Product delete(Product product);

	Page<Product> getActiveProductsPage(Pageable pageRequest);

	ProductSimplified getSimplifiedProduct(Long id);

	//List<Product> findByHangar(Long id);

}
