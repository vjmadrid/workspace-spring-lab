package com.acme.example.custom.message.core.exception;

import com.acme.architecture.testing.exception.test.AbstractExceptionTest;
import com.acme.example.custom.message.core.exception.CustomMessageException;

public class AppCustomMessageExceptionTest extends AbstractExceptionTest {

	@Override
	protected Exception getExceptionWithParameter() {
		return new CustomMessageException("1");
	}

}
