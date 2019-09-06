package com.empresa;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.empresa.ecommerce.builder.OrderBuilder;
import com.empresa.ecommerce.dto.OrderDto;
import com.empresa.ecommerce.model.Order;
import com.empresa.ecommerce.repository.ItemRepository;
import com.empresa.ecommerce.repository.OrderRepository;
import com.empresa.ecommerce.service.OrderService;

@Controller
@RequestMapping("/api/order-management")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	ItemRepository itemRepository;
	
	@GetMapping("/orders/{id}") // Both user id and order id should return the same order (shared id)
	public ResponseEntity<OrderDto> getOrder(@PathVariable Long id) {
		
		Order order = orderService.retrieveOrderById(id);
			
		return new ResponseEntity<OrderDto>(OrderBuilder.convertToDto(order), HttpStatus.OK);		
	}
	
	@PostMapping("/orders")
	public ResponseEntity<OrderDto> postOrder(@Valid @RequestBody OrderDto orderReq) {
		
		Order order = OrderBuilder.convertToEntity(orderReq);		
		
		OrderDto orderRes = OrderBuilder.convertToDto(orderService.createOrder(order));
		
		return new ResponseEntity<OrderDto>(orderRes, HttpStatus.OK);		
	}
	
	@PutMapping("/orders/{order-id}/add-item/{product-id}")
	public ResponseEntity<OrderDto> addItemToBasket(
			@PathVariable(name = "order-id") Long orderId,
			@PathVariable(name = "product-id") Long productId,
			@RequestParam(required = false, defaultValue = "1") int qty) {
		
		Order updated = orderService.addItem(orderId, productId, qty);
		
		OrderDto response = OrderBuilder.convertToDto(updated);
		
		return new ResponseEntity<OrderDto>(response, HttpStatus.OK);
	}

}
