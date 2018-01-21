package com.itgrids.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itgrids.model.Farmer;
import com.itgrids.model.ForestOfficer;
import com.itgrids.rest.Response;
import com.itgrids.service.FarmerService;
import com.itgrids.service.ForestOfficerService;

@EnableAutoConfiguration
@RestController
@RequestMapping("/forest")
public class ForestOfficeController {
	
	
	
	private static final Logger logger = LoggerFactory.getLogger(ForestOfficeController.class);

	@Autowired
	private ForestOfficerService forestOfficerService;
	
	
	@CrossOrigin
	@RequestMapping(value = "/forestRegister", method = RequestMethod.POST)
	public Response forestRegister( @RequestBody ForestOfficer forestOfficer) {
		Response response = null;
		try {
			String token = forestOfficerService.save(forestOfficer);

			return new Response(200, "success", token);

		} catch (Exception e) {
			logger.error("Error to Register Farmer ", e.getMessage());
			response = new Response(500, "Error", null);
		}
		return response;
	}// end

}
