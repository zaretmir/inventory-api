package com.empresa.user_profile.dao;

import com.empresa.user_profile.model.UserProfile;

public interface UserProfileDAO {

	UserProfile getProfileById(Long id);

	boolean existsProfile(Long id);

	UserProfile saveUserProfile(UserProfile profile);

}
