package com.empresa.product_hangar.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.exception.EntityNotFoundException;
import com.empresa.product.projection.ProductSimplified;
import com.empresa.product.service.ProductService;
import com.empresa.product_hangar.dao.Product_HangarDAO;
import com.empresa.product_hangar.model.ProductOfHangar;
import com.empresa.product_hangar.model.Product_Hangar;

@Service
public class Product_HangarServiceImp implements Product_HangarService{
	
	@Autowired
	Product_HangarDAO product_HangarDAO;
	
	@Autowired
	ProductService productService;

	@Override
	public Product_Hangar save(Product_Hangar entry) {
		return product_HangarDAO.save(entry);
	}
	
	@Override
	public List<Product_Hangar> getEntriesByHangar(Long hangarId) {
		return product_HangarDAO.getEntriesByHangar(hangarId);
	}
	
	@Override
	public List<Product_Hangar> getEntriesByProduct(Long productId) {
		return product_HangarDAO.getEntriesByProduct(productId);
	}
	
	@Override
	public List<ProductSimplified> getProductsExcerpt(List<Product_Hangar> products_hangar) {
		List<ProductSimplified> productsExcerpt = products_hangar.stream()
				  .map( product -> product_HangarDAO.getSimplifiedProductById(product.getProductPk()))
				  .collect(Collectors.toList());
		return productsExcerpt;
	}

	@Override
	public Product_Hangar updateQty(ProductOfHangar updateReq) {
		
		if (!product_HangarDAO.existsByHangarpkAndProductpk(updateReq))
			throw new EntityNotFoundException(Product_Hangar.class);
		
		Product_Hangar entry = product_HangarDAO.getEntry(updateReq.getHangarpk(), updateReq.getProductpk());
		entry.setQty(updateReq.getQty());
		
		return product_HangarDAO.save(entry);		
	}
	
	

}
