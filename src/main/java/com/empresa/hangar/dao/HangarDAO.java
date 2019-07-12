package com.empresa.hangar.dao;

import java.util.List;

import com.empresa.hangar.model.Hangar;
import com.empresa.product.model.Product;

public interface HangarDAO {
	
	List <Hangar> getHangars();
	
	Hangar getHangarById(Long hangarId);
	
	void addProductToHangar(Product product);

	Hangar getHangarById(long id);
	
	Boolean existsById(long id);

	Boolean existsHangarByName(String name);

	Hangar save(Hangar hangar);

}
