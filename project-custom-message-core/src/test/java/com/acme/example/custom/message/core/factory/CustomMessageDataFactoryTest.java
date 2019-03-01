package com.acme.example.custom.message.factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.acme.example.custom.message.constant.CustomMessageConstant;
import com.acme.example.custom.message.entity.CustomMessage;
import com.acme.example.custom.message.factory.CustomMessageDataFactory;

public class CustomMessageDataFactoryTest {

	@Before
	public void init() {
	}

	@Test
	public void shouldCreate() {
		CustomMessage result = CustomMessageDataFactory.create(CustomMessageConstant.TEST_USER_MESSAGE_1_ID,CustomMessageConstant.TEST_USER_MESSAGE_1_DESCRIPTION, CustomMessageConstant.TEST_USER_MESSAGE_1_VIP);
		
		assertNotNull(result);
		assertEquals(CustomMessageConstant.TEST_USER_MESSAGE_1_ID,result.getId());
		assertEquals(CustomMessageConstant.TEST_USER_MESSAGE_1_DESCRIPTION,result.getDescription());
		assertFalse(result.isVip());
		assertNotNull(result.getCreationDate());
	}
	
	@Test
	public void shouldCreateDefaultConstructor() {
		assertNotNull(new CustomMessageDataFactory());
	}

}