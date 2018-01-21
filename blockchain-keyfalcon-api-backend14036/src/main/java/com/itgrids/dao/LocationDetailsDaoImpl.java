package com.itgrids.dao;

import java.util.List;

import org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction;
import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itgrids.model.Farmer;
import com.itgrids.model.LocationDetails;
import com.itgrids.rest.GetFarmersByStatusRequest;

@Repository("locationDetailsDao")
public class LocationDetailsDaoImpl extends GenericDaoHibernate<LocationDetails, Integer>
		implements LocationDetailsDao {

	@Autowired
	SessionFactory sessionFactory;

	public LocationDetailsDaoImpl() {
		super(LocationDetails.class);

	}

	@Override
	public LocationDetails save(LocationDetails object) {
		// TODO Auto-generated method stub
		return super.save(object);
	}

	@Override
	public LocationDetails get(Integer id) {
		// TODO Auto-generated method stub
		return super.get(id);
	}

	@Override
	public List<LocationDetails> getAll() {
		// TODO Auto-generated method stub
		return super.getAll();
	}

	@Override
	public void remove(Integer id) {
		// TODO Auto-generated method stub
		super.remove(id);
	}

	@Override
	public List<LocationDetails> getAllByStatus(GetFarmersByStatusRequest request) {

		Criteria criteria = getSession().createCriteria(LocationDetails.class);
		criteria.add(Restrictions.eq("status", request.getStatus()));
		return criteria.list();

	}

	@Override
	public List<LocationDetails> getByFarmer(Integer id) {
		Criteria criteria = getSession().createCriteria(LocationDetails.class);
		criteria.createAlias("farmer", "farmer");
		criteria.add(Restrictions.eq("farmer.id", id));
		return criteria.list();
	}

}
