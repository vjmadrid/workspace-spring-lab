package com.acme.example.custom.message.exception;

import com.acme.architecture.common.constant.GlobalConstant;
import com.acme.architecture.common.exception.AcmeException;

public class CustomMessageException extends AcmeException {

	private static final long serialVersionUID = 6244393233046079922L;

	public CustomMessageException(String header) {
		this(header, GlobalConstant.EMPTY_STRING);
	}
	
	public CustomMessageException(String header, String message) {
		super(new StringBuilder(header).append(message).toString());
	}

}
