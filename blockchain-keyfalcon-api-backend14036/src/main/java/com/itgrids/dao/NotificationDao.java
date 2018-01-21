package com.itgrids.dao;

import java.util.List;

import org.appfuse.dao.GenericDao;

import com.itgrids.model.Notification;

public interface NotificationDao extends GenericDao<Notification, Integer> {

	List<Notification> getByFarmer(Integer id);

}
