package com.itgrids.dao;

import java.util.List;

import org.appfuse.dao.GenericDao;

import com.itgrids.model.Farmer;
import com.itgrids.model.LocationImages;

public interface LocationImagesDao extends GenericDao<LocationImages, Integer> {

	List<String> getByLocationId(Integer id);

}
