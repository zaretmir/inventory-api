package com.empresa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import com.empresa.app_user.model.AppUser;
import com.empresa.exception.EntityNotFoundException;
import com.empresa.user_profile.builder.UserProfileBuilder;
import com.empresa.user_profile.dto.UserProfileDto;
import com.empresa.user_profile.model.UserProfile;
import com.empresa.user_profile.service.UserProfileService;
import com.security.config.JwtTokenUtil;
import com.security.service.AppUserService;

@Controller
@RequestMapping("/api/user-management/")
@CrossOrigin
public class ProfileController {
	
	@Autowired
	UserProfileService profileService;
	
	@Autowired
	AppUserService userService;
	
	@Autowired
	JwtTokenUtil tokenUtil;
	
	
	@PutMapping("users/{id}")
	public ResponseEntity<UserProfileDto> updateUserProfile(@PathVariable Long id, @RequestBody UserProfileDto profileReq) {
		
		if (!userService.isUser(id))
			throw new EntityNotFoundException(AppUser.class);
		
		AppUser user = userService.getUserById(id);
		
		UserProfile profile = UserProfileBuilder.convertToEntity(profileReq);
		UserProfile saved = profileService.saveProfileData(id, profile);
		UserProfileDto profileRes = UserProfileBuilder.convertToDto(saved);
		
		
		/*
		AppUser user = userService.getUserById(id);
		UserProfile profile = UserProfileBuilder.convertToEntity(profileReq);
		user.setUserProfile(profile);
		
		UserProfileDto profileRes = UserProfileBuilder.convertToDto(user.getUserProfile());
		*/
		
		return new ResponseEntity<UserProfileDto>(profileRes, HttpStatus.OK);
	}
	
	@GetMapping("users/{id}")
	public ResponseEntity<UserProfileDto> getUserprofile(
			@PathVariable("id") Long id,
			@RequestHeader(name="Authorization") String token) {
		
		System.out.println(token);
		token = token.replace("Bearer ", "");
		System.out.println(token);
		System.out.println(tokenUtil.getUsernameFromToken(token));
		
		if (!userService.isUser(id))
			throw new EntityNotFoundException(AppUser.class);
		if (!profileService.existsProfile(id))
			throw new EntityNotFoundException(UserProfile.class);
		
		UserProfile req = profileService.retrieveProfileDataById(id);
		UserProfileDto reqDto = UserProfileBuilder.convertToDto(req);
		
		return new ResponseEntity<UserProfileDto>(reqDto, HttpStatus.OK);		
	}
	
	@GetMapping("users-auth/{id}")
	public ResponseEntity<AppUser> getUser(@PathVariable("id") Long id) {
		
		if (!userService.isUser(id))
			throw new EntityNotFoundException(AppUser.class);
		
		AppUser req = userService.getUserById(id);
		
		return new ResponseEntity<AppUser>(req, HttpStatus.OK);		
	}
	

}
