package com.security.builder;

import com.app.base.app_user.model.AppUser;
import com.security.dto.AppUserDTO;

public class AppUserBuilder {
	
		
	
	static public AppUser convertToEntity(AppUserDTO dto) {
		AppUser user = new AppUser();
		user.setUsername(dto.getUsername());
		user.setPassword(dto.getPassword());
		return user;
	}
	
	/* Por ahora no se va a usar
	static public AppUserDTO convertToDto(AppUser user) {
		AppUserDTO dto = new AppUserDTO();
		dto.setId(user.getId());
		dto.setUsername(user.getUsername());
		dto.setPassword(user.getPassword());
		return dto;
	}
	*/

}
