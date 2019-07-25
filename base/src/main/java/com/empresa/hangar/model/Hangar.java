package com.empresa.hangar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="HANGAR")
public class Hangar {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="hangar_id")
	private long id;
	@Column
	private String name;
	@Column
	private String address;
	
	/*
	//@OneToMany(cascade = CascadeType.ALL, mappedBy = "hangar")
	private List<Product> products = new ArrayList<Product>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "hangar")
	//@JoinColumn(name="product_id")
	public List<Product> getProducts() {
		return products;
	}
	//public void setProducts(List<Product> products) {
	//	this.products = products;
	//}
	/*
	public void addProduct(Product product) {
		products.add(product);
		product.setHangar(this);
	}*/

	public Hangar() { }
	
	public Hangar(String name, String address) {
		this.name = name;
		this.address = address;
	}
	
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	

}
