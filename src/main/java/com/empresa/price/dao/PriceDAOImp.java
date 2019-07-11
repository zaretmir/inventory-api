package com.empresa.price.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.empresa.price.model.Price;
import com.empresa.price.repository.PriceRepository;
import com.empresa.product.model.Product;

@Component
public class PriceDAOImp implements PriceDAO {
	
	@Autowired
	PriceRepository priceRepository;
	
	@Override
	public Price createPriceEntry(Price price) {
		return priceRepository.save(price);
	}

	@Override
	public List<Price> getAllEntries() {
		return priceRepository.findAll();
	}

	@Override
	public List<Price> getEntriesByProduct(Product product) {
		return priceRepository.findByProductOrderByDateUpdatedDesc(product);
	}

}
