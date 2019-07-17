package com.empresa.hangar.model;

import javax.validation.constraints.NotEmpty;

public class HangarRequest {
	
	@NotEmpty
	private String name;
	@NotEmpty
	private String address;
	
	//private List<Product> products = new ArrayList<Product>();

	public HangarRequest() { }

	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	

}
