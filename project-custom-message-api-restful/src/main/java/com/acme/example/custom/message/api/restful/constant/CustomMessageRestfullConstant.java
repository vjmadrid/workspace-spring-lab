package com.acme.example.custom.message.api.restful.constant;

public final class CustomMessageRestfullConstant {

	private CustomMessageRestfullConstant() {
	}
	
	public static final String MAPPING = "/api/custommessages";	
	public static final String MAPPING_PK = "/{id}";
	
	public static final String MESSAGE_NOT_FOUND = "custommessage.validation.error.NOT_FOUND";
	public static final String MESSAGE_EXIST = "custommessage.validation.error.EXIST";
	
}
