package com.empresa.price.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.empresa.product.model.Product;

@Entity
@Table(name="price", schema="db_inventory")
public class Price {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="price_id")
	private long price_id;
	
	@ManyToOne
	@JoinColumn(name="product_id", foreignKey=@ForeignKey(name="product_id_fk"))
	@NotNull
	private Product product;
	
	@Column
	@NotNull(message = "price may not be null")
	private double price;
	
	@Column
	@NotNull
	private Long dateUpdated;
	
	
	public long getPrice_id() {
		return price_id;
	}

	public void setPrice_id(long price_id) {
		this.price_id = price_id;
	}
	

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public long getDateUpdated() {
		return dateUpdated;
	}
	
	public void setDateUpdated(Long dateUpdated) {
		this.dateUpdated = dateUpdated;
	}
	
	
}
