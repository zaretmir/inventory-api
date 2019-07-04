package com.empresa.hangar.dao;

import java.util.List;

import com.empresa.hangar.model.Hangar;
import com.empresa.product.model.Product;

public interface HangarDAO {
	
	List <Hangar> getHangars();
	
	Hangar getHangarById(Long hangarId);
	
	void addProductToHangar(Product product);

	Hangar createHangar(Hangar hangar);

	Hangar getHangarById(long id);

}
