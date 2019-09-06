package com.empresa.hangar.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.empresa.hangar.model.Hangar;
//test
//test2
public interface HangarService {
	
	List<Hangar> getHangars();
	
	// void addProductToHangar(Product product);

	Hangar createHangar(@Valid Hangar hangar);

	Hangar getHangarById(long id);

	Hangar updateHangar(Long id, Hangar update);

	Hangar logicDeleteHangar(Long id);

	List<Hangar> getHangarsStateTrue();

	Page<Hangar> getActiveHangarsPage(Pageable pageRequest);

	List<Hangar> getProductsMatchingSearch(String term);


}
