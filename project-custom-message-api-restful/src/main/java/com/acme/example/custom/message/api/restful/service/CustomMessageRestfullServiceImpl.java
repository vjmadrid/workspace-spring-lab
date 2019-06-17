package com.acme.example.custom.message.api.restful.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acme.example.custom.message.api.restful.dao.CustomMessageRestfullDao;
import com.acme.example.custom.message.core.entity.CustomMessage;

@Service
public class CustomMessageRestfullServiceImpl implements CustomMessageRestfullService {

	 @Autowired
	 private CustomMessageRestfullDao exampleDao;

	
	@Override
	@Transactional(readOnly = true)
	public CustomMessage findByPK(long id) {
		
		return exampleDao.findByPK(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<CustomMessage> findAll() {
		return exampleDao.findAll();
	}

	@Override
	@Transactional
	public void remove(CustomMessage customMessage) {
		exampleDao.remove(customMessage);
	}

}
