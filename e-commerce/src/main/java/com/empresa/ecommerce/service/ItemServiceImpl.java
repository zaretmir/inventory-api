package com.empresa.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.ecommerce.dao.ItemDAO;
import com.empresa.ecommerce.dao.OrderDAO;
import com.empresa.ecommerce.model.Order;
import com.empresa.ecommerce.model.OrderItem;
import com.empresa.exception.EntityNotFoundException;
import com.empresa.product.dao.ProductDAO;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	ItemDAO itemDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	OrderDAO orderDAO;
	
	@Override
	public OrderItem saveOrderItem(OrderItem item) {
		if (!orderDAO.existsById(item.getOrderPk()))
			throw new EntityNotFoundException(Order.class);
		
		return itemDAO.saveOrderItem(item);
	}
	
	@Override
	public OrderItem getOrderItem(Long orderId, Long productId) {
		OrderItem item = itemDAO.findByOrderPkAndProductPk(orderId, productId);
		if (item == null)
			throw new EntityNotFoundException(OrderItem.class);
		return item;
	}
	
	@Override
	public OrderItem updateOrderItem(OrderItem updatedItem) {
		OrderItem item = itemDAO.findByOrderPkAndProductPk(updatedItem.getOrderPk(), updatedItem.getProductPk());
		
		if (item == null)
			throw new EntityNotFoundException(OrderItem.class);
		item.setOrderedQuantity(updatedItem.getOrderedQuantity());
		
		return itemDAO.saveOrderItem(item);
	}

}
