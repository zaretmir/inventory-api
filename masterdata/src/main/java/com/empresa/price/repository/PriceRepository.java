package com.empresa.price.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.empresa.price.model.Price;
import com.empresa.product.model.Product;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long>{
	
	List<Price> findByProductOrderByDateUpdatedDesc(Product product);
	
	Price findTopByProductOrderByDateUpdatedDesc(Product product);

	void deleteByProduct(Product product);

}
