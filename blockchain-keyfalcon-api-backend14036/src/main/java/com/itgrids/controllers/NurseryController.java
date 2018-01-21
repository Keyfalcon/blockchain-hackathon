package com.itgrids.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itgrids.model.ExampleModel;
import com.itgrids.model.Farmer;
import com.itgrids.model.Nursery;
import com.itgrids.model.Role;
import com.itgrids.model.User;
import com.itgrids.rest.Response;
import com.itgrids.rest.SaveUserRequest;
import com.itgrids.service.ExampleService;
import com.itgrids.service.FarmerService;
import com.itgrids.service.NurseryService;
import com.itgrids.utils.UserUtility;

@EnableAutoConfiguration
@RestController
@RequestMapping("/nursery")
public class NurseryController {

	private static final Logger logger = LoggerFactory.getLogger(NurseryController.class);

	@Autowired
	private NurseryService nurseryService;

	@CrossOrigin
	@RequestMapping(value = "/registerNursery", method = RequestMethod.POST)
	public Response registerFormer(@RequestBody Nursery nursery) {
		Response response = null;
		try {
			User nursery2 = nurseryService.saveNursery(nursery);

			return new Response(200, "success", nursery2);

		} catch (Exception e) {
			logger.error("Error to Register Nursery ", e.getMessage());
			response = new Response(500, "Error", null);
		}
		return response;
	}// end

}
