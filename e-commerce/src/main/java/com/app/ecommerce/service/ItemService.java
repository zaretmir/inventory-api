package com.app.ecommerce.service;

import com.app.ecommerce.model.Order;
import com.app.ecommerce.model.OrderItem;
import com.app.masterdata.product_hangar.model.Product_Hangar;

public interface ItemService {

	OrderItem updateOrderItem(OrderItem updatedItem);

	OrderItem saveOrderItem(OrderItem item);

	OrderItem getOrderItem(Order order, Product_Hangar itemOrigin);

}
