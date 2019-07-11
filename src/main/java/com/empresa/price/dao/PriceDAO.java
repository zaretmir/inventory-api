package com.empresa.price.dao;

import java.util.List;

import com.empresa.price.model.Price;
import com.empresa.product.model.Product;

public interface PriceDAO {

	Price createPriceEntry(Price price);

	List<Price> getAllEntries();

	List<Price> getEntriesByProduct(Product product);

}
