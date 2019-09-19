package com.app.masterdata.product_hangar.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.base.exception.ApplicationException;
import com.app.masterdata.product_hangar.dao.Product_HangarDAO;
import com.app.masterdata.product_hangar.exception.StockExceptionCause;
import com.app.masterdata.product_hangar.model.Product_Hangar;
import com.app.masterdata.product_hangar.projection.StockLatestPrice;
import com.app.masterdata.product_hangar.repository.Product_HangarRepository;
import com.app.products.projection.ProductSimplified;
import com.app.products.service.ProductService;

@Service
public class Product_HangarServiceImp implements Product_HangarService{
	
	@Autowired
	Product_HangarDAO product_HangarDAO;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	Product_HangarRepository stockRepository;

	@Override
	public Product_Hangar save(Product_Hangar entry) {
		return product_HangarDAO.save(entry);
	}
	
	@Override
	public List<Product_Hangar> getStockByHangar(Long hangarId) {
		List<Product_Hangar> entries = product_HangarDAO.getStockByHangar(hangarId);
		if (entries == null || entries.isEmpty())
			throw new ApplicationException(StockExceptionCause.NOT_FOUND);
		
		return product_HangarDAO.getStockByHangar(hangarId);
	}
	
	@Override
	public List<Product_Hangar> getStockByProduct(Long productId) {
		return product_HangarDAO.getStockByProduct(productId);
	}
	
	@Override
	public Product_Hangar getStockEntry(Long hangarId, Long productId) {
		Product_Hangar stockEntry = product_HangarDAO.getStock(hangarId, productId);
		if (stockEntry == null)
			throw new ApplicationException(StockExceptionCause.NOT_FOUND);
		return stockEntry;
	}
	
	@Override
	public List<ProductSimplified> getProductsExcerpt(List<Product_Hangar> products_hangar) {
		List<ProductSimplified> productsExcerpt = products_hangar.stream()
				  .map( product -> product_HangarDAO.getSimplifiedProductById(product.getProductPk()))
				  .collect(Collectors.toList());
		
		if (productsExcerpt == null || productsExcerpt.isEmpty())
			throw new ApplicationException(StockExceptionCause.NOT_FOUND);
		
		return productsExcerpt;
	}
	
	@Override
	public List<StockLatestPrice> getStockEntriesProjected(Long productId) { //Only returns StockLatestsPrice(s) which prices has been set
		List<StockLatestPrice> stockEntries = product_HangarDAO.getStockProjectedByProduct(productId);
		List<StockLatestPrice> stockEntriesWithPrice = stockEntries.stream()
				.filter(entry -> entry.getLatestPrice() != null)
				.collect(Collectors.toList());
		
		if (stockEntriesWithPrice == null || stockEntriesWithPrice.isEmpty())
			throw new ApplicationException(StockExceptionCause.NOT_FOUND_VALID);
		
		return stockEntriesWithPrice;
	}

	@Override
	public Product_Hangar updateStockEntry(Product_Hangar updateReq) { // Quantity is the only modifiable attribute
		Product_Hangar entry = product_HangarDAO.getStock(updateReq.getHangarPk(), updateReq.getProductPk());
		entry.setQuantity(updateReq.getQuantity());
		
		return product_HangarDAO.save(entry);		
	}
	
	@Override
	public Product_Hangar updateStockEntry(Long hangarId, Long productId, int updatedQty) {
		Product_Hangar entry = product_HangarDAO.getStock(hangarId, productId);
		entry.setQuantity(updatedQty);
		
		return product_HangarDAO.save(entry);		
	}
	
	
	

}
