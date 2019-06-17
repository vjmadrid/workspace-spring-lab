package com.acme.example.custom.message.core.repository;

import java.util.List;

import com.acme.example.custom.message.core.entity.CustomMessage;

public interface CustomMessageBasicRepository {

	public List<CustomMessage> findAll();
    
    public CustomMessage findByPK(long id);
     
    public void saveOrUpdate(CustomMessage user);
     
    public void delete(CustomMessage userMessage);
	
}
