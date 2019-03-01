package com.acme.example.custom.message.repository.impl;

import org.springframework.stereotype.Repository;

import com.acme.example.custom.message.entity.CustomMessage;
import com.acme.example.custom.message.repository.CustomMessageRepository;

@Repository ("customMessageRepositoryAbstractHibernateDao")
public class CustomMessageRepositoryAbstractHibernateDaoImpl extends AbstractHibernateDao<CustomMessage,Long> implements CustomMessageRepository{

	public CustomMessageRepositoryAbstractHibernateDaoImpl() {
        super();
        setClazz(CustomMessage.class);
    }

	
}
