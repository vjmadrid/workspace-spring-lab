package com.acme.example.custom.message.core.service;

import java.util.List;

import com.acme.example.custom.message.core.entity.CustomMessage;

public interface CustomMessageService {

	List<CustomMessage> findAll();
	
	CustomMessage findByPK(Long id);
	
	void insert(CustomMessage villain);

	void update(CustomMessage villain);
	
	void delete(CustomMessage id);
	
}
