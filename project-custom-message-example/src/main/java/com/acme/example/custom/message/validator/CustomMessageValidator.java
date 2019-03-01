package com.acme.example.custom.message.validator;

import com.acme.example.custom.message.entity.CustomMessage;

public enum CustomMessageValidator {

	INSTANCE;

	public boolean isNull(CustomMessage userMessage) {
		return (userMessage == null);
	}

	public boolean isNotNull(CustomMessage userMessage) {
		return (userMessage != null);
	}

	public boolean isValid(CustomMessage userMessage) {
		return (isNotNull(userMessage) && userMessage.getId() != null);
	}
	
	public boolean isValidVip(CustomMessage userMessage) {
		return (isValid(userMessage) && userMessage.isVip());
	}
	
	public boolean isDeletedLogical(CustomMessage userMessage) {
		return (isValid(userMessage) && (userMessage.getDeletedDate()!=null));
	}
}
