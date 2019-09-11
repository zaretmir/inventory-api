package com.empresa.user_profile.builder;

import com.empresa.user_profile.dto.UserProfileDto;
import com.empresa.user_profile.model.UserProfile;

public class UserProfileBuilder {
	
	static public UserProfileDto convertToDto(UserProfile entity) {
		UserProfileDto dto = new UserProfileDto();
		
		dto.setId(entity.getId());
		dto.setUser(entity.getUserApp());
		dto.setName(entity.getName());
		dto.setSurname(entity.getSurname());
		dto.setAddress(entity.getAddress());
		dto.setPhoneNumber(entity.getPhoneNumber());
		
		return dto;
	}
	
	static public UserProfile convertToEntity(UserProfileDto dto) {
		UserProfile entity = new UserProfile();
		
		entity.setId(dto.getId());
		entity.setUserApp(dto.getUser());
		entity.setName(dto.getName());
		entity.setSurname(dto.getSurname());
		entity.setAddress(dto.getAddress());
		entity.setPhoneNumber(dto.getPhoneNumber());
		
		return entity;
	}

}
