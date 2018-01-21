package com.itgrids.dao;

import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itgrids.model.Role;

@Repository("roleDao")
public class RoleDaoImpl extends GenericDaoHibernate<Role, Integer> implements
		RoleDao {

	@Autowired
	SessionFactory sessionFactory;

	public RoleDaoImpl() {
		super(Role.class);

	}

}
