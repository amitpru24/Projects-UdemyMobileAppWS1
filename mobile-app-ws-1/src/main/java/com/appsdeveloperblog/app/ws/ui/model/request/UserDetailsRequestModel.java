package com.appsdeveloperblog.app.ws.ui.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserDetailsRequestModel {
	
	@NotNull(message="First Name can't be null")
	@Size(min=2,message="First Name must not be less than 2 Characters")
	private String firstName;
	@NotNull(message="Last Name can't be null")
	@Size(min=2,message="Last Name must not be less than 2 Characters")
	private String lastName;
	@NotNull(message="Email Name can't be null")
	@Email
	private String email;
	
	@NotNull(message="Password can't be null")
	@Size(min=8,max=16,message="Password must be equal or greater than 8 characters and less than 16 characters")
	private String password;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}