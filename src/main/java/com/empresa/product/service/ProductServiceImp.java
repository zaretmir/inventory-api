package com.empresa.product.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.empresa.hangar.model.Hangar;
import com.empresa.hangar.service.HangarService;
import com.empresa.product.dao.ProductDAO;
import com.empresa.product.model.Product;

@Service
public class ProductServiceImp implements ProductService {
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	HangarService hangarService;
	
	public void validateMandatoryFields(Product product) {
		if ( product != null && (product.getName() == null || "".equals(product.getName()) ))
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid field: name");
	}

	@Override
	public Product getProductById(Long productId) {
		
		if (!productDAO.existsById(productId))
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product Not Found");
		
		return productDAO.getProductById(productId);
		
	}

	@Override
	public List<Product> getProducts() {
		
		return productDAO.getProducts();
		
	}
	
	@Override
	public Product createProduct(Product product) {
		
		validateMandatoryFields(product);
		
		//Hangar Service comprueba la existencia del hangar
		Hangar hangar = hangarService.getHangarById(product.getHangar().getId());
		product.setHangar(hangar);
		
		return productDAO.save(product);
	}
	
	@Override
	public Product editProduct(Long id, Product product) {
		
		if (!productDAO.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product Not Found: invalid product ID");
		}
		else {
		Product toUpdate = new Product(id, product.getName(), product.getDescription(), product.getQty(), product.getHangar());
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
			p.setName(p.getName().toUpperCase());
			return p;
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
