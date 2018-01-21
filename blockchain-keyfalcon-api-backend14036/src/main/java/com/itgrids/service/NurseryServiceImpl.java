package com.itgrids.service;

import org.appfuse.service.impl.GenericManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itgrids.dao.LocationDetailsDao;
import com.itgrids.dao.LocationImagesDao;
import com.itgrids.dao.NurseryDao;
import com.itgrids.dao.RoleDao;
import com.itgrids.dao.UserDao;
import com.itgrids.model.Nursery;
import com.itgrids.model.User;

@Service
@Transactional
public class NurseryServiceImpl extends GenericManagerImpl<Nursery, Integer> implements NurseryService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private RoleDao roleDao;

	private NurseryDao nurseryDao;

	@Autowired
	private LocationDetailsDao locationDetailsDao;

	@Autowired
	private LocationImagesDao locationImagesDao;

	@Autowired
	public NurseryServiceImpl(NurseryDao nurseryDao) {
		super(nurseryDao);
		this.nurseryDao = nurseryDao;
	}

	@Value("${filePath}")
	private String filePath;

	@Override
	public User saveNursery(Nursery nursery) {
		nurseryDao.save(nursery);

		User user = new User();
		user.setName(nursery.getName());
		user.setRoles(roleDao.get(2));
		user.setMobile(nursery.getMobile());
		user.setPassword(nursery.getPassword());
		// user.setBlockTokenKey();
		User user2 = userDao.save(user);
		return user2;
	}

}
