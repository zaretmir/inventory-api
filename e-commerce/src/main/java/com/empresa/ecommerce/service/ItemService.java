package com.empresa.ecommerce.service;

import com.empresa.ecommerce.model.OrderItem;
import com.empresa.product_hangar.model.Product_Hangar;

public interface ItemService {

	OrderItem updateOrderItem(OrderItem updatedItem);

	//OrderItem getOrderItem(Long orderId, Long productId);

	OrderItem saveOrderItem(OrderItem item);

	OrderItem getOrderItem(Long orderId, Product_Hangar stockOrigin);

}
