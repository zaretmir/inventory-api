package com.empresa.hangar.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.empresa.hangar.model.Hangar;

public interface HangarDAO {
	
	List <Hangar> getHangars();
	
	Hangar getHangarById(Long hangarId);
	
	// void addProductToHangar(Product product);

	Hangar getHangarById(long id);
	
	Boolean existsById(long id);

	Boolean existsHangarByName(String name);

	Hangar save(Hangar hangar);

	List<Hangar> getHangarsStateTrue();

	Page<Hangar> getActiveHangarsPage(Pageable pageRequest);

}
