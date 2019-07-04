package com.empresa.product.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.empresa.hangar.model.Hangar;
import com.empresa.hangar.service.HangarService;
import com.empresa.product.dao.ProductDAO;
import com.empresa.product.model.Product;
import com.empresa.product.model.ProductRequest;

@Service
public class ProductServiceImp implements ProductService {
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	HangarService hangarService;

	@Override
	public Product getProductById(Long productId) {
		return productDAO.getProductById(productId);
	}

	@Override
	public List<Product> getProducts() {
		return productDAO.getProducts();
	}
	
	// Error handling
	
	@ResponseStatus(value=HttpStatus.CONFLICT)
	private class ProductConflictException extends RuntimeException {

		private static final long serialVersionUID = 4825452856252237610L;
		
		public ProductConflictException(Long id) {
			super(String.format("ProductConflictException: Product with ID %d already exists", id));
		}
		
	}	
	
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	private class ProductNotFoundException extends RuntimeException {

		private static final long serialVersionUID = 4825452856252237610L;
		
		public ProductNotFoundException(Long id) {
			super(String.format("ProductNotFoundException: Product with id %d does not exist", id));
		}
		
	}
	
	@Override
	public Product createProduct(ProductRequest product) {
		Hangar hangar = hangarService.getHangarById(product.getHangarId());
		Product toSave = new Product(hangar, product.getName());
		return productDAO.save(toSave);
	}
	
	@Override
	public Product editProduct(Long id, Product product) {
		
		if (!productDAO.existsById(id)) {
			throw new ProductNotFoundException(product.getId());
		}
		else {
		Product toUpdate = new Product(id, product.getName(), product.getHangar());
		return productDAO.save(toUpdate);
		}
	}
	
	@Override
	public List<Product> listProductsByFirstLetter(char letter) {
		// ¿Se podría hacer con el repo?
		List<Product> allProducts = productDAO.getProducts();
		
		List<Product> matches = allProducts.stream().filter( p -> p.getName().charAt(0) == letter ).collect(Collectors.toList());
		
		return matches;
	}
	
	@Override
	public List<Product> listProductsUpperCase() {
		
		List<Product> lower = productDAO.getProducts();
		
		List<Product> upper = lower.stream().map( p -> {
			Product toUpper = new Product(p.getId(), p.getName().toUpperCase(), p.getHangar());
			return toUpper;
		}).collect(Collectors.toList());
		
		return upper;
	}
	
	@Override
	public Optional<Product> listProductsLongestName() {
		List<Product> allProducts = productDAO.getProducts();
		Optional<Product> longest = allProducts.stream().max(Comparator.comparingInt( a -> a.getName().length() ));
		return longest;
	}

	@Override
	public List<Product> getByHangar(Long id) {
		List<Product> products = productDAO.findByHangar(id);
		return products;
	}
}
