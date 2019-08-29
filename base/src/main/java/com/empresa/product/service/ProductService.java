package com.empresa.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.empresa.product.model.Product;
import com.empresa.product.projection.ProductSimplified;

public interface ProductService {
	
	Product getProductById(Long productId);
	
	List<Product> getProducts();
	
	Product editProduct(Long id, Product product);
	
	List<Product> listProductsUpperCase();
	
	Optional<Product> listProductsLongestName();
	
	List<Product> listProductsByFirstLetter(char letter);

	//List<Product> getByHangar(Long id);

	Product createProduct(Product product);

	Product deleteProduct(Long id);

	Page<Product> getActiveProductsPage(Pageable pageRequest);

	ProductSimplified getSimplifiedProductById(Long id);

	List<Product> getProductsMatchingSearch(String search);
}
