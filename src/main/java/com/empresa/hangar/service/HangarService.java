package com.empresa.hangar.service;

import java.util.List;

import com.empresa.hangar.model.Hangar;
import com.empresa.hangar.model.HangarRequest;
import com.empresa.product.model.Product;
//test
//test2
public interface HangarService {
	
	List<Hangar> getHangars();
	
	//Hangar getHangarById();
	
	Boolean validFieldsById(Hangar hangar);
	
	void addProductToHangar(Product product);

	Hangar createHangar(HangarRequest hangarRequest);

	Hangar getHangarById(long id);


}
