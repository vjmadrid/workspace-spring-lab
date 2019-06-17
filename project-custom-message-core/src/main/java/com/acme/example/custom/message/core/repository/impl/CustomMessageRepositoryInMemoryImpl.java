package com.acme.example.custom.message.core.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.acme.architecture.persistence.repository.test.impl.GenericMapInMemoryRepositoryImpl;
import com.acme.example.custom.message.core.entity.CustomMessage;
import com.acme.example.custom.message.core.factory.dummy.DummyCustomMessageDataFactory;
import com.acme.example.custom.message.core.repository.CustomMessageRepository;

@Repository ("customMessageRepositoryInMemory")
public class CustomMessageRepositoryInMemoryImpl extends GenericMapInMemoryRepositoryImpl<CustomMessage, Long> implements CustomMessageRepository {

	@PostConstruct
    public void setup() {
		setEntityMap(DummyCustomMessageDataFactory.createSampleMap());
    }
	
	@Override
	public List<CustomMessage> findAll() {
		return new ArrayList<CustomMessage>(getEntityMap().values());
	}

	@Override
	public CustomMessage findByPK(Long id) {
		return getEntityMap().get(id);
	}

	@Override
	public List<CustomMessage> findByQuery(String query) {
		return new ArrayList<CustomMessage>(getEntityMap().values());
	}

	@Override
	public List<CustomMessage> findByQueryParameters(String query,
			Map<String, Object> parameters) {
		return new ArrayList<CustomMessage>(getEntityMap().values());
	}

	@Override
	public void insert(CustomMessage userMessage) {
		getEntityMap().put(userMessage.getId(), userMessage);
	}

	@Override
	public void remove(CustomMessage userMessage) {
		getEntityMap().remove(userMessage.getId());
	}

	@Override
	public void update(CustomMessage userMessage) {
		getEntityMap().put(userMessage.getId(), userMessage);
	}

}
