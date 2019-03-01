package com.acme.example.common.exception.enumerate;

import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

import com.acme.architecture.testing.util.JUnitTestBuilder;
import com.acme.example.common.exception.enumerate.AccountTypeExceptionEnum;

public class AccountTypeExceptionEnumTest {

	@Test
	public void checkValueOfEnum() throws IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {
		JUnitTestBuilder.superficialEnumCodeCoverage(AccountTypeExceptionEnum.class);
	}

}
