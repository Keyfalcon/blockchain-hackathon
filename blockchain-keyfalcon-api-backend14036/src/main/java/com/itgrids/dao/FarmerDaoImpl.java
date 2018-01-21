package com.itgrids.dao;

import java.util.List;

import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itgrids.model.Farmer;

@Repository("farmerDao")
public class FarmerDaoImpl extends GenericDaoHibernate<Farmer, Integer> implements FarmerDao {

	@Autowired
	SessionFactory sessionFactory;

	public FarmerDaoImpl() {
		super(Farmer.class);

	}

	@Override
	public Farmer save(Farmer object) {
		// TODO Auto-generated method stub
		return super.save(object);
	}

	@Override
	public Farmer get(Integer id) {
		// TODO Auto-generated method stub
		return super.get(id);
	}

	@Override
	public List<Farmer> getAll() {
		// TODO Auto-generated method stub
		return super.getAll();
	}

	@Override
	public void remove(Integer id) {
		// TODO Auto-generated method stub
		super.remove(id);
	}

}
