package com.empresa.hangar.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.empresa.hangar.model.Hangar;
import com.empresa.hangar.repository.HangarRepository;
import com.empresa.product.model.Product;

@Component
public class HangarDAOImp implements HangarDAO {
	
	@Autowired
	HangarRepository hangarRepository;

	@Override
	public List<Hangar> getHangars() {
		return hangarRepository.findAll();
	}
	
	@Override
	public Hangar getHangarById(Long hangarId) {
		return hangarRepository.getOne(hangarId);
	}
	
	public Hangar save(Hangar hangar) {
		return hangarRepository.save(hangar);
	}
	
	/*
	@Override
	public void addProductToHangar(Product product) {
		Hangar hangar = hangarRepository.getOne(product.getHangar().getId());
		hangarRepository.save(hangar);
	}
	*/
	
	@Override
	public Hangar getHangarById(long id) {
		return hangarRepository.findById(id).get();
	}
	
	@Override
	public Boolean existsById(long id) {
		return hangarRepository.existsById(id);
	}
	
	@Override
	public Boolean existsHangarByName(String name) {
		return hangarRepository.existsHangarByName(name);
	}

}
