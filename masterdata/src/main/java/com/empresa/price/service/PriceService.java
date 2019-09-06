package com.empresa.price.service;

import java.util.List;

import com.empresa.price.model.Price;

public interface PriceService {
	
	//Price createPriceEntry(Price price);
	
	Price createPriceEntry(Price price, Long productId);

	List<Price> getAllEntries();

	List<Price> getEntriesByProductId(Long productId);

	void deleteById(Long id);

	void deleteByProductId(Long id);

	Price getLatestEntryByProductId(Long productId);

}
