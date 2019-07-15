package com.empresa.price.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.empresa.price.model.Price;
import com.empresa.price.repository.PriceRepository;
import com.empresa.product.dao.ProductDAO;
import com.empresa.product.model.Product;

@Component
public class PriceDAOImp implements PriceDAO {
	
	@Autowired
	PriceRepository priceRepository;
	
	@Autowired
	ProductDAO productDAO;
	
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

	@Override
	public void deleteById(Long priceId) {
		priceRepository.deleteById(priceId);
	}
	
	@Override
	@Transactional
	public void deleteByProductId(Long productId) {
		priceRepository.deleteByProduct(productDAO.getProductById(productId));
	}

}
