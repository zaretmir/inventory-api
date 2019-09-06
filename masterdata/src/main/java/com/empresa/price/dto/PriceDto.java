package com.empresa.price.dto;

import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.PositiveOrZero;

import com.empresa.product.model.Product;

public class PriceDto {
	
	private long price_id;
	
	private Product product;
	
	@PositiveOrZero(message = "Price cannot be negative")
	private double price;
	
	@PastOrPresent(message = "Date updated is not valid")
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
