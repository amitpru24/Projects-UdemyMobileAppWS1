package com.aa37.appsdeveloperblog.app.ws.ui.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aa37.appsdeveloperblog.app.ws.exception.UserServiceException;
import com.aa37.appsdeveloperblog.app.ws.userService.UserService;
import com.aa37.appsdeveloperblog.app.ws.userService.impl.UserServiceImpl;
import com.appsdeveloperblog.app.ws.ui.model.request.UpdateUserDetailsRequestModel;
import com.appsdeveloperblog.app.ws.ui.model.request.UserDetailsRequestModel;
import com.appsdeveloperblog.app.ws.ui.model.response.UserRest;

import jakarta.validation.*;

@RestController
@RequestMapping("/users")	//http://localhost:8080/users
public class UserController {
	
	Map<String, UserRest> users;
	
	@Autowired
	UserService userService;
	
	@GetMapping
	public String getUsers(@RequestParam(value="page",defaultValue="1", required=false) int page,
			@RequestParam(value="limit" , defaultValue="50") int limit,
			@RequestParam(value="sort",required= false) String sort) {
		return "getUsers() was invoked with page = "+ page + " and limit "+ limit + " and sort "+sort;
	}
	
	@GetMapping(path="/{userId}")
	public String getUser(@PathVariable String userId) {
		return "getUser() was invoked with userId "+ userId;
	}
	
	
	@GetMapping(path="/aa37/{userId}",produces = { MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public UserRest getUser2(@PathVariable String userId) {
		
		UserRest returnValue= new UserRest();
		returnValue.setEmail("apruthi@aa37.com");
		returnValue.setFirstName("Amit");
		returnValue.setLastName("Pruthi");
				
		return returnValue;
	}
	
	@GetMapping(path="/aa37/1/{userId}",produces = { MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity getUser4(@PathVariable String userId) {
		
		UserRest returnValue= new UserRest();
		returnValue.setEmail("apruthi@aa37.com");
		returnValue.setFirstName("Amit");
		returnValue.setLastName("Pruthi");
				
		return new ResponseEntity<UserRest>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping(path="/aa37/2/{userId}",produces = { MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity getUser3(@PathVariable String userId) {
		
		/*
		 * UserRest returnValue= new UserRest();
		 * returnValue.setEmail("apruthi@aa37.com"); returnValue.setFirstName("Amit");
		 * returnValue.setLastName("Pruthi");
		 * 
		 * return new ResponseEntity<UserRest>(returnValue,HttpStatus.BAD_REQUEST);
		 */
		
		if(true)
			throw new UserServiceException("A User Service Exception is thrown");
			
		String firstName = null;
		
		int firstNamelength = firstName.length();
		if(users.containsKey(userId)) 
			return new ResponseEntity<UserRest>(users.get(userId),HttpStatus.OK);
		else
			return new ResponseEntity<UserRest>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping
	public String createUser() {
		return "Create User was invoked";
	}
	
	@PostMapping(path="/aa37",consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}, produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE	})
	public ResponseEntity createUser2(@Valid @RequestBody UserDetailsRequestModel u1) {
		UserRest returnValue= new UserServiceImpl().createUser(u1);
				
		return new ResponseEntity<UserRest>(returnValue,HttpStatus.OK);
	}
	
	@PutMapping
	public String updateUser() {
		return "Update User was invoked";
	}
	
	@PutMapping(path="/aa37/{userId}",consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}, produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE	})
	public UserRest updateUser2(@PathVariable String userId, @Valid  @RequestBody UpdateUserDetailsRequestModel u1) {
		
		UserRest storedUserDetails = users.get(userId);
		storedUserDetails.setFirstName(u1.getFirstName());
		storedUserDetails.setLastName(u1.getLastName());
		
		users.put(userId, storedUserDetails);
		
		return storedUserDetails;
	}
	
	@DeleteMapping
	public String deleteUser() {
		return "delete User was invoked";
	}
	
	@DeleteMapping(path="/aa37/{userId}")
	public ResponseEntity<Void> deleteUser2(@PathVariable String userId) {
		users.remove(userId);
		return ResponseEntity.noContent().build();
	}

}
