package com.empresa.ecommerce.service;

import java.util.List;

import javax.validation.Valid;

import com.empresa.ecommerce.model.Order;
import com.empresa.ecommerce.model.OrderItem;
import com.empresa.product_hangar.model.Product_Hangar;

public interface OrderService {

	Order createOrder(@Valid Order orderReq);

	//Order addItem(Order order, Product_Hangar stockEntry, OrderItem item);
	Order addItem(Order order, OrderItem item);

	List<Order> getAllOrdersByUserId(Long id);

	Order getOrderById(Long orderId);

}
