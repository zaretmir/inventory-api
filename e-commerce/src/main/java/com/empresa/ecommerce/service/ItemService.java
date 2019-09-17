package com.empresa.ecommerce.service;

import com.empresa.ecommerce.model.OrderItem;

public interface ItemService {

	OrderItem updateOrderItem(OrderItem updatedItem);

	OrderItem getOrderItem(Long orderId, Long productId);

	OrderItem saveOrderItem(OrderItem item);

}
