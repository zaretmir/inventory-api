package com.empresa.hangar.service;

import java.util.List;

import javax.validation.Valid;

import com.empresa.hangar.model.Hangar;
import com.empresa.product.model.Product;
//test
//test2
public interface HangarService {
	
	List<Hangar> getHangars();
	
	// void addProductToHangar(Product product);

	Hangar createHangar(@Valid Hangar hangar);

	Hangar getHangarById(long id);

	Hangar updateHangar(Long id, Hangar update);


}
