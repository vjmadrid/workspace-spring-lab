package com.acme.example.factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.acme.example.common.constant.UserConstant;
import com.acme.example.entity.User;

public class UserDataFactoryTest {

	private final int NUM_ELEMENTS = 2;

	@Before
	public void init() {
	}

	@Test
	public void shouldCreateSampleUser() {
		assertNotNull(UserDataFactory.createSampleUserWithId(UserConstant.TEST_ID,UserConstant.TEST_USERNAME, UserConstant.TEST_PASSWORD));
	}
	
	@Test
	public void shouldCreateSampleUserDefault() {
		assertNotNull(UserDataFactory.createSampleUserDefault());
	}

	@Test
	public void shouldCreateSampleUserMap() {
		Map<Long, User> result = UserDataFactory.createSampleUserMap();
		
		assertNotNull(result);
		assertEquals(NUM_ELEMENTS,result.size());
	}
	
	@Test
	public void shouldCreateSampleUserList() {
		List<User> result = UserDataFactory.createSampleUserList();
		
		assertNotNull(result);
		assertEquals(NUM_ELEMENTS,result.size());
	}

}