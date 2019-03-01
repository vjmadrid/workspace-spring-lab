package com.acme.example.custom.message.factory.dummy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.acme.example.custom.message.constant.CustomMessageConstant;
import com.acme.example.custom.message.entity.CustomMessage;
import com.acme.example.custom.message.factory.CustomMessageDataFactory;

public final class DummyCustomMessageDataFactory {

	public static CustomMessage createSampleDefault() {
		return CustomMessageDataFactory.create(CustomMessageConstant.TEST_USER_MESSAGE_1_ID,CustomMessageConstant.TEST_USER_MESSAGE_1_DESCRIPTION, CustomMessageConstant.TEST_USER_MESSAGE_1_VIP);
	}
	
	public static Map<Long,CustomMessage> createSampleMap() {
		final Map<Long,CustomMessage> map = new HashMap<>(); 
		map.put(CustomMessageConstant.TEST_USER_MESSAGE_1_ID, CustomMessageDataFactory.create(CustomMessageConstant.TEST_USER_MESSAGE_1_ID,CustomMessageConstant.TEST_USER_MESSAGE_1_DESCRIPTION, CustomMessageConstant.TEST_USER_MESSAGE_1_VIP));
		map.put(CustomMessageConstant.TEST_USER_MESSAGE_2_ID, CustomMessageDataFactory.create(CustomMessageConstant.TEST_USER_MESSAGE_2_ID,CustomMessageConstant.TEST_USER_MESSAGE_2_DESCRIPTION, CustomMessageConstant.TEST_USER_MESSAGE_2_VIP));
		map.put(CustomMessageConstant.TEST_USER_MESSAGE_3_ID, CustomMessageDataFactory.create(CustomMessageConstant.TEST_USER_MESSAGE_3_ID,CustomMessageConstant.TEST_USER_MESSAGE_3_DESCRIPTION, CustomMessageConstant.TEST_USER_MESSAGE_3_VIP));		
		map.put(CustomMessageConstant.TEST_USER_MESSAGE_4_ID, CustomMessageDataFactory.create(CustomMessageConstant.TEST_USER_MESSAGE_4_ID,CustomMessageConstant.TEST_USER_MESSAGE_4_DESCRIPTION, CustomMessageConstant.TEST_USER_MESSAGE_4_VIP));
		return map;
	}
	
	public static List<CustomMessage> createSampleList() {
		final List<CustomMessage> list = new ArrayList<>();
		list.add(CustomMessageDataFactory.create(CustomMessageConstant.TEST_USER_MESSAGE_1_ID,CustomMessageConstant.TEST_USER_MESSAGE_1_DESCRIPTION, CustomMessageConstant.TEST_USER_MESSAGE_1_VIP));
		list.add(CustomMessageDataFactory.create(CustomMessageConstant.TEST_USER_MESSAGE_2_ID,CustomMessageConstant.TEST_USER_MESSAGE_2_DESCRIPTION, CustomMessageConstant.TEST_USER_MESSAGE_2_VIP));
		list.add(CustomMessageDataFactory.create(CustomMessageConstant.TEST_USER_MESSAGE_3_ID,CustomMessageConstant.TEST_USER_MESSAGE_3_DESCRIPTION, CustomMessageConstant.TEST_USER_MESSAGE_3_VIP));
		list.add(CustomMessageDataFactory.create(CustomMessageConstant.TEST_USER_MESSAGE_4_ID,CustomMessageConstant.TEST_USER_MESSAGE_4_DESCRIPTION, CustomMessageConstant.TEST_USER_MESSAGE_4_VIP));
		return list;
	}
	
}
