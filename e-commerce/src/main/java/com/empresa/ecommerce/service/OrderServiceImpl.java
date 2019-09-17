package com.empresa.ecommerce.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.ecommerce.dao.OrderDAO;
import com.empresa.ecommerce.model.Order;
import com.empresa.ecommerce.model.OrderItem;
import com.empresa.exception.ApplicationException;
import com.empresa.exception.ApplicationExceptionCause;
import com.empresa.exception.EntityNotFoundException;
import com.empresa.price.service.PriceService;
import com.empresa.product_hangar.model.Product_Hangar;
import com.empresa.product_hangar.service.Product_HangarService;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderDAO orderDAO;
	
	@Autowired
	Product_HangarService stockService;
	
	@Autowired
	ItemService itemService;
	
	@Autowired
	PriceService priceService;

	@Override
	public Order createOrder(@Valid Order orderReq) {
		return orderDAO.saveOrder(orderReq);
	}
	
	
	@Override
	public Order getOrderById(Long id) {
		if (!orderDAO.existsById(id))
			throw new EntityNotFoundException(Order.class);
		
		return this.updateOrderTotals(orderDAO.getOrderById(id));
	}
	
	@Override
	public List<Order> getAllOrdersByUserId(Long id) {
		return orderDAO.getOrdersByUserId(id);
	}
	
	@Override
	public Order addItem(Order order, OrderItem requestedItem) {
		if (requestedItem.getItemOrigin().getQuantity() < requestedItem.getOrderedQuantity())
			throw new ApplicationException(ApplicationExceptionCause.NO_STOCK);
		
		try {
			updateExistentItem(requestedItem);			
		}
		catch (EntityNotFoundException ex) { // The product was not yet in the order
			addItemAsNew(order, requestedItem);
		}		
		
		updateStockQuantity(requestedItem.getItemOrigin(), requestedItem.getOrderedQuantity());
		updateOrderTotals(order);
		
		return orderDAO.saveOrder(order);
	}
	
	private void updateExistentItem(OrderItem requestedItem) {
		//OrderItem item = itemService.getOrderItem(requestedItem.getOrderPk(), requestedItem.getProductPk());
		OrderItem item = itemService.getOrderItem(requestedItem.getOrderPk(), requestedItem.getItemOrigin());
		
		int newQuantity = item.getOrderedQuantity() + requestedItem.getOrderedQuantity();
		item.setOrderedQuantity(newQuantity);
		itemService.updateOrderItem(item);
	}
	
	private void addItemAsNew(Order order, OrderItem requestedItem) {
		OrderItem savedItem = itemService.saveOrderItem(requestedItem);
		order.getOrderItems().add(savedItem);
	}
	
	private void updateStockQuantity(Product_Hangar stockEntry, int quantityRequested) {
		int quantityRemaining =  stockEntry.getQuantity() - quantityRequested;
		stockEntry.setQuantity(quantityRemaining);
		stockService.updateEntry(stockEntry);
	}
	
	private Order updateOrderTotals(Order order) {
		order = updateTotalItems(order);
		order = updateTotalAmount(order);		
		
		return orderDAO.saveOrder(order);
	}
	
	private Order updateTotalItems(Order order) {
		int totalItems = order.getOrderItems().stream()
				.mapToInt( product -> product.getOrderedQuantity() )
				.sum();
		
		order.setTotalItems(totalItems);
		
		return order;
	}
	
	private Order updateTotalAmount(Order order) {
		double totalAmount = order.getOrderItems().stream()
				.mapToDouble( product -> {
					Long productId = product.getItemOrigin().getProductPk();
					double productPrice = priceService.getLatestEntryByProductId(productId).getPrice();
					int productQty = product.getOrderedQuantity();

					return productPrice * productQty;
				})
				.sum();
		
		order.setTotalAmount(totalAmount);
		
		return order;
	}
	
}
