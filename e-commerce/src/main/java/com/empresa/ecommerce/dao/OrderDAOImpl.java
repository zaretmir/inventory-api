package com.empresa.ecommerce.dao;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.empresa.ecommerce.model.Order;
import com.empresa.ecommerce.model.Item;
import com.empresa.ecommerce.repository.OrderRepository;

@Component
public class OrderDAOImpl implements OrderDAO {
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	ItemDAO itemDAO;

	@Override
	public Order saveOrder(@Valid Order order) {
		
		return orderRepository.saveAndFlush(order);
	}

	@Override
	public boolean existsById(Long id) {
		return orderRepository.existsById(id);
	}

	@Override
	public Order getOrderById(Long id) {
		return orderRepository.findOneById(id);
	}

	@Override
	public Order updateOrder(Long orderId, Long productId, int qty) { // Comporbar que hay stock
		
		Order current = orderRepository.findOneById(orderId);
		
		Item productOrd = new Item();
		//productOrd.setOrderPk(orderId);
		productOrd.setProductPk(productId);
		productOrd.setQtyOrdered(qty);
		
		List<Item> items = current.getItems();
		
		items.add(productOrd);
		
		Order updated = orderRepository.saveAndFlush(current);
		
		
		return updated;
	}

}
