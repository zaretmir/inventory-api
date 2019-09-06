package com.empresa.ecommerce.dao;

import javax.validation.Valid;

import com.empresa.ecommerce.model.Order;

public interface OrderDAO {

	Order saveOrder(@Valid Order order);

	boolean existsById(Long id);

	Order getOrderById(Long id);

	Order updateOrder(Long id, Long productId, int qty);
	
}
