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
	
	@Column
	private String owner;
	
	@Column
	private String ownerEmail;
	
	@Column
	private Integer phoneNumber;
	
	@Column
	private boolean isState;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getOwnerEmail() {
		return ownerEmail;
	}

	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}

	public Integer getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean getIsState() {
		return isState;
	}

	public void setIsState(boolean isState) {
		this.isState = isState;
	}
	
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
	
	

}
