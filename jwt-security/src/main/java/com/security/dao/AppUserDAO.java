package com.security.dao;

import com.app.base.app_user.model.AppUser;

public interface AppUserDAO {
	
	AppUser findByUsername(String username);
	
	AppUser save(AppUser user);
	
	Boolean existsByUsername(String username);

	boolean existsById(Long id);

	AppUser getUserById(Long id);

}
