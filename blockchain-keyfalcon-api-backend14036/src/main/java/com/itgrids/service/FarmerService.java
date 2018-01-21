package com.itgrids.service;

import java.util.List;

import org.appfuse.service.GenericManager;

import com.itgrids.model.Farmer;
import com.itgrids.model.User;
import com.itgrids.rest.AddStatusRequest;
import com.itgrids.rest.GetFarmersByStatusRequest;

public interface FarmerService extends GenericManager<Farmer, Integer> {

	Farmer saveFarmer(Farmer Farmer);

	List<LocationDetailResponse> getDetailByFarmer(Integer id);

	Farmer getProfileByFarmer(Integer id);

	List<Farmer> getAllFarmers();

	void setStatus(AddStatusRequest addStatusRequest);

}
