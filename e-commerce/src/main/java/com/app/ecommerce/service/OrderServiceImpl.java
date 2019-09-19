package com.app.ecommerce.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.base.exception.ApplicationException;
import com.app.ecommerce.dao.OrderDAO;
import com.app.ecommerce.exception.OrderExceptionCause;
import com.app.ecommerce.model.Order;
import com.app.ecommerce.model.OrderItem;
import com.app.masterdata.price.service.PriceService;
import com.app.masterdata.product_hangar.model.Product_Hangar;
import com.app.masterdata.product_hangar.service.Product_HangarService;

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
		Order order = orderDAO.getOrderById(id);
		if (orderDAO.getOrderById(id) == null)
			throw new ApplicationException(OrderExceptionCause.ORDER_NOT_FOUND);
		
		return order;
	}
	
	@Override
	public List<Order> getAllOrdersByUserId(Long id) {
		return orderDAO.getOrdersByUserId(id);
	}
	
	@Override
	public Order addItem(OrderItem requestedItem) { // TODO, Refactor for atomicity /!\
		Order order = this.getOrderById(requestedItem.getOrder().getId());
		Product_Hangar itemOrigin = stockService.getStockEntry(
				requestedItem.getItemOrigin().getHangarPk(),
				requestedItem.getItemOrigin().getProductPk());
		
		requestedItem.setItemOrigin(itemOrigin);
		
		if (requestedItem.getItemOrigin().getQuantity() < requestedItem.getOrderedQuantity())
			throw new ApplicationException(OrderExceptionCause.NOT_ENOUGH_STOCK);
		
		try {
			updateExistentItem(requestedItem);
		}
		catch (ApplicationException ex) { // The product was not yet in the order
			if (OrderExceptionCause.ITEM_NOT_FOUND.getCode().equals(ex.getMessage())) { // ¡Orden evita null pointer!!!
				addItemAsNew(order, requestedItem);
			}
			else {
				throw ex; // Ver error si falla bbdd con breakpoint y editar para user
			}
		}
		
		updateStockQuantity(requestedItem.getItemOrigin(), requestedItem.getOrderedQuantity());
		updateOrderTotals(order);
		
		
		return orderDAO.saveOrder(order);
	}
	
	private void updateExistentItem(OrderItem requestedItem) {
		OrderItem item = itemService.getOrderItem(requestedItem.getOrder(), requestedItem.getItemOrigin());
		
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
		stockService.updateStockEntry(stockEntry);
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
				.mapToDouble( item -> {
					double productPrice = priceService.getLatestPrice(item.getItemOrigin()).getPrice();
					int productQty = item.getOrderedQuantity();

					return productPrice * productQty;
				})
				.sum();
		
		order.setTotalAmount(totalAmount);
		
		return order;
	}
	
}
