package com.empresa.ecommerce.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.empresa.ecommerce.model.OrderItem;
import com.empresa.ecommerce.repository.ItemRepository;

@Component
public class ItemDAOImpl implements ItemDAO {
	
	@Autowired
	ItemRepository itemRepository;
	
	@Override
	public OrderItem saveOrderItem(OrderItem item) {
		return itemRepository.saveAndFlush(item);
	}
	
	@Override 
	public OrderItem findByOrderPkAndProductPk(Long orderId, Long productId) {
		return itemRepository.findByOrderPkAndProductPk(orderId, productId);
	}
}
