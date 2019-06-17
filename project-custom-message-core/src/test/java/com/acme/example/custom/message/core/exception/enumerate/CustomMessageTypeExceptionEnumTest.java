package com.acme.example.custom.message.core.exception.enumerate;

import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

import com.acme.architecture.testing.util.JUnitTestBuilder;
import com.acme.example.custom.message.core.exception.enumerate.CustomMessageTypeExceptionEnum;

public class CustomMessageTypeExceptionEnumTest {

	@Test
	public void checkValueOfEnum() throws IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {
		JUnitTestBuilder.superficialEnumCodeCoverage(CustomMessageTypeExceptionEnum.class);
	}

}
