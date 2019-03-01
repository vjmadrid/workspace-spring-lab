package com.acme.example.custom.message.service;

import java.util.List;

import com.acme.example.custom.message.entity.CustomMessage;
import com.acme.example.custom.message.exception.CustomMessageException;

public interface CustomMessageOperationService {

	List<CustomMessage> findAllVips();
	
	void deleteLogical(Long id) throws CustomMessageException;
	
}
