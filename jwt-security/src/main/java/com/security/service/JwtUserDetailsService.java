package com.security.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.base.app_user.model.AppUser;
import com.app.base.exception.ApplicationException;
import com.app.base.user_profile.model.UserProfile;
import com.security.config.JwtTokenUtil;
import com.security.dao.AppUserDAO;
import com.security.exception.SecurityExceptionCause;
import com.security.model.Role;
import com.security.model.User_Role;
import com.security.repository.RoleRepository;
import com.security.repository.User_RoleRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	AppUserDAO userDAO;
	
	@Autowired
	RoleRepository roleRepo;
	
	@Autowired
	User_RoleRepository urRepo;
	
	@Autowired
	AppUserService userService;
	
	@Autowired
    JwtTokenUtil tokenUtil;
	
	@Autowired
	PasswordEncoder encoder;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		AppUser us = userDAO.findByUsername(username);
		
		Collection<? extends GrantedAuthority> roles = getAuthorities(us);
		
		UserDetails usDetails = new User(us.getUsername(), us.getPassword(), roles);
		
		return usDetails;
	}
	
	
	public String generateToken(UserDetails userDetails) {
		return tokenUtil.generateToken(userDetails);
	}
	
	
	public String getUsernameFromToken(String token) {
		token = token.replace("Bearer ", "");
		return tokenUtil.getUsernameFromToken(token);
	}
	
	public AppUser save(AppUser user) {
		
		if (userService.getByUsername(user.getUsername()) != null) 
			throw new ApplicationException(SecurityExceptionCause.ALREADY_EXISTS);
			
		user.setPassword(encoder.encode(user.getPassword()));
		
		UserProfile profile = new UserProfile(user);
		user.setUserProfile(profile);		
		
		AppUser savedUser = userDAO.save(user);
		
		assignRole_User(savedUser);			
		
		return savedUser;
	}
	
	
	
	private void assignRole_User(AppUser user) {
		Long ROLE_USER_ID = roleRepo.findByRolename("USER").getId();
		User_Role role = new User_Role(user.getId(), ROLE_USER_ID);
		urRepo.save(role);	
	}
	
	
	private Collection<? extends GrantedAuthority> getAuthorities(AppUser user) {
		
		Long userid = user.getId();
		List<User_Role> userRoles = urRepo.findByUserpk(userid);
		List<Long> rolesId = userRoles.stream().map( (ur) -> ur.getRolepk()).collect(Collectors.toList());
		List<Role> roles = rolesId.stream().map( (rid) -> roleRepo.findOneById(rid) ).collect(Collectors.toList());
		String[] roleNames = roles.stream().map( (r) -> r.getRolename() ).toArray(String[]::new);
		
		Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(roleNames);
		return authorities;		
    }
	

}
