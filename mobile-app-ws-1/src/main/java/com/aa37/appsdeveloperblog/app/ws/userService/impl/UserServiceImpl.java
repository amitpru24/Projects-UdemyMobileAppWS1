package com.aa37.appsdeveloperblog.app.ws.userService.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aa37.appsdeveloperblog.app.ws.shared.Utils;
import com.aa37.appsdeveloperblog.app.ws.userService.UserService;
import com.appsdeveloperblog.app.ws.ui.model.request.UserDetailsRequestModel;
import com.appsdeveloperblog.app.ws.ui.model.response.UserRest;

@Service
public class UserServiceImpl implements UserService {
	
	Utils utils;
	
	public UserServiceImpl() {}
	
	@Autowired
	public UserServiceImpl(Utils utils) {
		this.utils = utils;
	}

	@Override
	public UserRest createUser(UserDetailsRequestModel u1) {
		
		Map<String,UserRest> users =new HashMap<>();
		
		// TODO Auto-generated method stub
		UserRest returnValue= new UserRest();
		returnValue.setEmail(u1.getEmail());
		returnValue.setFirstName(u1.getFirstName());
		returnValue.setLastName(u1.getLastName());
		
		String userId = utils.generateUserId();
		users.put(userId, returnValue);
		returnValue.setUserId(userId);
				
		return returnValue;
	}
	
	

}
