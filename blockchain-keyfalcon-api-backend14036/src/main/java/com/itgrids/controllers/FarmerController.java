package com.itgrids.controllers;

import java.util.List;

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

import com.itgrids.dao.LocationDetailsDao;
import com.itgrids.model.Farmer;
import com.itgrids.model.LocationDetails;
import com.itgrids.model.User;
import com.itgrids.rest.AddStatusRequest;
import com.itgrids.rest.FarmerResponse;
import com.itgrids.rest.GetAllLandDetailsByFarmerRequest;
import com.itgrids.rest.GetFarmersByStatusRequest;
import com.itgrids.rest.Response;
import com.itgrids.service.FarmerService;
import com.itgrids.service.LocationDetailResponse;
import com.itgrids.service.LocationDetailService;

@EnableAutoConfiguration
@RestController
@RequestMapping("/farmer")
public class FarmerController {

	private static final Logger logger = LoggerFactory.getLogger(FarmerController.class);

	@Autowired
	private FarmerService farmerService;

	@Autowired
	private LocationDetailService locationDetailService;

	@CrossOrigin
	@RequestMapping(value = "/registerFarmer", method = RequestMethod.POST)
	public Response registerFarmer(@RequestBody Farmer farmer) {
		Response response = null;
		try {
			Farmer farmer1 = farmerService.saveFarmer(farmer);

			return new Response(200, "success", farmer1.getId());

		} catch (Exception e) {
			logger.error("Error to Register Farmer ", e.getMessage());
			response = new Response(500, "Error", null);
		}
		return response;
	}// end

	@CrossOrigin
	@RequestMapping(value = "/getAllLandDetailsByFarmer", method = RequestMethod.POST)
	public Response getAllLandDetailsByFarmer(@RequestBody GetAllLandDetailsByFarmerRequest request) {
		Response response = null;
		try {
			List<LocationDetailResponse> farmer = farmerService.getDetailByFarmer(request.getId());

			return new Response(200, "success", farmer);

		} catch (Exception e) {
			logger.error("Error to Get All Land Details By Farmer ", e.getMessage());
			response = new Response(500, "Error", null);
		}
		return response;
	}// end

	@CrossOrigin
	@RequestMapping(value = "/getProfileByFarmer", method = RequestMethod.POST)
	public Response getProfilByFarmer(@RequestBody GetAllLandDetailsByFarmerRequest request) {
		Response response = null;
		try {
			Farmer farmer = farmerService.getProfileByFarmer(request.getId());

			return new Response(200, "success", farmer);

		} catch (Exception e) {
			logger.error("Error to Get Profile By Farmer ", e.getMessage());
			response = new Response(500, "Error", null);
		}
		return response;
	}// end

	@CrossOrigin
	@RequestMapping(value = "/getAllFarmers", method = RequestMethod.GET)
	public Response getAllFarmers() {
		Response response = null;
		try {
			List<Farmer> farmer = farmerService.getAllFarmers();

			return new Response(200, "success", farmer);

		} catch (Exception e) {
			logger.error("Error to Get All Farmers ", e.getMessage());
			response = new Response(500, "Error", null);
		}
		return response;
	}// end

	@CrossOrigin
	@RequestMapping(value = "/getAllFarmersByStatus", method = RequestMethod.POST)
	public Response getAllFarmersByStatus(@RequestBody GetFarmersByStatusRequest request) {
		Response response = null;
		try {
			List<FarmerResponse> farmerResponses = locationDetailService.getAllByStatus(request);

			return new Response(200, "success", farmerResponses);

		} catch (Exception e) {
			logger.error("Error to Get All Farmers ", e.getMessage());
			response = new Response(500, "Error", null);
		}
		return response;
	}// end

	@CrossOrigin
	@RequestMapping(value = "/setStatus", method = RequestMethod.POST)
	public Response setStatus(@RequestBody AddStatusRequest addStatusRequest) {
		Response response = null;
		try {

			farmerService.setStatus(addStatusRequest);

			return new Response(200, "success", "");

		} catch (Exception e) {
			logger.error("Error to set Status ", e.getMessage());
			response = new Response(500, "Error", null);
		}
		return response;
	}// end
}
