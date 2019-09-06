package com.empresa.ecommerce.builder;

import com.empresa.ecommerce.dto.OrderDto;
import com.empresa.ecommerce.model.Order;

public class OrderBuilder {
	
	static public OrderDto convertToDto(Order order) {
		OrderDto dto = new OrderDto();
		
		dto.setUser(order.getUser());
		dto.setDate(order.getDate());
		dto.setItems(order.getItems());
		dto.setTotalItems(order.getTotalItems());
		dto.setTotalAmount(order.getTotalAmount());
		
		return dto;		
	}
	
	static public Order convertToEntity(OrderDto dto) {
		Order entity = new Order();
		
		entity.setUser(dto.getUser());
		entity.setDate(dto.getDate());
		entity.setItems(dto.getItems());
		entity.setTotalItems(dto.getTotalItems());
		entity.setTotalAmount(dto.getTotalAmount());
		
		return entity;		
	}

}
