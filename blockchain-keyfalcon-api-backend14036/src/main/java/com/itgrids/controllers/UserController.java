package com.itgrids.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itgrids.model.Role;
import com.itgrids.model.User;
import com.itgrids.rest.OtpRequest;
import com.itgrids.rest.Response;
import com.itgrids.rest.SaveUserRequest;
import com.itgrids.rest.UpdateFcmTokenRequest;
import com.itgrids.rest.UpdateUserRequest;
import com.itgrids.rest.UserResponse;
import com.itgrids.rest.WebLoginRequest;
import com.itgrids.service.RoleService;
import com.itgrids.service.UserService;
import com.itgrids.utils.UserUtility;

@RestController
@Controller
@CrossOrigin
@RequestMapping(value = "/user")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@CrossOrigin
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public Response saveUser(@RequestBody SaveUserRequest request) {
		Response response = null;
		try {

			User saveUser = UserUtility.saveUser(request);
			Role role = roleService.get(request.getRoleId());
			saveUser.setRoles(role);

			User user9 = userService.getByUserName(request.getName());

			if (user9 != null) {
				return new Response(201, "User name is already registered ", "");
			}

			else {
				User user = userService.save(saveUser);
				User responseUser = new User();
				BeanUtils.copyProperties(user, responseUser, "password");
				return new Response(200, "success", responseUser);
			}
		} catch (Exception e) {
			logger.error("Error to save Vehicle ", e.getMessage());
			response = new Response(500, "Error", null);
		}
		return response;
	}// end

	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public Response updateUser(@RequestBody UpdateUserRequest request) {
		Response response = null;
		try {

			User saveUser = UserUtility.updateUser(request);
			Role role = roleService.get(request.getRoleId());
			saveUser.setRoles(role);

			User user9 = userService.getByUserName(request.getName());

			if (user9 != null && user9.getId() != request.getId()) {
				return new Response(201, "User name is already registered ", "");

			}

			else {
				User user = userService.save(saveUser);
				User responseUser = new User();
				BeanUtils.copyProperties(user, responseUser, "password");
				return new Response(200, "success", responseUser);
			}

		} catch (Exception e) {
			logger.error("Error to save Vehicle ", e.getMessage());
			response = new Response(500, "Error", null);
		}
		return response;
	}// end

	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
	public Response updateUser(@RequestBody User request) {
		Response response = null;
		try {
			userService.remove(request.getId());
			return new Response(200, "success", "");

		} catch (Exception e) {
			logger.error("Error to save Vehicle ", e.getMessage());
			response = new Response(500, "Error", null);
		}
		return response;
	}// end

	@CrossOrigin
	@RequestMapping(value = "/webLogin", method = RequestMethod.POST)
	public Response webLogin(@RequestBody WebLoginRequest webLoginRequest) {
		Response response = null;
		try {
			User loginUser = userService.getByNamePassword(webLoginRequest.getUserName(),
					webLoginRequest.getPassword());

			User userbyName = userService.getByUserName(webLoginRequest.getUserName());
			User userByPassword = userService.getByPassword(webLoginRequest.getPassword());

			if (loginUser != null) {
				User user2 = new User();
				BeanUtils.copyProperties(loginUser, user2, "password");
				return new Response(200, "success", user2);
			} else if (userbyName == null) {
				return new Response(201, "Invalid userName ", "");
			} else if (userByPassword == null) {
				return new Response(202, "Invalid password ", "");
			} else {
				return new Response(203, "Invalid user", "");
			}

		} catch (Exception e) {
			logger.error("Error to login User ", e.getMessage());
			response = new Response(500, "Error", null);
		}
		return response;
	}// end

	@CrossOrigin
	@RequestMapping(value = "/getUser", method = RequestMethod.GET)
	public Response getUser() {
		Response response = null;
		try {

			return new Response(200, "success", userService.getAll());
		} catch (Exception e) {
			logger.error("Error to save Driver ", e.getMessage());
			response = new Response(500, "Error", null);
		}
		return response;
	}// end

	@CrossOrigin
	@RequestMapping(value = "/getRoles", method = RequestMethod.GET)
	public Response getRoles() {
		Response response = null;
		try {

			return new Response(200, "success", roleService.getAll());
		} catch (Exception e) {
			logger.error("Error to save Driver ", e.getMessage());
			response = new Response(500, "Error", null);
		}
		return response;
	}// end

	@CrossOrigin
	@RequestMapping(value = "/getOtp", method = RequestMethod.POST)
	public Response getOtp(@RequestBody OtpRequest otpRequest) {
		Response response = null;
		try {
			User user = userService.getByMobile(otpRequest.getContact());
			if (user != null) {
				UserResponse userResponse = userService.getOtp(otpRequest);
				userResponse.setToken(user.getBlockTokenKey());
				return new Response(200, "Otp generatd", userResponse);
			} else {
				return new Response(201, "Mobile Number not registered", "");
			}
		} catch (Exception e) {
			logger.error("Error to login Vehicle ", e.getMessage());
			response = new Response(500, "Error", null);
		}
		return response;
	}// end

	@CrossOrigin
	@RequestMapping(value = "/updateFcmToken", method = RequestMethod.POST)
	public Response updateFcmToken(@RequestBody UpdateFcmTokenRequest request) {
		Response response = null;
		try {

			User user = userService.getByBlockTokenKey(request.getId());
			user.setFcmToken(request.getFcmToken());
			userService.save(user);

			return new Response(200, "FcmToken updated", "");

		} catch (Exception e) {
			logger.error("Error to FcmToken update ", e.getMessage());
			response = new Response(500, "Error", null);
		}
		return response;
	}// end
}
