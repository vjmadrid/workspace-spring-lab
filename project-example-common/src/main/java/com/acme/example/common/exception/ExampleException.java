package com.acme.example.common.exception;

import com.acme.architecture.common.constant.GlobalConstant;
import com.acme.architecture.common.exception.AcmeException;

public class ExampleException extends AcmeException {

	private static final long serialVersionUID = -3796983016895858667L;

	public ExampleException(String header) {
		this(header, GlobalConstant.EMPTY_STRING);
	}
	
	public ExampleException(String header, String message) {
		super(new StringBuilder(header).append(message).append(GlobalConstant.PHRASE_END).toString());
	}

}
