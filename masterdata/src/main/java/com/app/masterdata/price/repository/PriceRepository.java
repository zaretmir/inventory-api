package com.app.masterdata.price.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.masterdata.price.model.Price;
import com.app.masterdata.product_hangar.model.Product_Hangar;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long>{
	
	//List<Price> findByProductOrderByDateUpdatedDesc(Product product);
	List<Price> findByProductHangarOrderByDateUpdatedDesc(Product_Hangar productHangar);
	
	//Price findTopByProductOrderByDateUpdatedDesc(Product product);
	Price findTopByProductHangarOrderByDateUpdatedDesc(Product_Hangar productHangar);
	
	//void deleteByProduct(Product product);
	void deleteByProductHangar(Product_Hangar productHangar);

}
