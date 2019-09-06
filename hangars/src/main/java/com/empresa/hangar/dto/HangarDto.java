package com.empresa.hangar.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class HangarDto {
	
	private long id;
	
	@NotBlank(message = "Hangar name is required")
	private String name;

	private String address;
	
	private String owner;
	
	@Email(message = "E-mail not valid")
	private String ownerEmail;
	
	@Digits(message = "Phone number not valid", fraction = 0, integer = 11)
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
