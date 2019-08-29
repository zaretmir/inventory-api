package com.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.dao.AppUserDAO;

@Service
public class AppUserService {
	
	@Autowired
	AppUserDAO userDAO;
	
	public boolean isUsernameTaken(String username) {
		return userDAO.existsByUsername(username);
	}
	
	

}
