package com.itgrids.service;

import org.appfuse.service.impl.GenericManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itgrids.dao.ExampleDao;
import com.itgrids.model.ExampleModel;

@Service
 public class ExampleServiceImpl extends GenericManagerImpl<ExampleModel, Integer> implements ExampleService{
	
	
	
   private ExampleDao exampleDao;
	
	@Autowired
	public ExampleServiceImpl(ExampleDao exampleDao) {
	        super(exampleDao);
	        this.exampleDao = exampleDao;
	    }
	
	@Transactional
	@Override
	public ExampleModel get(Integer id) {
		
		return super.get(id);
	}
	
	
	@Transactional
	public ExampleModel getByUserName(String userName) {
		
		return exampleDao.getExampleByUsername(userName);
	}
	
	@Transactional
	@Override
		public ExampleModel save(ExampleModel object) {
			// TODO Auto-generated method stub
			return super.save(object);
		}
	

	

}
