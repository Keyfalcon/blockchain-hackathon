package com.itgrids.dao;

import java.util.List;

import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itgrids.model.Notification;


@Repository("notificationDao")
public class NotificationDaoImpl extends GenericDaoHibernate<Notification, Integer> implements NotificationDao {

	@Autowired
	SessionFactory sessionFactory;

	public NotificationDaoImpl() {
		super(Notification.class);

	}

	@Override
	public Notification save(Notification object) {
		// TODO Auto-generated method stub
		return super.save(object);
	}

	@Override
	public Notification get(Integer id) {
		// TODO Auto-generated method stub
		return super.get(id);
	}

	@Override
	public List<Notification> getAll() {
		// TODO Auto-generated method stub
		return super.getAll();
	}

	@Override
	public void remove(Integer id) {
		// TODO Auto-generated method stub
		super.remove(id);
	}

	@Override
	public List<Notification> getByFarmer(Integer id) {
		Criteria criteria=getSession().createCriteria(Notification.class);
		criteria.createAlias("farmer", "farmer");
		criteria.add(Restrictions.eq("farmer.id", id));
		return criteria.list();
	}

}
