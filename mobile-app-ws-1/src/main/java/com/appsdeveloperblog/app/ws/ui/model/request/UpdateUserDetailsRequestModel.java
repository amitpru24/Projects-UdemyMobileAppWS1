package com.appsdeveloperblog.app.ws.ui.model.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UpdateUserDetailsRequestModel {
	
	@NotNull(message="First Name can't be null")
	@Size(min=2,message="First Name must not be less than 2 Characters")
	private String firstName;
	@NotNull(message="Last Name can't be null")
	@Size(min=2,message="Last Name must not be less than 2 Characters")
	private String lastName;
	
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
	
	

}
