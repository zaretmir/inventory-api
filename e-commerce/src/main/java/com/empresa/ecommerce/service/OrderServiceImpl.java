package com.empresa.ecommerce.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.ecommerce.dao.OrderDAO;
import com.empresa.ecommerce.model.Item;
import com.empresa.ecommerce.model.Order;
import com.empresa.exception.EntityNotFoundException;
import com.empresa.price.service.PriceService;
import com.empresa.product.dao.ProductDAO;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderDAO orderDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	ItemService ItemService;
	
	@Autowired
	PriceService priceService;

	@Override
	public Order createOrder(@Valid Order orderReq) {	
		
		
		if (false) // exception
			throw new EntityNotFoundException(Order.class);
		
		return orderDAO.saveOrder(orderReq);
	}
	
	@Override
	public Order retrieveOrderById(Long id) {
		
		if (!orderDAO.existsById(id))
			throw new EntityNotFoundException(Order.class);
		
		return this.updateOrderData(orderDAO.getOrderById(id));
	}

	@Override
	public Order addItem(Long orderId, Long productId, int qty) {

		if (!orderDAO.existsById(orderId))
			throw new EntityNotFoundException(Order.class);
		
		
		if (false) // Comprobar que quedan existencias de product.  ¿Poner esto en otro lado?
			System.out.println("No hay existencias del producto");
		
		Order order = this.retrieveOrderById(orderId);
		
		Item item = ItemService.saveItemOrder(orderId, productId, qty);
		
		order.getItems().add(item);
		
		Order updated = orderDAO.saveOrder(order);
		
		Order updated2 = updateOrderData(order);
		
		
		return updated2;
		
	}
	
	private Order updateOrderData(Order order) {
		
		int totalItems = order.getItems().stream()
				.mapToInt( product -> product.getQtyOrdered() )
				.sum();
		
		order.setTotalItems(totalItems);
		
		double totalAmount = order.getItems().stream()
				.mapToDouble( product -> {
					Long productId = product.getProductPk();
					double productPrice = priceService.getLatestEntryByProductId(productId).getPrice();
					int productQty = product.getQtyOrdered();

					return productPrice * productQty;
				})
				.sum();
		
		order.setTotalAmount(totalAmount);
		
		return orderDAO.saveOrder(order);
	}

}
