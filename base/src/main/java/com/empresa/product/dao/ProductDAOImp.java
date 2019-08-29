package com.empresa.product.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.empresa.hangar.dao.HangarDAO;
import com.empresa.hangar.repository.HangarRepository;
import com.empresa.product.model.Product;
import com.empresa.product.projection.ProductSimplified;
import com.empresa.product.repository.ProductRepository;

@Component
public class ProductDAOImp implements ProductDAO {
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	HangarRepository hangarRepository;
	
	@Autowired
	HangarDAO hangarDAO;

	@Override
	public Product getProductById(Long productId) {
		return productRepository.findById(productId).get();
	}
	
	@Override
	public List<Product> getProductsTrueState() {
		return productRepository.findByIsStateTrue();
		//return productRepository.findAll();
	}
	
	@Override
	public Boolean existsById(Long productId) {
		return productRepository.existsById(productId);
	}
	
	@Override
	public Product save(Product product) {
		//hangarDAO.addProductToHangar(product);
		return productRepository.save(product);
	}
	
	@Override
	public Product delete(Product product) {
		product.setIsState(false);
		return productRepository.save(product);
	}
	/*

	@Override
	public List<Product> findByHangar(Long id) {
		Hangar hangar = hangarRepository.findById(id).get();
		return productRepository.findByHangar(hangar);
	}
	*/

	@Override
	public Page<Product> getActiveProductsPage(Pageable pageRequest) {
		return productRepository.findByIsStateTrue(pageRequest);
	}
	
	@Override
	public ProductSimplified getSimplifiedProduct(Long id) {
		ProductSimplified simpl = productRepository.findProductByIdProjectedForLimitedData(id);
		return simpl;
	}

	@Override
	public List<Product> getProductsMatchingSearch(String search) {
		return productRepository.findByIsStateTrueAndNameContaining(search);
	}
	
	

}
