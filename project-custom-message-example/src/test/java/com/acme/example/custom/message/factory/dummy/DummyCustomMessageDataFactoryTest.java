package com.acme.example.custom.message.factory.dummy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.acme.example.custom.message.constant.CustomMessageConstant;
import com.acme.example.custom.message.entity.CustomMessage;
import com.acme.example.custom.message.factory.dummy.DummyCustomMessageDataFactory;

public class DummyCustomMessageDataFactoryTest {

	@Before
	public void init() {
	}

	@Test
	public void shouldCreateSampleDefault() {
		assertNotNull(DummyCustomMessageDataFactory.createSampleDefault());
	}

	@Test
	public void shouldCreateSampleUserMap() {
		Map<Long, CustomMessage> result = DummyCustomMessageDataFactory.createSampleMap();
		
		assertNotNull(result);
		assertEquals(CustomMessageConstant.TEST_NUM_MESSAGES,result.size());
	}
	
	@Test
	public void shouldCreateSampleUserList() {
		List<CustomMessage> result = DummyCustomMessageDataFactory.createSampleList();
		
		assertNotNull(result);
		assertEquals(CustomMessageConstant.TEST_NUM_MESSAGES,result.size());
	}
	
	@Test
	public void shouldCreateDefaultConstructor() {
		assertNotNull(new DummyCustomMessageDataFactory());
	}

}