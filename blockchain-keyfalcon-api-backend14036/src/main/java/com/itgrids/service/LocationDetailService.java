package com.itgrids.service;

import java.util.List;

import org.appfuse.service.GenericManager;

import com.itgrids.model.LocationDetails;
import com.itgrids.rest.FarmerResponse;
import com.itgrids.rest.GetFarmersByStatusRequest;

public interface LocationDetailService extends GenericManager<LocationDetails, Integer> {

	List<FarmerResponse> getAllByStatus(GetFarmersByStatusRequest request);

}
