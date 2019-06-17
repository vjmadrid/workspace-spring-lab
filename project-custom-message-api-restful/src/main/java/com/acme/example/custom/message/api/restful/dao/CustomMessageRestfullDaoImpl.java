package com.acme.example.custom.message.api.restful.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.acme.example.custom.message.core.entity.CustomMessage;

@Repository
public class CustomMessageRestfullDaoImpl implements CustomMessageRestfullDao {

	//@PersistenceContext
	//private EntityManager transactionManager;
	 @Autowired
	 private SessionFactory sessionFactory;

	@Override
	public CustomMessage findByPK(long id) {
		return sessionFactory.getCurrentSession().get(CustomMessage.class, id);
	}

	@Override
	public List<CustomMessage> findAll() {
		return sessionFactory.getCurrentSession().createCriteria(CustomMessage.class).list();
	}

	@Override
	public void remove(CustomMessage customMessage) {
		sessionFactory.getCurrentSession().delete(customMessage);
	}
	
	

}
