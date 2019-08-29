package com.empresa.product_hangar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.empresa.product_hangar.model.Product_Hangar;

@Repository
public interface Product_HangarRepository  extends JpaRepository<Product_Hangar, Long>{

	List<Product_Hangar> findByHangarpk(Long hangarId);
	
	@Query(value = "SELECT ph.qtyph FROM product_hangar ph WHERE ph.productpk = :id", nativeQuery = true)
	Integer findQtyphByProductpk(Long id);

}
