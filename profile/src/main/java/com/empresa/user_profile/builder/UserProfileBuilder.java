package com.empresa.user_profile.builder;

import com.empresa.user_profile.dto.UserProfileDto;
import com.empresa.user_profile.model.UserProfile;

public class UserProfileBuilder {
	
	static public UserProfileDto convertToDto(UserProfile entity) {
		UserProfileDto dto = new UserProfileDto();
		dto.setId(entity.getId());
		dto.setUser(entity.getUser());
		dto.setName(entity.getName());
		dto.setSurname(entity.getSurname());
		dto.setPhoneNumber(entity.getPhoneNumber());
		
		return dto;
	}
	
	static public UserProfile convertToEntity(UserProfileDto dto) {
		UserProfile entity = new UserProfile();
		entity.setId(dto.getId());
		entity.setUser(dto.getUser());
		entity.setName(dto.getName());
		entity.setSurname(dto.getSurname());
		entity.setPhoneNumber(dto.getPhoneNumber());
		
		return entity;
	}

}
