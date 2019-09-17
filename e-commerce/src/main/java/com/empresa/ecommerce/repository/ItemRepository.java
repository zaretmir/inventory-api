package com.empresa.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.empresa.ecommerce.model.OrderItem;

@Repository
public interface ItemRepository extends JpaRepository<OrderItem, Long> {
	
	OrderItem findByOrderPkAndProductPk(Long orderId, Long productId);
	

}
