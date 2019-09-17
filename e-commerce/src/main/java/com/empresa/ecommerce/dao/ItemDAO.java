package com.empresa.ecommerce.dao;

import com.empresa.ecommerce.model.OrderItem;

public interface ItemDAO {

	OrderItem saveOrderItem(OrderItem productOrd);

	OrderItem findByOrderPkAndProductPk(Long orderId, Long productId);
}
