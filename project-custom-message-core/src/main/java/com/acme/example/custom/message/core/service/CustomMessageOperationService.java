package com.acme.example.custom.message.core.service;

import java.util.List;

import com.acme.example.custom.message.core.entity.CustomMessage;
import com.acme.example.custom.message.core.exception.CustomMessageException;

public interface CustomMessageOperationService {

	List<CustomMessage> findAllVips();
	
	void deleteLogical(Long id) throws CustomMessageException;
	
}
