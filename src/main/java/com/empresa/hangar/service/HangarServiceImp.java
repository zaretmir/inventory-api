package com.empresa.hangar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.hangar.dao.HangarDAO;
import com.empresa.hangar.model.Hangar;
import com.empresa.hangar.model.HangarRequest;
import com.empresa.product.model.Product;

@Service
public class HangarServiceImp implements HangarService {
	
	@Autowired
	HangarDAO hangarDAO;
	
	@Override
	public List<Hangar> getHangars() {
		List<Hangar> hangares = hangarDAO.getHangars();
		return hangares;
	}
	
	@Override
	public Hangar getHangarById(long id) {
		return hangarDAO.getHangarById(id);
	}
	
	@Override
	public Hangar createHangar(HangarRequest reqHangar) {
		Hangar hangar = new Hangar(reqHangar.getName(), reqHangar.getAddress());
		return hangarDAO.createHangar(hangar);
	}
	
	@Override
	public Boolean validFieldsById(Hangar hangar) {
		/*
		Hangar refHangar = hangarDAO.getHangarById(hangar.getId());
		if ( !refHangar.equals(hangar) ) {
			return false;
		}
		*/
		return true;
	}
	
	@Override
	public void addProductToHangar(Product product) {
		hangarDAO.addProductToHangar(product);
	}
	

}
