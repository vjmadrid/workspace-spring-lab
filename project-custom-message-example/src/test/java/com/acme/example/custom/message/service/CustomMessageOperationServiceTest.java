package com.acme.example.custom.message.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.acme.example.custom.message.constant.CustomMessageConstant;
import com.acme.example.custom.message.entity.CustomMessage;
import com.acme.example.custom.message.exception.CustomMessageException;
import com.acme.example.custom.message.exception.enumerate.CustomMessageTypeExceptionEnum;
import com.acme.example.custom.message.factory.dummy.DummyCustomMessageDataFactory;
import com.acme.example.custom.message.repository.CustomMessageRepository;
import com.acme.example.custom.message.service.impl.CustomMessageOperationServiceImpl;

public class CustomMessageOperationServiceTest {
	
	private int NUM_ELEMENTS_DELETED_LOGICAL = 1;

	private CustomMessageOperationServiceImpl customMessageOperationService;

	private CustomMessageRepository customMessageRepository;

	private CustomMessage customMessageTest;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Before
	public void init() {
		customMessageTest = DummyCustomMessageDataFactory.createSampleDefault();

		customMessageOperationService = new CustomMessageOperationServiceImpl();
		customMessageRepository = mock(CustomMessageRepository.class);

		List<CustomMessage> listAll = DummyCustomMessageDataFactory.createSampleList();
		listAll.get(3).setDeletedDate(new Date());
	
		when(customMessageRepository.findAll()).thenReturn(listAll);

		when(customMessageRepository.findByPK(anyLong())).thenReturn(customMessageTest);

		customMessageOperationService.setCustomMessageRepository(customMessageRepository);
	}

	@Test
	public void shouldFindAllVips() {
		List<CustomMessage> resultList = customMessageOperationService.findAllVips();

		assertNotNull(resultList);
		assertEquals(Integer.valueOf(NUM_ELEMENTS_DELETED_LOGICAL), Integer.valueOf(resultList.size()));
	}

	@Test
	public void shouldDeleteLogicalNullCustomMessageNotFoundException() throws CustomMessageException {
		thrown.expect(CustomMessageException.class);
		thrown.expectMessage(CustomMessageTypeExceptionEnum.NOT_FOUND.name());

		when(customMessageRepository.findByPK(anyLong())).thenReturn(null);

		customMessageOperationService.deleteLogical(CustomMessageConstant.TEST_USER_MESSAGE_1_ID);
	}
	
	@Test
	public void shouldDeleteLogicalCustomMessageIsDeleteLogicalException() throws CustomMessageException {
		thrown.expect(CustomMessageException.class);
		thrown.expectMessage(CustomMessageTypeExceptionEnum.IS_DELETED_LOGICAL.name());

		customMessageTest.setDeletedDate(new Date());
		
		customMessageOperationService.deleteLogical(CustomMessageConstant.TEST_USER_MESSAGE_1_ID);
	}

	@Test
	public void shouldDeleteLogical() throws CustomMessageException {
		assertNull(customMessageTest.getDeletedDate());

		customMessageOperationService.deleteLogical(CustomMessageConstant.TEST_USER_MESSAGE_1_ID);
		
		verify(customMessageRepository).update(customMessageTest);
	}
	
	public void setCustomMessageRepository(CustomMessageRepository customMessageRepository) {
		this.customMessageRepository = customMessageRepository;
	}

}
