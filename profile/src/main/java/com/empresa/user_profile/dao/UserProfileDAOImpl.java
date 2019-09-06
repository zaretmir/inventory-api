package com.empresa.user_profile.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.empresa.user_profile.model.UserProfile;
import com.empresa.user_profile.repository.UserProfileRepository;

@Component
public class UserProfileDAOImpl implements UserProfileDAO {
	
	@Autowired
	UserProfileRepository profileRepository;
	
	@Override
	public UserProfile getProfileById(Long id) {
		return profileRepository.getOne(id);
	}
	
	@Override
	public UserProfile saveUserProfile(Long id, UserProfile profile) {
		return profileRepository.saveAndFlush(profile);
	}

}
