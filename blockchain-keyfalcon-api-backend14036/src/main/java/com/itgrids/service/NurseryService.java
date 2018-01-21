package com.itgrids.service;

import org.appfuse.service.GenericManager;

import com.itgrids.model.Nursery;
import com.itgrids.model.User;

public interface NurseryService extends GenericManager<Nursery, Integer> {

	User saveNursery(Nursery nursery);

}
