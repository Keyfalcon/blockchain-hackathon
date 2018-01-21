package com.itgrids.service;

import java.util.List;

import org.appfuse.service.impl.GenericManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itgrids.dao.NotificationDao;
import com.itgrids.model.Notification;

@Service
@Transactional
public class NotificationServiceImpl extends GenericManagerImpl<Notification, Integer> implements NotificationService {

	private NotificationDao notificationDao;

	@Autowired
	public NotificationServiceImpl(NotificationDao notificationDao) {
		super(notificationDao);
		this.notificationDao = notificationDao;
	}

	@Override
	public List<Notification> getByFarmer(Integer id) {
		List<Notification> notification = notificationDao.getByFarmer(id);
		return notificationDao.getByFarmer(id);
	}

}
