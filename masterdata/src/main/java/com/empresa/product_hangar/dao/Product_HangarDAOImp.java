package com.empresa.product_hangar.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Component;

import com.empresa.product.dao.ProductDAO;
import com.empresa.product.projection.ProductSimplified;
import com.empresa.product_hangar.builder.Product_HangarBuilder;
import com.empresa.product_hangar.model.ProductOfHangar;
import com.empresa.product_hangar.model.Product_Hangar;
import com.empresa.product_hangar.repository.Product_HangarRepository;

@Component
public class Product_HangarDAOImp implements Product_HangarDAO {
	
	@Autowired
	Product_HangarRepository product_HangarRepository;
	
	@Autowired
	ProductDAO productDAO;

	@Override
	public Product_Hangar save(Product_Hangar relationship) {
		return product_HangarRepository.saveAndFlush(relationship);
	}
	
	@Override
	public List<Product_Hangar> getEntriesByProduct(Long productId) {
		return product_HangarRepository.findByProductPk(productId);
	}

	@Override
	public List<Product_Hangar> getEntriesByHangar(Long hangarId) {
		return product_HangarRepository.findByHangarPk(hangarId);
	}
	
	@Override
	public ProductSimplified getSimplifiedProductById(Long id) {
		return productDAO.getSimplifiedProductById(id);
	}
	
	@Override
	public Product_Hangar getEntry(Long hangarId, Long productId) {
		return product_HangarRepository.findByHangarPkAndProductPk(hangarId, productId);
	}

	@Override
	public boolean existsByHangarpkAndProductpk(ProductOfHangar updateReq) {
		Product_Hangar entry = Product_HangarBuilder.convertToEntity(updateReq);	
		
		ExampleMatcher matcher = ExampleMatcher.matching().withIgnorePaths("qty");			
		Example<Product_Hangar> example = Example.of(entry, matcher); 
		
		return product_HangarRepository.exists(example);
	}
	

}
