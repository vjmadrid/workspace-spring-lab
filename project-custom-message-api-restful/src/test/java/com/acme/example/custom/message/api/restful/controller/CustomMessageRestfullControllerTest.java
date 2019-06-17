package com.acme.example.custom.message.api.restful.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import com.acme.example.custom.message.core.constant.CustomMessageConstant;
import com.acme.example.custom.message.core.entity.CustomMessage;
import com.acme.example.custom.message.core.factory.dummy.DummyCustomMessageDataFactory;
import com.acme.example.custom.message.core.service.CustomMessageService;

public class CustomMessageRestfullControllerTest {
	
	private final String MESSAGE_SOURCE_VALUE = "Error CustomMessage TEST";
	
	private CustomMessageRestfullController customMessageRestfullController;

	private CustomMessageService customMessageService;
	
	private List<CustomMessage> userMessageListTest;
	
	private CustomMessage userMessageTest;
	
	private HttpServletRequest request;
	
	private MessageSource messageSource;
	
	private UriComponentsBuilder uriComponentsBuilder;
	
	@Before
	public final void setUp() throws Exception {
		userMessageTest = DummyCustomMessageDataFactory.createSampleDefault();
		userMessageListTest = DummyCustomMessageDataFactory.createSampleList();

		customMessageRestfullController = spy(new CustomMessageRestfullController());
		customMessageService = mock(CustomMessageService.class);
		
		request = mock(HttpServletRequest.class);
		messageSource = mock(MessageSource.class);
		uriComponentsBuilder = UriComponentsBuilder.newInstance();
		
		customMessageRestfullController.setCustomMessageService(customMessageService);
		
		when(customMessageService.findByPK(anyLong())).thenReturn(userMessageTest);
		when(customMessageService.findAll()).thenReturn(userMessageListTest);
		
		when(messageSource.getMessage(anyString(), any(Object[].class), anyObject())).thenReturn(MESSAGE_SOURCE_VALUE);
		
		customMessageRestfullController.setMessageSource(messageSource);
	}

	@Test
	public final void shouldFindAllNullList() {
		when(customMessageService.findAll()).thenReturn(null);
		
		final ResponseEntity<List<CustomMessage>> responseEntity = customMessageRestfullController.findAll();
		
		assertEquals(HttpStatus.NOT_FOUND,responseEntity.getStatusCode());
		assertNull(responseEntity.getBody());
	}
	
	@Test
	public final void shouldFindAllEmptyList() {
		when(customMessageService.findAll()).thenReturn(new ArrayList<CustomMessage>());
		final ResponseEntity<List<CustomMessage>> responseEntity = customMessageRestfullController.findAll();
		
		assertEquals(HttpStatus.NOT_FOUND,responseEntity.getStatusCode());
		assertNull(responseEntity.getBody());
	}
	
	@Test
	public final void shouldFindAll() {
		final ResponseEntity<List<CustomMessage>> responseEntity = customMessageRestfullController.findAll();
		
		assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
		assertEquals(userMessageListTest,responseEntity.getBody());
	}
	
	@Test
	public final void shouldFindByPKNullValue() {
		when(customMessageService.findByPK(anyLong())).thenReturn(null);
		
		final ResponseEntity<CustomMessage> responseEntity = (ResponseEntity<CustomMessage>) customMessageRestfullController.findByPk(CustomMessageConstant.TEST_USER_MESSAGE_1_ID,request);
		
		assertEquals(HttpStatus.NOT_FOUND,responseEntity.getStatusCode());
		assertNotNull(responseEntity.getBody());
	}
	
	@Test
	public final void shouldFindByPK() {	
		final ResponseEntity<CustomMessage> responseEntity = (ResponseEntity<CustomMessage>) customMessageRestfullController.findByPk(CustomMessageConstant.TEST_USER_MESSAGE_1_ID,request);
		
		assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
		assertEquals(userMessageTest,responseEntity.getBody());
	}
	
	@Test
	public final void shouldInsertExist() {
		final ResponseEntity<CustomMessage> responseEntity = (ResponseEntity<CustomMessage>) customMessageRestfullController.insert(userMessageTest,uriComponentsBuilder,request);
		
		assertEquals(HttpStatus.CONFLICT,responseEntity.getStatusCode());
		assertNotNull(responseEntity.getBody());
	}
	
	@Test
	public final void shouldInsert() {
		when(customMessageService.findByPK(anyLong())).thenReturn(null);
		userMessageTest.setId(5L);
		
		final ResponseEntity<CustomMessage> responseEntity = (ResponseEntity<CustomMessage>) customMessageRestfullController.insert(userMessageTest,uriComponentsBuilder,request);
		
		assertEquals(HttpStatus.CREATED,responseEntity.getStatusCode());
		assertNotNull(responseEntity.getHeaders());
	}
	
	@Test
	public final void shouldUpdateNotExist() {
		when(customMessageService.findByPK(anyLong())).thenReturn(null);
		
		final ResponseEntity<CustomMessage> responseEntity = (ResponseEntity<CustomMessage>) customMessageRestfullController.update(CustomMessageConstant.TEST_USER_MESSAGE_1_ID.longValue(), userMessageTest,request);
				
		assertEquals(HttpStatus.NOT_FOUND,responseEntity.getStatusCode());
		assertNotNull(responseEntity.getBody());
	}
	
	@Test
	public final void shouldUpdate() {
		final ResponseEntity<CustomMessage> responseEntity = (ResponseEntity<CustomMessage>) customMessageRestfullController.update(CustomMessageConstant.TEST_USER_MESSAGE_1_ID.longValue(), userMessageTest,request);
				
		assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
		assertNotNull(responseEntity.getBody());
	}
	
	@Test
	public final void shouldDeleteNotExist() {
		when(customMessageService.findByPK(anyLong())).thenReturn(null);
		
		final ResponseEntity<CustomMessage> responseEntity = (ResponseEntity<CustomMessage>) customMessageRestfullController.delete(CustomMessageConstant.TEST_USER_MESSAGE_1_ID.longValue(), request);
				
		assertEquals(HttpStatus.NOT_FOUND,responseEntity.getStatusCode());
		assertNotNull(responseEntity.getBody());
	}
	
	@Test
	public final void shouldDelete() {
		final ResponseEntity<CustomMessage> responseEntity = (ResponseEntity<CustomMessage>) customMessageRestfullController.delete(CustomMessageConstant.TEST_USER_MESSAGE_1_ID.longValue(), request);
				
		assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
		assertNull(responseEntity.getBody());
	}
	
}
