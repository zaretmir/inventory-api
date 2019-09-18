package com.app.masterdata.price.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.app.masterdata.product_hangar.model.Product_Hangar;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="price", schema="db_inventory")
@Getter @Setter
public class Price {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="price_id")
	private long price_id;
	
	/*
	@ManyToOne
	@JoinColumn(name="product_id", foreignKey=@ForeignKey(name="product_id_fk"))
	@NotNull
	private Product product;
	*/
	
	@ManyToOne
	private Product_Hangar stockEntry;
	
	@Column
	@NotNull(message = "price may not be null")
	private double price;
	
	@Column
	//@NotNull
	private Long dateUpdated;
	
	
}
