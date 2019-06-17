package com.acme.example.custom.message.core.factory;
import java.util.Date;

import com.acme.example.custom.message.core.entity.CustomMessage;

public final class CustomMessageDataFactory {

	public static CustomMessage create(String description, boolean vip) {
		final CustomMessage userMessage = new CustomMessage();
		userMessage.setDescription(description);
		userMessage.setVip(vip);
		userMessage.setCreationDate(new Date());
		userMessage.setDeletedDate(null);
		return userMessage;
	}
	
	public static CustomMessage create(long id, String description, boolean vip) {
		final CustomMessage userMessage = create(description,vip);
		userMessage.setId(id);
		return userMessage;
	}
	
	

}
