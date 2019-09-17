package com.empresa.ecommerce.dto;

import java.util.Date;
import java.util.List;

import com.empresa.app_user.model.AppUser;
import com.empresa.ecommerce.model.OrderItem;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OrderDto {
	
	private Long id;
	
	private AppUser user;	
	
	private Date date;
	
	private double totalAmount;
	
	private int totalItems;
	
	private List<OrderItem> orderItems;

}
