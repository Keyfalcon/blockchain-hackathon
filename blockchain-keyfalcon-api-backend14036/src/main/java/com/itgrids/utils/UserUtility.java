package com.itgrids.utils;

import com.itgrids.model.User;
import com.itgrids.rest.SaveUserRequest;
import com.itgrids.rest.UpdateUserRequest;

public class UserUtility {

	public static User saveUser(SaveUserRequest request) {

		User user = new User();
		user.setName(request.getName());
		user.setPassword(request.getPassword());
		return user;

	}

	public static User updateUser(UpdateUserRequest request) {

		User user = new User();
		user.setName(request.getName());
		user.setPassword(request.getPassword());
		user.setId(request.getId());
		return user;

	}

}
