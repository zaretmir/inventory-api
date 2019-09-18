package com.app.masterdata.price.dao;

import java.util.List;

import com.app.masterdata.price.model.Price;
import com.app.masterdata.product_hangar.model.Product_Hangar;

public interface PriceDAO {

	Price createPriceEntry(Price price);

	List<Price> getAllEntries();

	List<Price> getPriceHistory(Product_Hangar stockEntry);

	void deleteById(Long id);

	void deleteByProductHangar(Product_Hangar stockEntry);

	Price getLatestPrice(Product_Hangar stockEntry);

}
