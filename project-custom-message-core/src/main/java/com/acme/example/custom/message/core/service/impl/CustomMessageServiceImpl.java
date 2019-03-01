package com.acme.example.custom.message.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acme.architecture.common.util.converter.CollectionConverter;
import com.acme.example.custom.message.entity.CustomMessage;
import com.acme.example.custom.message.repository.CustomMessageRepository;
import com.acme.example.custom.message.service.CustomMessageService;

@Service("customMessageService")
@Transactional(readOnly = true)
public class CustomMessageServiceImpl implements CustomMessageService {

	private final Logger LOG = LoggerFactory.getLogger(CustomMessageServiceImpl.class);
	
	@Resource
	@Qualifier ("customMessageRepository")
	private CustomMessageRepository customMessageRepository;
	
	@Override
	public List<CustomMessage> findAll() {
		LOG.trace("Find all CustomMessage");
		return CollectionConverter.toList(customMessageRepository.findAll());
	}

	@Override
	public CustomMessage findByPK(Long id) {
		LOG.trace("Find CustomMessage by id : {}", id);
		return customMessageRepository.findByPK(id);
	}

	@Override
	@Transactional
	public void insert(CustomMessage customMessage) {
		LOG.trace("Insert CustomMessage");
		customMessageRepository.insert(customMessage);
	}

	@Override
	@Transactional
	public void update(CustomMessage customMessage) {
		LOG.trace("Update CustomMessage with id : {}", customMessage.getId());
		customMessageRepository.update(customMessage);
		
	}

	@Override
	@Transactional
	public void delete(CustomMessage customMessage) {
		LOG.trace("Delete CustomMessage by id : {}", customMessage.getId());
		customMessageRepository.remove(customMessage);
	}

	public void setCustomMessageRepository(CustomMessageRepository customMessageRepository) {
		this.customMessageRepository = customMessageRepository;
	}

}
