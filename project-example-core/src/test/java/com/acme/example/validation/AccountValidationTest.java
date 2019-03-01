package com.acme.example.validation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.acme.architecture.testing.util.JUnitTestBuilder;
import com.acme.example.entity.Account;
import com.acme.example.factory.AccountDataFactory;

public class AccountValidationTest {

	private Account accountTest;

	@Before
	public void init() {
		accountTest = AccountDataFactory.createSampleAccountDefaultWithId(1L);
	}

	@Test
	public void shouldIsNull() {
		assertTrue(AccountValidation.INSTANCE.isNull(null));
	}

	@Test
	public void shouldIsNullWithProductNotNull() {
		assertFalse(AccountValidation.INSTANCE.isNull(accountTest));
	}

	@Test
	public void shouldIsNotNull() {
		assertTrue(AccountValidation.INSTANCE.isNotNull(accountTest));
	}

	@Test
	public void shouldIsNotNullWithProductNull() {
		assertFalse(AccountValidation.INSTANCE.isNotNull(null));
	}

	@Test
	public void shouldIsValidWithProductNull() {
		assertFalse(AccountValidation.INSTANCE.isValid(null));
	}

	@Test
	public void shouldIsValidWithIdProductNull() {
		accountTest.setId(null);
		assertFalse(AccountValidation.INSTANCE.isValid(accountTest));
	}

	@Test
	public void shouldIsValid() {
		assertTrue(AccountValidation.INSTANCE.isValid(accountTest));
	}
	
	@Test
	public void shouldIsLockedWithProductNull() {
		assertFalse(AccountValidation.INSTANCE.isLocked(null));
	}
	
	@Test
	public void shouldIsLockedWithProductNoLocked() {
		assertFalse(AccountValidation.INSTANCE.isLocked(accountTest));
	}
	
	@Test
	public void shouldIsLocked() {
		accountTest.setLockedDate(new Date());
		assertTrue(AccountValidation.INSTANCE.isLocked(accountTest));
	}
	
	@Test
	public void checkValueOfValidationUtils() throws IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {
		JUnitTestBuilder.superficialEnumCodeCoverage(AccountValidation.class);
	}

}