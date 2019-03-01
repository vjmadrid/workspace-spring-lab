package com.acme.example.custom.message.exception;

import com.acme.architecture.testing.exception.test.AbstractExceptionTest;

public class AppCustomMessageExceptionTest extends AbstractExceptionTest {

	@Override
	protected Exception getExceptionWithParameter() {
		return new CustomMessageException("1");
	}

}
