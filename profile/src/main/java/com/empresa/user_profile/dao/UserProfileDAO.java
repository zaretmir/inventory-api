package com.empresa.user_profile.dao;

import com.empresa.user_profile.model.UserProfile;

public interface UserProfileDAO {

	UserProfile getProfileById(Long id);

	UserProfile saveUserProfile(Long id, UserProfile profile);

}
