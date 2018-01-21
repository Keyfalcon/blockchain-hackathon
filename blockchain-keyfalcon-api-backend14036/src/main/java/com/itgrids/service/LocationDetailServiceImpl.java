package com.itgrids.service;

import java.util.ArrayList;
import java.util.List;

import org.appfuse.service.impl.GenericManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itgrids.dao.LocationDetailsDao;
import com.itgrids.dao.LocationImagesDao;
import com.itgrids.dao.RoleDao;
import com.itgrids.dao.UserDao;
import com.itgrids.model.LocationDetails;
import com.itgrids.rest.FarmerResponse;
import com.itgrids.rest.GetFarmersByStatusRequest;

@Service
@Transactional
public class LocationDetailServiceImpl extends GenericManagerImpl<LocationDetails, Integer>
		implements LocationDetailService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private RoleDao roleDao;

	@Autowired
	private LocationDetailsDao locationDetailsDao;

	@Autowired
	LocationImagesDao locationImagesDao;

	@Value("${fetchPath}")
	private String fetchPath;

	@Autowired
	public LocationDetailServiceImpl(LocationDetailsDao locationDetailsDao) {
		super(locationDetailsDao);
		this.locationDetailsDao = locationDetailsDao;
	}

	@Override
	public List<FarmerResponse> getAllByStatus(GetFarmersByStatusRequest request) {
		List<LocationDetails> details = locationDetailsDao.getAllByStatus(request);
		List<FarmerResponse> list = new ArrayList<>();
		for (LocationDetails details2 : details) {
			List<String> images = locationImagesDao.getByLocationId(details2.getId());
			List<String> imageList = new ArrayList<>();
			for (String string : images) {
				imageList.add(fetchPath + string);
			}
			FarmerResponse response = new FarmerResponse(details2.getId(), details2.getFarmer().getName(),
					details2.getSurveyNumber(), details2.getArea(), details2.getWaterResource(), details2.getSoilType(),
					details2.getLatitude(), details2.getLongitude(), details2.getFarmer().getAadharNumber(), imageList);
			list.add(response);
		}
		return list;
	}

}
