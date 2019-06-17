package com.acme.example.custom.message.api.restful.exception;

import com.acme.architecture.common.constant.GlobalConstant;
import com.acme.architecture.common.exception.AcmeException;

public class CustomMessageRestfulException extends AcmeException {

	private static final long serialVersionUID = -5333357611767101717L;

	public CustomMessageRestfulException(String header) {
		this(header, GlobalConstant.EMPTY_STRING);
	}
	
	public CustomMessageRestfulException(String header, String message) {
		super(new StringBuilder(header).append(message).toString());
	}

}
