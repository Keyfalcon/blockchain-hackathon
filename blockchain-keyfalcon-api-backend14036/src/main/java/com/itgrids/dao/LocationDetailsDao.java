package com.itgrids.dao;

import java.util.List;

import org.appfuse.dao.GenericDao;

import com.itgrids.model.Farmer;
import com.itgrids.model.LocationDetails;
import com.itgrids.rest.GetFarmersByStatusRequest;

public interface LocationDetailsDao extends GenericDao<LocationDetails, Integer> {

	List<LocationDetails> getAllByStatus(GetFarmersByStatusRequest request);

	List<LocationDetails> getByFarmer(Integer id);

}
