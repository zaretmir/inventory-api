package com.empresa.price.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.empresa.exception.EntityNotFoundException;
import com.empresa.price.dao.PriceDAO;
import com.empresa.price.model.Price;
import com.empresa.product.model.Product;
import com.empresa.product.service.ProductService;

@Service
public class PriceServiceImp implements PriceService {
	
	@Autowired
	PriceDAO priceDAO;
	
	@Autowired
	ProductService productService;
	
	private void checkIfEmpty(List<Price> entries) {
		if (entries == null || entries.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No price entries found");
	}
	
	//FIX TRY CATCH
	
	@Override
	public Price createPriceEntry(Price price, Long productId) {
		
		if (price.getPrice() < 0)
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Price not valid");

		// El productService ya valida el producto
		Product product;
		try {
			product = productService.getProductById(productId);
			price.setProduct(product);
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Date date = new Date();
		price.setDateUpdated(date.getTime());
		
		return priceDAO.createPriceEntry(price);
	}
	
	@Override
	public List<Price> getAllEntries() {
		List<Price> entries = priceDAO.getAllEntries();
		checkIfEmpty(entries);
		
		return entries;
	}
	
	// FIX TRY CATCH
	@Override
	public List<Price> getEntriesByProductId(Long productId) {
		Product product;
		try {
			product = productService.getProductById(productId);
			List<Price> entries = priceDAO.getEntriesByProduct(product);
			checkIfEmpty(entries);
			return entries;
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	
		return null;
		
	}
	
	@Override
	public Price getLatestEntryByProductId(Long productId) {
		Product product;
		try {
			product = productService.getProductById(productId);
			Price entry = priceDAO.getLatestEntry(product);
			//checkIfEmpty(entries);
			return entry;
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	
		return null;
		
	}

	@Override
	public void deleteById(Long id) {
		priceDAO.deleteById(id);
	}
	
	@Override
	public void deleteByProductId(Long id) {
		priceDAO.deleteByProductId(id);
	}

}
