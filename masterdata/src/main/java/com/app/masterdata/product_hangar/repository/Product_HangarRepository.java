package com.app.masterdata.product_hangar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.masterdata.product_hangar.model.Product_Hangar;

@Repository
public interface Product_HangarRepository  extends JpaRepository<Product_Hangar, Long>{

	List<Product_Hangar> findByHangarPk(Long hangarId);
	
	List<Product_Hangar> findByProductPk(Long productId);
	
	@Query(value = "SELECT ph.qty FROM product_hangar ph WHERE ph.productpk = :id", nativeQuery = true)
	Integer findQtyphByProductPk(Long id);

	Product_Hangar findByHangarPkAndProductPk(Long hangarId, Long productId);	

}
