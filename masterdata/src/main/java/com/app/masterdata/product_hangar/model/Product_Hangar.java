package com.app.masterdata.product_hangar.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.app.masterdata.price.model.Price;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@IdClass(Product_Hangar_Id.class)
@Table(name="product_hangar")
public class Product_Hangar {

	@Id
	@Column(name="hangarpk")
	private Long hangarPk;
	
	@Id
	@Column(name="productpk")
	private Long productPk;
	
	@Column(name="qty")
	private Integer quantity;
	
	@OneToMany(
			mappedBy = "stockEntry",
			orphanRemoval = true,
			cascade = CascadeType.ALL)
	private List<Price> priceHistory;
	
	public void addPriceEntry(Price price) {
		priceHistory.add(price);
		price.setStockEntry(this);
	}
	
	public void removePriceEntry(Price price) {
		priceHistory.remove(price);
		price.setStockEntry(null);
	}
	
}
