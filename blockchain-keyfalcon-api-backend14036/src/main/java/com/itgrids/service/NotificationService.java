package com.itgrids.service;

import java.util.List;

import org.appfuse.service.GenericManager;

import com.itgrids.model.Notification;

public interface NotificationService extends GenericManager<Notification, Integer> {

	List<Notification> getByFarmer(Integer id);

}
