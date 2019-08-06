package com.empresa.hangar.dto;

public class HangarDto {
	
	private long id;
	
	private String name;

	private String address;
	
	private String owner;
	
	private String ownerEmail;
	
	private Integer phoneNumber;
	
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

	public HangarDto() { }
	
	public HangarDto(String name, String address) {
		this.name = name;
		this.address = address;
	}
	

}
