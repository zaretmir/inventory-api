package com.empresa.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.empresa.ecommerce.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
	
	Item findByProductPk(Long id);
	

}
