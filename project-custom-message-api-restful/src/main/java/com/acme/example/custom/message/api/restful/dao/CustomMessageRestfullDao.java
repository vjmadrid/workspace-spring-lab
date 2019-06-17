package com.acme.example.custom.message.api.restful.dao;

import java.util.List;

import com.acme.example.custom.message.core.entity.CustomMessage;

public interface CustomMessageRestfullDao {
	
	public CustomMessage findByPK(long id);
	
	public List<CustomMessage> findAll();
	
	void remove(CustomMessage customMessage);
	
}
