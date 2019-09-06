package com.empresa.user_profile.service;

import com.empresa.user_profile.model.UserProfile;

public interface UserProfileService {


	UserProfile retrieveProfileDataById(Long id);

	UserProfile saveProfileData(Long id, UserProfile profile);

}
