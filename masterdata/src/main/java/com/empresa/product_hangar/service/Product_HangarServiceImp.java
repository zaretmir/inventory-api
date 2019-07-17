package com.empresa.product_hangar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.product_hangar.dao.Product_HangarDAO;
import com.empresa.product_hangar.model.Product_Hangar;

@Service
public class Product_HangarServiceImp implements Product_HangarService{
	
	@Autowired
	Product_HangarDAO product_HangarDAO;

	@Override
	public Product_Hangar save(Product_Hangar relationship) {
		return product_HangarDAO.save(relationship);
	}

}
