package com.app.masterdata.price.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.masterdata.price.model.Price;
import com.app.masterdata.product_hangar.model.Product_Hangar;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long>{
	
	List<Price> findByStockEntryOrderByDateUpdatedDesc(Product_Hangar stockEntry);
	
	Price findTopByStockEntryOrderByDateUpdatedDesc(Product_Hangar stockEntry);
	
	void deleteByStockEntry(Product_Hangar stockEntry);
}
