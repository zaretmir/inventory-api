package com.empresa.user_profile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.app_user.model.AppUser;
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
	public UserProfile saveProfileData(Long userId, UserProfile update) {
		AppUser user = userService.getUserById(userId);
		
		if (profileDAO.existsProfile(userId)) {
			UserProfile profile = profileDAO.getProfileById(userId);
			profile = updateProfile(profile, update);
			
			return profileDAO.saveUserProfile(profile);
		}
		
		UserProfile profile = new UserProfile(user);
		profile = updateProfile(profile, update);
		
		return profileDAO.saveUserProfile(profile);		
	}
	
	
	@Override
	public boolean existsProfile(Long id) {
		return profileDAO.existsProfile(id);
	}
	
	
	private UserProfile updateProfile(UserProfile profile, UserProfile update) {		
		profile.setName(update.getName());
		profile.setSurname(update.getSurname());
		profile.setAddress(update.getAddress());
		profile.setPhoneNumber(update.getPhoneNumber());
		
		return profile;
	}
	

}
