package com.acme.example.common.exception;

import com.acme.architecture.testing.exception.test.AbstractExceptionTest;
import com.acme.example.common.exception.ExampleException;


public class ExampleExceptionTest extends AbstractExceptionTest {

	@Override
	protected Exception getExceptionWithParameter() {
		return new ExampleException("1");
	}

}
