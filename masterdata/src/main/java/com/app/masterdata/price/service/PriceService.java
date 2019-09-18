package com.app.masterdata.price.service;

import java.util.List;

import com.app.masterdata.price.model.Price;
import com.app.masterdata.product_hangar.model.Product_Hangar;

public interface PriceService {
	
	List<Price> getPriceHistory(Product_Hangar stockEntry);

	void deleteById(Long id);

	void deleteByStockEntry(Product_Hangar stockEntry);

	Price createPriceEntry(Price price);

	Price getLatestPrice(Product_Hangar stockEntry);

}
