package com.empresa.ecommerce.dto;

import java.util.Date;
import java.util.List;

import com.empresa.app_user.model.AppUser;
import com.empresa.ecommerce.model.Item;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OrderDto {
	
	private AppUser user;	
	
	private Date date;
	
	private double totalAmount;
	
	private int totalItems;
	
	private List<Item> items;

}
