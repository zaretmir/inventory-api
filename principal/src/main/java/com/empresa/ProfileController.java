package com.empresa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.empresa.app_user.model.AppUser;
import com.empresa.exception.EntityNotFoundException;
import com.empresa.user_profile.builder.UserProfileBuilder;
import com.empresa.user_profile.dto.UserProfileDto;
import com.empresa.user_profile.model.UserProfile;
import com.empresa.user_profile.service.UserProfileService;
import com.security.service.AppUserService;

@Controller
@RequestMapping("/api/user-management/")
@CrossOrigin
public class ProfileController {
	
	@Autowired
	UserProfileService profileService;
	
	@Autowired
	AppUserService userService;
	
	
	@PutMapping("users/{id}")
	public ResponseEntity<UserProfileDto> updateUserProfile(@PathVariable Long id, @RequestBody UserProfileDto profileReq) {
		
		if (!userService.isUser(id))
			throw new EntityNotFoundException(AppUser.class);
		
		AppUser user = userService.getUserById(id);
		profileReq.setUser(user);
		
		UserProfile toEntity = UserProfileBuilder.convertToEntity(profileReq);
		UserProfile profile = profileService.saveProfileData(id, toEntity);
		UserProfileDto profileRes = UserProfileBuilder.convertToDto(profile);
		
		return new ResponseEntity<UserProfileDto>(profileRes, HttpStatus.OK);
	}
	

}
