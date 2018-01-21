package com.itgrids.service;

import org.appfuse.service.impl.GenericManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itgrids.dao.LocationImagesDao;
import com.itgrids.dao.RoleDao;
import com.itgrids.dao.UserDao;
import com.itgrids.model.LocationImages;

@Service
@Transactional
public class LocationImagesServiceImpl extends GenericManagerImpl<LocationImages, Integer>
		implements LocationImagesService {

	private UserDao userDao;

	private RoleDao roleDao;

	private LocationImagesDao locationImagesDao;

	@Autowired
	public LocationImagesServiceImpl(LocationImagesDao locationImagesDao) {
		super(locationImagesDao);
		this.locationImagesDao = locationImagesDao;
	}

}
