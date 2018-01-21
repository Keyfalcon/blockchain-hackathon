package com.itgrids.dao;

import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itgrids.model.User;

@Repository("userDao")
public class UserDaoImpl extends GenericDaoHibernate<User, Integer> implements UserDao {

	@Autowired
	SessionFactory sessionFactory;

	public UserDaoImpl() {
		super(User.class);

	}

	@Override
	public User getByUserName(String name) {
		Criteria criteria = getSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("name", name));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return (User) criteria.uniqueResult();
	}

	@Override
	public User getByNamePassword(String name, String password) {
		Criteria criteria = getSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("name", name));
		criteria.add(Restrictions.eq("password", password));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return (User) criteria.uniqueResult();
	}

	@Override
	public User getByPassword(String password) {
		Criteria criteria = getSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("password", password));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return (User) criteria.uniqueResult();
	}

	@Override
	public User getByBlockTokenKey(Integer id) {
		Criteria criteria = getSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("farmerId", id));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return (User) criteria.uniqueResult();
	}

	@Override
	public User getByMobile(String contact) {
		Criteria criteria = getSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("mobile", contact));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return (User) criteria.uniqueResult();
	}

}
