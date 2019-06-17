package com.acme.example.custom.message.api.restful.exception;

import com.acme.architecture.testing.exception.test.AbstractExceptionTest;

public class CustomMessageRestfulExceptionTest extends AbstractExceptionTest {

	@Override
	protected Exception getExceptionWithParameter() {
		return new CustomMessageRestfulException("1");
	}

}
