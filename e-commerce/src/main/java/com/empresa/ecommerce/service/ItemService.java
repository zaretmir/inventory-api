package com.empresa.ecommerce.service;

import com.empresa.ecommerce.model.Item;

public interface ItemService {

	Item saveItemOrder(Long orderId, Long productId, int qty);

}
