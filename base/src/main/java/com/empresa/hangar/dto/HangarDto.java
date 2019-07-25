package com.empresa.hangar.dto;


public class HangarDto {
	
	private long id;
	
	private String name;

	private String address;
	

	public HangarDto() { }
	
	public HangarDto(String name, String address) {
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
