package com.empresa.user_profile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.user_profile.dao.UserProfileDAO;
import com.empresa.user_profile.model.UserProfile;
import com.security.service.AppUserService;

@Service
public class UserProfileServiceImpl implements UserProfileService {
	
	@Autowired
	UserProfileDAO profileDAO;
	
	@Autowired
	AppUserService userService;
	
	@Override
	public UserProfile retrieveProfileDataById(Long id) {
		return profileDAO.getProfileById(id);
	}
	
	@Override
	public UserProfile saveProfileData(Long id, UserProfile profile) {
		
		return profileDAO.saveUserProfile(id, profile);
	}
	
	@Override
	public boolean existsProfile(Long id) {
		return profileDAO.existsProfile(id);
	}
	

}
