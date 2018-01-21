package com.itgrids.service;

import java.util.List;

import org.appfuse.service.impl.GenericManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itgrids.dao.RoleDao;
import com.itgrids.model.Role;

@Service
@Transactional
public class RoleServiceImpl extends GenericManagerImpl<Role, Integer>
		implements RoleService {

	private RoleDao roleDao;

	@Autowired
	public RoleServiceImpl(RoleDao roleDao) {
		super(roleDao);
		this.roleDao = roleDao;
	}

	@Override
	public Role save(Role object) {
		// TODO Auto-generated method stub
		return super.save(object);
	}

	@Override
	public Role get(Integer id) {
		// TODO Auto-generated method stub
		return super.get(id);
	}

	@Override
	public List<Role> getAll() {
		// TODO Auto-generated method stub
		return super.getAll();
	}

	@Override
	public void remove(Integer id) {
		// TODO Auto-generated method stub
		super.remove(id);
	}

}
