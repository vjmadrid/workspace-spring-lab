package com.acme.example.custom.message.core.service;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import com.acme.example.custom.message.core.entity.CustomMessage;
import com.acme.example.custom.message.core.factory.dummy.DummyCustomMessageDataFactory;
import com.acme.example.custom.message.core.repository.CustomMessageRepository;
import com.acme.example.custom.message.core.service.impl.CustomMessageServiceImpl;


public class CustomMessageServiceTest {
	
	private CustomMessageServiceImpl customMessageService;
	
	private CustomMessageRepository customMessageRepository;
	
	private CustomMessage customMessageTest;

	@Before
	public void init() {
		customMessageTest = DummyCustomMessageDataFactory.createSampleDefault();
				
		customMessageService = new CustomMessageServiceImpl();
		customMessageRepository = mock(CustomMessageRepository.class);
		
		when(customMessageRepository.findAll()).thenReturn(DummyCustomMessageDataFactory.createSampleList());
		
		when(customMessageRepository.findByPK(anyLong())).thenReturn(customMessageTest);
		
		customMessageService.setCustomMessageRepository(customMessageRepository);
	}
	
	@Test
	public void whenCallFindAllElementsThenInvokeTheDaoMethod() {
		customMessageService.findAll();
		verify(customMessageRepository).findAll();
	}
	
	@Test
	public void whenCallFindThenInvokeTheDaoMethod() {
		customMessageService.findByPK(customMessageTest.getId());
		verify(customMessageRepository).findByPK(customMessageTest.getId());
	}
	
	@Test
	public void whenCallInsertThenInvokeTheDaoMethod() {
		customMessageService.insert(customMessageTest);
		verify(customMessageRepository).insert(customMessageTest);
	}
		
	@Test
	public void whenCallUpdateThenInvokeTheDaoMethod() {
		customMessageService.update(customMessageTest);
		verify(customMessageRepository).update(customMessageTest);
	}

	@Test
	public void whenCallRemoveThenInvokeTheDaoMethod() {
		customMessageService.delete(customMessageTest);
		//verify(userMessageRepository).delete(userMessageTest);
	}

}
