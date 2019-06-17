package com.acme.example.custom.message.core.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acme.example.custom.message.core.entity.CustomMessage;
import com.acme.example.custom.message.core.exception.CustomMessageException;
import com.acme.example.custom.message.core.exception.enumerate.CustomMessageTypeExceptionEnum;
import com.acme.example.custom.message.core.repository.CustomMessageRepository;
import com.acme.example.custom.message.core.service.CustomMessageOperationService;
import com.acme.example.custom.message.core.validator.CustomMessageValidator;

@Service("customMessageOperationService")
@Transactional
public class CustomMessageOperationServiceImpl implements CustomMessageOperationService {
	
	private final Logger LOG = LoggerFactory.getLogger(CustomMessageOperationServiceImpl.class);
	
	@Resource
	@Qualifier ("customMessageRepository")
	private CustomMessageRepository customMessageRepository;

	@Override
	public List<CustomMessage> findAllVips() {
		LOG.trace("Find All Vips");
		
		Iterable<CustomMessage> iterable  = customMessageRepository.findAll();

		List<CustomMessage> result = StreamSupport.stream(iterable.spliterator(), false)
			      .filter(customMessage -> (customMessage.getDeletedDate()!=null))
			      .collect(Collectors.toList());
		
		return result;
	}
	
	private void generateNotFoundException(CustomMessage customMessage) throws CustomMessageException {
		if (!CustomMessageValidator.INSTANCE.isValid(customMessage)) {
			throw new CustomMessageException(CustomMessageTypeExceptionEnum.NOT_FOUND.name());
		}
	}

	@Override
	public void deleteLogical(Long id) throws CustomMessageException {
		LOG.trace("Delete Logical UserMessafe with id : {}", id);
		
		final CustomMessage customMessage = customMessageRepository.findByPK(id);
		
		generateNotFoundException(customMessage);
		
		if (CustomMessageValidator.INSTANCE.isDeletedLogical(customMessage)){
			throw new CustomMessageException(CustomMessageTypeExceptionEnum.IS_DELETED_LOGICAL.name());
		}
		
		customMessage.setDeletedDate(new Date());
		customMessageRepository.update(customMessage);
		
		LOG.trace("UserMessafe deleted logical with id : {}", id);
	}
	
	public void setCustomMessageRepository(CustomMessageRepository customMessageRepository) {
		this.customMessageRepository = customMessageRepository;
	}

}
