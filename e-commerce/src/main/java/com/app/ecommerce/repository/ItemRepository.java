package com.app.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.ecommerce.model.Order;
import com.app.ecommerce.model.OrderItem;
import com.app.masterdata.product_hangar.model.Product_Hangar;

@Repository
public interface ItemRepository extends JpaRepository<OrderItem, Long> {
	
	//OrderItem findByOrderPkAndProductPk(Long orderId, Long productId);
	
	OrderItem findByOrderAndItemOrigin(Order order, Product_Hangar itemOrigin);
	

}
