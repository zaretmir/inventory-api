package com.empresa.product.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.empresa.hangar.dao.HangarDAO;
import com.empresa.hangar.model.Hangar;
import com.empresa.hangar.repository.HangarRepository;
import com.empresa.product.model.Product;
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
	public List<Product> getProducts() {
		return productRepository.findAll();
	}
	
	@Override
	public Boolean existsById(Long productId) {
		return productRepository.existsById(productId);
	}
	
	@Override
	public Product save(Product product) {
		hangarDAO.addProductToHangar(product);
		return productRepository.save(product);
	}

	@Override
	public List<Product> findByHangar(Long id) {
		Hangar hangar = hangarRepository.findById(id).get();
		return productRepository.findByHangar(hangar);
	}

}
