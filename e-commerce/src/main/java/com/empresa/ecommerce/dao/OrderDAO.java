package com.empresa.ecommerce.dao;

import java.util.List;

import javax.validation.Valid;

import com.empresa.ecommerce.model.Order;

public interface OrderDAO {

	Order saveOrder(@Valid Order order);

	boolean existsById(Long id);

	Order getOrderById(Long id);

	List<Order> getOrdersByUserId(Long id);
	
}
