package com.itgrids.dao;

import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itgrids.model.Nursery;

@Repository("nurseryDao")
public class NurseryDaoImpl extends GenericDaoHibernate<Nursery, Integer> implements NurseryDao {

	@Autowired
	SessionFactory sessionFactory;

	public NurseryDaoImpl() {
		super(Nursery.class);

	}

}
