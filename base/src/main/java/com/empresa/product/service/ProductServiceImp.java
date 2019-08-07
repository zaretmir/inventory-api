package com.empresa.product.service;

import java.beans.FeatureDescriptor;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
	
	/*
	 * Returns string array containing the property names of not-null properties of a product
	 */
	public String[] getNullPropertyNames(Product product) {
		
		final BeanWrapper wrappedProduct = new BeanWrapperImpl(product);
		
		return Stream.of(wrappedProduct.getPropertyDescriptors())
				.map(FeatureDescriptor::getName)
				.filter(propertyName -> wrappedProduct.getPropertyValue(propertyName) == null)
				.toArray(String[]::new);
		
	}

	@Override
	public Product getProductById(Long productId) {
		
		if (!productDAO.existsById(productId))
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product Not Found");
		
		return productDAO.getProductById(productId);
		
	}

	@Override
	public List<Product> getProducts() {
		
		return productDAO.getProductsTrueState();
		
	}
	
	@Override
	public Product createProduct(Product product) {
		
		validateMandatoryFields(product);
		
		// Hangar Service comprueba la existencia del hangar
		//Hangar hangar = hangarService.getHangarById(product.getHangar().getId());
		//product.setHangar(hangar);
		
		return productDAO.save(product);
		
	}
	
	@Override
	public Product editProduct(Long id, Product update) {
		
		if (!productDAO.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product Not Found: invalid product ID");
		}
		else {
			Product original = productDAO.getProductById(id);
			
			String[] nullPropertyNames = getNullPropertyNames(update);
			BeanUtils.copyProperties(update, original, nullPropertyNames);
			//https://stackoverflow.com/questions/45904389/spring-boot-how-to-edit-entity.
			
			return productDAO.save(original);
		}
		
	}
	
	@Override
	public List<Product> listProductsByFirstLetter(char letter) {
		// ¿Se podría hacer con el repo?
		List<Product> allProducts = productDAO.getProductsTrueState();
		
		List<Product> matches = allProducts.stream().filter( p -> p.getName().charAt(0) == letter ).collect(Collectors.toList());
		
		return matches;
	}
	
	@Override
	public List<Product> listProductsUpperCase() {
		
		List<Product> lower = productDAO.getProductsTrueState();
		
		List<Product> upper = lower.stream().map( p -> {
			p.setName(p.getName().toUpperCase());
			return p;
		}).collect(Collectors.toList());
		
		return upper;
	}
	
	@Override
	public Optional<Product> listProductsLongestName() {
		List<Product> allProducts = productDAO.getProductsTrueState();
		Optional<Product> longest = allProducts.stream().max(Comparator.comparingInt( a -> a.getName().length() ));
		return longest;
	}

	@Override
	public Product deleteProduct(Long id) {
		Product product = productDAO.getProductById(id);
		return productDAO.delete(product);
	}

	@Override
	public Page<Product> getActiveProductsPage(Pageable pageRequest) {
		return productDAO.getActiveProductsPage(pageRequest);
	}
	
	/*
	@Override
	public List<Product> getByHangar(Long id) {
		List<Product> products = productDAO.findByHangar(id);
		return products;
	}
	*/

}
