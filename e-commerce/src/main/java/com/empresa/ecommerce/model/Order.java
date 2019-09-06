package com.empresa.ecommerce.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.empresa.app_user.model.AppUser;

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
	AppUser user;	
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "total_amount")
	private double totalAmount;
	
	@Column(name= "total_items")
	private int totalItems;
	
	@OneToMany
	//@JoinTable(name = "order_items", joinColumns= {@JoinColumn(name = "order_id", referencedColumnName = "order_id")}, inverseJoinColumns= {@JoinColumn(name = "item_id", referencedColumnName = "item_id")})
	private List<Item> items;	

}
