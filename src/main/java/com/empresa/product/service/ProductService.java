package com.empresa.product.service;

import java.util.List;
import java.util.Optional;

import com.empresa.product.model.Product;
import com.empresa.product.model.ProductRequest;

public interface ProductService {
	
	Product getProductById(Long productId);
	
	List<Product> getProducts();
	
	Product createProduct(ProductRequest reqProduct);
	
	Product editProduct(Long id, Product product);
	
	List<Product> listProductsUpperCase();
	
	Optional<Product> listProductsLongestName();
	
	List<Product> listProductsByFirstLetter(char letter);

	List<Product> getByHangar(Long id);
}
