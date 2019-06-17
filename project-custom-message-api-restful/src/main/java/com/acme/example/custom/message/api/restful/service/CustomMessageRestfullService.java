package com.acme.example.custom.message.api.restful.service;

import java.util.List;

import com.acme.example.custom.message.core.entity.CustomMessage;

public interface CustomMessageRestfullService {

	public CustomMessage findByPK(long id);
	
	public List<CustomMessage> findAll();
	
	void remove(CustomMessage userMessage);
	
}
