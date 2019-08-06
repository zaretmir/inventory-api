package com.empresa.product_hangar.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.empresa.product_hangar.model.Product_Hangar;
import com.empresa.product_hangar.repository.Product_HangarRepository;

@Component
public class Product_HangarDAOImp implements Product_HangarDAO {
	
	@Autowired
	Product_HangarRepository product_HangarRepository;

	@Override
	public Product_Hangar save(Product_Hangar relationship) {
		return product_HangarRepository.saveAndFlush(relationship);
	}
	
	@Override
	public List<Product_Hangar> getProductsByHangar(Long hangarID) {
		return product_HangarRepository.findByHangarpk(hangarID);
	}
	

}
