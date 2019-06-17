package com.acme.example.custom.message.api.restful.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.acme.example.custom.message.api.restful.constant.CustomMessageRestfullConstant;
import com.acme.example.custom.message.api.restful.entity.CustomErrorTypeMessage;
import com.acme.example.custom.message.api.restful.service.CustomMessageRestfullService;
import com.acme.example.custom.message.core.entity.CustomMessage;
import com.acme.example.custom.message.core.validator.CustomMessageValidator;

@RestController
@RequestMapping("/test")
@Transactional
public class ExampleController {

	public static final Logger LOG = LoggerFactory.getLogger(ExampleController.class);

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private CustomMessageRestfullService customMessageRestfullService;
	
	@RequestMapping(value = "/example", method = RequestMethod.GET)
	public ResponseEntity<List<CustomMessage>> findAll() {
		LOG.info("Find All CustomMessage");
		final List<CustomMessage> customMessageList = customMessageRestfullService.findAll();

		if (customMessageList == null || customMessageList.isEmpty()) {
			return new ResponseEntity<List<CustomMessage>>(HttpStatus.NOT_FOUND);
			// return HttpStatus.NO_CONTENT
		}

		return new ResponseEntity<List<CustomMessage>>(customMessageList, HttpStatus.OK);
	}

	private String generateErrorMessage(String type, Object[] pks, HttpServletRequest request) {
		return messageSource.getMessage(type, pks, RequestContextUtils.getLocale(request));
	}

	@RequestMapping(value = "/example/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findByPk(@PathVariable("id") long id, HttpServletRequest request) {
		LOG.info("Fetching CustomMessage with id {}", id);
		final CustomMessage customMessageFound = customMessageRestfullService.findByPK(id);

		if (!CustomMessageValidator.INSTANCE.isValid(customMessageFound)) {
			final String errorMessage = generateErrorMessage(CustomMessageRestfullConstant.MESSAGE_NOT_FOUND,
					new Object[] { id }, request);
			LOG.error(errorMessage);
			return new ResponseEntity<Object>(new CustomErrorTypeMessage(errorMessage), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<CustomMessage>(customMessageFound, HttpStatus.OK);
	}

	@RequestMapping(value = "/example/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable("id") long id, HttpServletRequest request) {
		LOG.info("Fetching & Deleting CustomMessage with id {}", id);
		
		final CustomMessage customMessageFound = customMessageRestfullService.findByPK(id);
		
		if (!CustomMessageValidator.INSTANCE.isValid(customMessageFound)) {
			final String errorMessage = generateErrorMessage(CustomMessageRestfullConstant.MESSAGE_NOT_FOUND,
					new Object[] { id }, request); 
			LOG.error(errorMessage);
			return new ResponseEntity<Object>(new CustomErrorTypeMessage(errorMessage), HttpStatus.NOT_FOUND);
		}

		customMessageRestfullService.remove(customMessageFound);
		
		return new ResponseEntity<CustomMessage>(HttpStatus.OK);
	}
	
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

}