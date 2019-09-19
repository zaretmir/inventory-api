package com.app.ecommerce.dao;

import com.app.ecommerce.model.Order;
import com.app.ecommerce.model.OrderItem;
import com.app.masterdata.product_hangar.model.Product_Hangar;

public interface ItemDAO {

	OrderItem saveOrderItem(OrderItem productOrd);

	OrderItem findByOrderAndItemOrigin(Order order, Product_Hangar itemOrigin);

	//OrderItem findByOrderPkAndProductPk(Long orderId, Long productId);
	
}
