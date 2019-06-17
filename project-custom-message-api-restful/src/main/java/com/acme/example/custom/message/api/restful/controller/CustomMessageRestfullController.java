package com.acme.example.custom.message.api.restful.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.util.UriComponentsBuilder;

import com.acme.example.custom.message.api.restful.constant.CustomMessageRestfullConstant;
import com.acme.example.custom.message.api.restful.entity.CustomErrorTypeMessage;
import com.acme.example.custom.message.core.entity.CustomMessage;
import com.acme.example.custom.message.core.service.CustomMessageService;
import com.acme.example.custom.message.core.validator.CustomMessageValidator;

@RestController
@RequestMapping(CustomMessageRestfullConstant.MAPPING)
@Transactional
public class CustomMessageRestfullController {

	public static final Logger LOG = LoggerFactory.getLogger(CustomMessageRestfullController.class);

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private CustomMessageService customMessageService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CustomMessage>> findAll() {
		LOG.info("Find All CustomMessage");
		final List<CustomMessage> userMessageList = customMessageService.findAll();
			
		if (userMessageList == null || userMessageList.isEmpty()) {
			return new ResponseEntity<List<CustomMessage>>(HttpStatus.NOT_FOUND);
			// return HttpStatus.NO_CONTENT
		}

		return new ResponseEntity<List<CustomMessage>>(userMessageList, HttpStatus.OK);
	}

	private String generateErrorMessage(String type, Object[] pks, HttpServletRequest request) {
		return messageSource.getMessage(type, pks, RequestContextUtils.getLocale(request));
	}

	@RequestMapping(value = CustomMessageRestfullConstant.MAPPING_PK, method = RequestMethod.GET)
	public ResponseEntity<?> findByPk(@PathVariable("id") long id, HttpServletRequest request) {
		LOG.info("Fetching CustomMessage with id {}", id);
		final CustomMessage userMessageFound = customMessageService.findByPK(id);

		if (!CustomMessageValidator.INSTANCE.isValid(userMessageFound)) {
			final String errorMessage = generateErrorMessage(CustomMessageRestfullConstant.MESSAGE_NOT_FOUND,
					new Object[] { id }, request);
			LOG.error(errorMessage);
			return new ResponseEntity<Object>(new CustomErrorTypeMessage(errorMessage), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<CustomMessage>(userMessageFound, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> insert(@RequestBody CustomMessage customMessage, UriComponentsBuilder ucBuilder,
			HttpServletRequest request) {
		LOG.info("Creating CustomMessage : {}", customMessage);
		final CustomMessage userMessageFound = customMessageService.findByPK(customMessage.getId());

		if (CustomMessageValidator.INSTANCE.isValid(userMessageFound)) {
			final String errorMessage = generateErrorMessage(CustomMessageRestfullConstant.MESSAGE_EXIST,
					new Object[] { customMessage.getId() }, request);
			LOG.error(errorMessage);
			return new ResponseEntity<Object>(new CustomErrorTypeMessage(errorMessage), HttpStatus.CONFLICT);
		}

		customMessageService.insert(customMessage);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path(CustomMessageRestfullConstant.MAPPING+CustomMessageRestfullConstant.MAPPING_PK).buildAndExpand(customMessage.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = CustomMessageRestfullConstant.MAPPING_PK, method = RequestMethod.PUT)
	public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody CustomMessage customMessage,
			HttpServletRequest request) {
		LOG.info("Updating CustomMessage with id {}", id);
		final CustomMessage customMessageFound = customMessageService.findByPK(customMessage.getId());

		if (!CustomMessageValidator.INSTANCE.isValid(customMessageFound)) {
			final String errorMessage = generateErrorMessage(CustomMessageRestfullConstant.MESSAGE_NOT_FOUND,
					new Object[] { id }, request); 
			LOG.error(errorMessage);
			return new ResponseEntity<Object>(new CustomErrorTypeMessage(errorMessage), HttpStatus.NOT_FOUND);
		}

		customMessageFound.setDescription(customMessage.getDescription());
		customMessageFound.setVip(customMessage.isVip());

		customMessageService.update(customMessageFound);
		return new ResponseEntity<CustomMessage>(customMessageFound, HttpStatus.OK);
	}

	@RequestMapping(value = CustomMessageRestfullConstant.MAPPING_PK, method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable("id") long id, HttpServletRequest request) {
		LOG.info("Fetching & Deleting CustomMessage with id {}", id);
		
		final CustomMessage customMessageFound = customMessageService.findByPK(id);
		
		if (!CustomMessageValidator.INSTANCE.isValid(customMessageFound)) {
			final String errorMessage = generateErrorMessage(CustomMessageRestfullConstant.MESSAGE_NOT_FOUND,
					new Object[] { id }, request); 
			LOG.error(errorMessage);
			return new ResponseEntity<Object>(new CustomErrorTypeMessage(errorMessage), HttpStatus.NOT_FOUND);
		}

		customMessageService.delete(customMessageFound);
		
		return new ResponseEntity<CustomMessage>(HttpStatus.OK);
	}

	public void setCustomMessageService(CustomMessageService customMessageService) {
		this.customMessageService = customMessageService;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

}