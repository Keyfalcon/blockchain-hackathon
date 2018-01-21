package com.itgrids.service;

import org.appfuse.service.GenericManager;

import com.itgrids.model.User;
import com.itgrids.rest.OtpRequest;
import com.itgrids.rest.UserResponse;

public interface UserService extends GenericManager<User, Integer> {

	User getByUserName(String name);

	User getByNamePassword(String name, String password);

	User getByPassword(String password);

	UserResponse getOtp(OtpRequest otpRequest);

	User getByBlockTokenKey(Integer id);

	User getByMobile(String contact);

}
