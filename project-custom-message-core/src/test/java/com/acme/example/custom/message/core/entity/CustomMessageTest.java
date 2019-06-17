package com.acme.example.custom.message.core.entity;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.acme.example.custom.message.core.constant.CustomMessageConstant;
import com.acme.example.custom.message.core.entity.CustomMessage;
import com.acme.example.custom.message.core.factory.dummy.DummyCustomMessageDataFactory;

public class CustomMessageTest {
	
	private CustomMessage userMessage;

	private CustomMessage anotherUserMessage;

	private CustomMessage cloneUserMessage;
	
	@Before
	public void init() {
		userMessage = DummyCustomMessageDataFactory.createSampleDefault();
		cloneUserMessage =  DummyCustomMessageDataFactory.createSampleDefault();
		anotherUserMessage = DummyCustomMessageDataFactory.createSampleDefault();
		anotherUserMessage.setId(2L);
	}
	
	@Test
	public void equalsMethodCheckTheType() {
		assertFalse(userMessage.equals("a string"));
	}

	@Test
	public void equalsMehtodCheckSameObject() throws Exception {
		assertTrue(userMessage.equals(userMessage));
	}
	
	@Test
	public void equalsMehtodCheckIdField() throws Exception {
		assertFalse(userMessage.equals(anotherUserMessage));
	}

	@Test
	public void equalsMehtodCheckIdFieldEquals() throws Exception {
		assertTrue(userMessage.equals(cloneUserMessage));
	}

	@Test
	public void hashproductMethodBasedInTheIDField() throws Exception {
		assertNotSame(userMessage.hashCode(), anotherUserMessage.hashCode());
	}

		
	@Test
	public void shouldHaveADescriptiveToStringMethod() {
		assertNotSame(-1, userMessage.toString().indexOf(CustomMessage.class.getSimpleName()));
		//assertNotSame(-1,
		//		userMessage.toString().indexOf("id=".concat(UserMessageConstant.TEST_USER_MESSAGE_1_ID.toString())));
	}

	@Test
	public void shouldHasMethodAccessors() {
		assertNotNull(userMessage.getId());
		assertNotNull(userMessage.getDescription());
		assertNotNull(userMessage.isVip());
		assertNotNull(userMessage.getCreationDate());
		assertNull(userMessage.getDeletedDate());
	}

}
