package com.acme.example.custom.message.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.acme.architecture.testing.util.JUnitTestBuilder;
import com.acme.example.custom.message.entity.CustomMessage;
import com.acme.example.custom.message.factory.dummy.DummyCustomMessageDataFactory;

public class CustomMessageValidatorTest {

	private CustomMessage userMessageTest;

	@Before
	public void init() {
		userMessageTest = DummyCustomMessageDataFactory.createSampleDefault();
	}

	@Test
	public void shouldIsNull() {
		assertTrue(CustomMessageValidator.INSTANCE.isNull(null));
	}

	@Test
	public void shouldIsNullWithUserMessageNotNull() {
		assertFalse(CustomMessageValidator.INSTANCE.isNull(userMessageTest));
	}

	@Test
	public void shouldIsNotNull() {
		assertTrue(CustomMessageValidator.INSTANCE.isNotNull(userMessageTest));
	}

	@Test
	public void shouldIsNotNullWithUserMessageNull() {
		assertFalse(CustomMessageValidator.INSTANCE.isNotNull(null));
	}

	@Test
	public void shouldIsValidWithUserMessageNull() {
		assertFalse(CustomMessageValidator.INSTANCE.isValid(null));
	}

	@Test
	public void shouldIsValidWithIdUserMessageNull() {
		userMessageTest.setId(null);
		assertFalse(CustomMessageValidator.INSTANCE.isValid(userMessageTest));
	}

	@Test
	public void shouldIsValid() {
		assertTrue(CustomMessageValidator.INSTANCE.isValid(userMessageTest));
	}
	
	@Test
	public void shouldIsValidVipWithUserMessageNull() {
		assertFalse(CustomMessageValidator.INSTANCE.isValidVip(null));
	}
	
	@Test
	public void shouldIsValidVipWithIdUserMessageNull() {
		userMessageTest.setId(null);
		assertFalse(CustomMessageValidator.INSTANCE.isValidVip(userMessageTest));
	}

	@Test
	public void shouldIsValidVipNoValidValue() {
		assertFalse(CustomMessageValidator.INSTANCE.isValidVip(userMessageTest));
	}
	
	@Test
	public void shouldIsValidVip() {
		userMessageTest.setVip(true);
		assertTrue(CustomMessageValidator.INSTANCE.isValidVip(userMessageTest));
	}
	
	@Test
	public void shouldIsDeletedLogicalVipWithIdUserMessageNull() {
		userMessageTest.setId(null);
		assertFalse(CustomMessageValidator.INSTANCE.isDeletedLogical(userMessageTest));
	}
	
	@Test
	public void shouldIsDeletedLogicalVipNoValidValue() {
		assertFalse(CustomMessageValidator.INSTANCE.isDeletedLogical(userMessageTest));
	}
	
	@Test
	public void shouldUsDeletedLogical() {
		userMessageTest.setDeletedDate(new Date());
		assertTrue(CustomMessageValidator.INSTANCE.isDeletedLogical(userMessageTest));
	}
	
	@Test
	public void checkValueOfValidationUtils() throws IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {
		JUnitTestBuilder.superficialEnumCodeCoverage(CustomMessageValidator.class);
	}

}