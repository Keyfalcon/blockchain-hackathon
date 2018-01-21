package com.itgrids.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itgrids.model.LocationDetails;
import com.itgrids.rest.Response;
import com.itgrids.service.LocationDetailService;

@EnableAutoConfiguration
@RestController
@RequestMapping("/location")
public class LocationDetailsController {

	private static final Logger logger = LoggerFactory.getLogger(LocationDetailsController.class);

	@Autowired
	private LocationDetailService locationDetailService;

	@CrossOrigin
	@RequestMapping(value = "/registerLocationDetails", method = RequestMethod.POST)
	public Response registerLocationDetails(@RequestBody LocationDetails locationDetails) {
		Response response = null;
		try {
			locationDetailService.save(locationDetails);

			return new Response(200, "success", "");

		} catch (Exception e) {
			logger.error("Error to save Vehicle ", e.getMessage());
			response = new Response(500, "Error", null);
		}
		return response;
	}// end

}
