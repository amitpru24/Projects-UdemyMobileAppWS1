package com.aa37.appsdeveloperblog.app.ws.userService;

import com.appsdeveloperblog.app.ws.ui.model.request.UserDetailsRequestModel;
import com.appsdeveloperblog.app.ws.ui.model.response.UserRest;

public interface UserService {
	
	UserRest createUser(UserDetailsRequestModel userDetails);

}
