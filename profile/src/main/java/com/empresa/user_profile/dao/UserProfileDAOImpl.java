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
		UserProfile profile = profileRepository.getOne(id);
		return profile;
	}
	
	@Override
	public UserProfile saveUserProfile(Long id, UserProfile profile) {
		return profileRepository.saveAndFlush(profile);
	}

	@Override
	public boolean existsProfile(Long id) {
		return profileRepository.existsById(id);
	}

}
