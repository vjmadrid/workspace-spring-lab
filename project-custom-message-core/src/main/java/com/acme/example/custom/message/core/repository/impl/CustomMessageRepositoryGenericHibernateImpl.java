package com.acme.example.custom.message.core.repository.impl;

import javax.annotation.PostConstruct;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.acme.architecture.persistence.repository.hibernate.impl.GenericHibernateRepositoryImpl;
import com.acme.example.custom.message.core.entity.CustomMessage;
import com.acme.example.custom.message.core.repository.CustomMessageRepository;

@Repository ("customMessageRepository")
@Transactional
public class CustomMessageRepositoryGenericHibernateImpl extends GenericHibernateRepositoryImpl<CustomMessage, Long> implements CustomMessageRepository {

	@Autowired
    private SessionFactory sessionFactory;
	
	@PostConstruct
	public void setup() {
		setSessionFactory(sessionFactory);
		setDaoType(CustomMessage.class);
	}
	
}	
	