package com.empresa.ecommerce.service;

import javax.validation.Valid;

import com.empresa.ecommerce.model.Order;

public interface OrderService {

	Order createOrder(@Valid Order orderReq);

	Order retrieveOrderById(Long id);

	Order addItem(Long id, Long productId, int qty);

}
