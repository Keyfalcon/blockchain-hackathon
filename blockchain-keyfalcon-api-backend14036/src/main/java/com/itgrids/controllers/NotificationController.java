package com.itgrids.controllers;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.util.json.JSONException;
import com.amazonaws.util.json.JSONObject;
import com.itgrids.model.Farmer;
import com.itgrids.model.Notification;
import com.itgrids.rest.Response;
import com.itgrids.rest.UpdateFcmTokenRequest;
import com.itgrids.service.LocationDetailService;
import com.itgrids.service.NotificationService;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;

@EnableAutoConfiguration
@RestController
@RequestMapping("/notification")
public class NotificationController {

	@Autowired
	private NotificationService notificationService;

	@CrossOrigin
	@RequestMapping(value = "/getNotification", method = RequestMethod.POST)
	public Response getNotification(@RequestBody UpdateFcmTokenRequest request) {
		Response response = null;
		try {
			List<Notification> notifications = notificationService.getByFarmer(request.getId());

			return new Response(200, "success", notifications);

		} catch (Exception e) {

			response = new Response(500, "Error", null);
		}
		return response;
	}// end

}
