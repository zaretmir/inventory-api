package com.empresa.hangar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.empresa.exception.EntityNotFoundException;
import com.empresa.exception.EntityNotUniqueException;
import com.empresa.hangar.dao.HangarDAO;
import com.empresa.hangar.model.Hangar;

@Service
public class HangarServiceImp implements HangarService {
	
	@Autowired
	HangarDAO hangarDAO;
	
	private void checkIfEmpty(List<Hangar> hangars) {
		if (hangars == null || hangars.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No hangars found");
	}
	
	/*
	private void validateMandatoryFields(Hangar hangar) { //requestHangar?
		if ( hangar != null && ( hangar.getName() == null || "".equals(hangar.getName()) ))
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A valid name is required");
		
		if ( hangar != null && (hangar.getAddress() == null || "".equals(hangar.getAddress()) ))
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A valid address is required");
	}
	*/
	
	@Override
	public List<Hangar> getHangars() {
		List<Hangar> hangars = hangarDAO.getHangars();
		
		if (hangars == null || hangars.isEmpty()) // Revisar esto
			throw new EntityNotFoundException(Hangar.class, true);
		
		return hangars;
	}
	
	@Override
	public List<Hangar> getHangarsStateTrue() {
		List<Hangar> hangars = hangarDAO.getHangarsStateTrue();
		
		checkIfEmpty(hangars);
		
		return hangars;
	}
	
	@Override
	public Hangar getHangarById(long id) {
		
		if (!hangarDAO.existsById(id))
			throw new EntityNotFoundException(Hangar.class);
		
		return hangarDAO.getHangarById(id);
	}
	
	@Override
	public Hangar createHangar(Hangar hangar) {
		
		String formattedName = hangar.getName().trim();
		hangar.setName(formattedName);
		
		if (hangarDAO.existsHangarByName(formattedName))
			throw new EntityNotUniqueException(hangar);
		
		/*
		if (hangarDAO.existsHangarByName(hangar.getName().trim()))
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Hangar Name must be unique, choose a different name");
		*/
		
		
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
		
		if (!hangarDAO.existsById(id))
			throw new EntityNotFoundException(Hangar.class);
		
		Hangar original = hangarDAO.getHangarById(id);
		original.setName(update.getName());
		original.setAddress(update.getAddress());
		original.setOwner(update.getOwner());
		original.setOwnerEmail(update.getOwnerEmail());
		original.setPhoneNumber(update.getPhoneNumber());
		
		return hangarDAO.save(original);
	}

	@Override
	public Hangar logicDeleteHangar(Long id) {
		
		if (!hangarDAO.existsById(id))
			throw new EntityNotFoundException(Hangar.class);
		
		Hangar hangar = hangarDAO.getHangarById(id);
		hangar.setIsState(false);
		
		return hangarDAO.save(hangar);
	}

	@Override
	public Page<Hangar> getActiveHangarsPage(Pageable pageRequest) {
		return hangarDAO.getActiveHangarsPage(pageRequest);
	}

	@Override
	public List<Hangar> getProductsMatchingSearch(String search) {
		return hangarDAO.getProductsMatchingSearch(search);
	}
	

}
