package com.itgrids.dao;

import java.util.List;

import org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction;
import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itgrids.model.Farmer;
import com.itgrids.model.LocationImages;

@Repository("locationImagesDao")
public class LocationImagesDaoImpl extends GenericDaoHibernate<LocationImages, Integer> implements LocationImagesDao {

	@Autowired
	SessionFactory sessionFactory;

	public LocationImagesDaoImpl() {
		super(LocationImages.class);

	}

	@Override
	public LocationImages save(LocationImages object) {
		// TODO Auto-generated method stub
		return super.save(object);
	}

	@Override
	public LocationImages get(Integer id) {
		// TODO Auto-generated method stub
		return super.get(id);
	}

	@Override
	public List<LocationImages> getAll() {
		// TODO Auto-generated method stub
		return super.getAll();
	}

	@Override
	public void remove(Integer id) {
		// TODO Auto-generated method stub
		super.remove(id);
	}

	@Override
	public List<String> getByLocationId(Integer id) {
		Criteria criteria = getSession().createCriteria(LocationImages.class);
		criteria.createAlias("locationDetails", "locationDetails");
		criteria.add(Restrictions.eq("locationDetails.id", id));
		criteria.setProjection(Projections.property("image"));
		return criteria.list();
	}

}
