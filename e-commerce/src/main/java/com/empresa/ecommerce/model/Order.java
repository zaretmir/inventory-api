package com.empresa.ecommerce.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.PositiveOrZero;

import com.empresa.app_user.model.AppUser;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "apporder")
@Getter @Setter
public class Order {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "order_id")
	Long id;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	@JsonIgnore
	AppUser user;	
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "total_amount")
	@PositiveOrZero(message = "Amount cannot be negative")
	private double totalAmount;
	
	@Column(name= "total_items")
	@PositiveOrZero(message = "Items cannot be negative")
	private int totalItems;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<OrderItem> orderItems;	

}
