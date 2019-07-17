package com.empresa.hangar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.empresa.hangar.dao.HangarDAO;
import com.empresa.hangar.model.Hangar;
import com.empresa.product.model.Product;

@Service
public class HangarServiceImp implements HangarService {
	
	@Autowired
	HangarDAO hangarDAO;
	
	private void checkIfEmpty(List<Hangar> hangars) {
		if (hangars == null || hangars.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No hangars found");
	}
	
	private void validateMandatoryFields(Hangar hangar) { //requestHangar?
		if ( hangar != null && ( hangar.getName() == null || "".equals(hangar.getName()) ))
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A valid name is required");
		
		if ( hangar != null && (hangar.getAddress() == null || "".equals(hangar.getAddress()) ))
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A valid address is required");
	}
	
	@Override
	public List<Hangar> getHangars() {
		List<Hangar> hangars = hangarDAO.getHangars();
		
		checkIfEmpty(hangars);
		
		return hangars;
	}
	
	@Override
	public Hangar getHangarById(long id) {
		
		if (!hangarDAO.existsById(id))
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Hangar Not Found");
		
		return hangarDAO.getHangarById(id);
	}
	
	@Override
	public Hangar createHangar(Hangar hangar) {
		
		hangar.setName(hangar.getName().trim());
		
		validateMandatoryFields(hangar);
		
		if (hangarDAO.existsHangarByName(hangar.getName().trim()))
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Hangar Name must be unique, choose a different name");
		
		return hangarDAO.save(hangar);
	}
	
	/*
	@Override
	public void addProductToHangar(Product product) {
		hangarDAO.addProductToHangar(product);
	}
	*/

	@Override
	public Hangar updateHangar(Long id, Hangar update) {

		if (update.getName() == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Hangar name cannot be null");
		}
		
		if (!hangarDAO.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Hangar not found");
		}
		
		Hangar original = hangarDAO.getHangarById(id);
		original.setName(update.getName());
		
		return hangarDAO.save(original);
	}
	

}
