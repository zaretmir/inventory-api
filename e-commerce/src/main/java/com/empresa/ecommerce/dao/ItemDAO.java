package com.empresa.ecommerce.dao;

import com.empresa.ecommerce.model.OrderItem;
import com.empresa.product_hangar.model.Product_Hangar;

public interface ItemDAO {

	OrderItem saveOrderItem(OrderItem productOrd);

	OrderItem findByOrderPkAndItemOrigin(Long orderPk, Product_Hangar itemOrigin);

	//OrderItem findByOrderPkAndProductPk(Long orderId, Long productId);
	
}
