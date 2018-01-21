package com.itgrids.dao;

import org.appfuse.dao.GenericDao;

import com.itgrids.model.User;

public interface UserDao extends GenericDao<User, Integer> {

	User getByUserName(String name);

	User getByNamePassword(String name, String password);

	User getByPassword(String password);

	User getByBlockTokenKey(Integer id);

	User getByMobile(String contact);

}
