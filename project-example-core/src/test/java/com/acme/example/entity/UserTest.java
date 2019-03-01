package com.acme.example.entity;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.acme.example.common.constant.UserConstant;
import com.acme.example.factory.UserDataFactory;

public class UserTest {
	
	private User user;

	private User anotherUser;

	private User cloneUser;
	
	@Before
	public void init() {
		user = UserDataFactory.createSampleUserDefault();
		cloneUser =  UserDataFactory.createSampleUserDefault();
		anotherUser = UserDataFactory.createSampleUserDefault();
		anotherUser.setId(2L);
	}
	
	@Test
	public void equalsMethodCheckTheType() {
		assertFalse(user.equals("a string"));
	}

	@Test
	public void equalsMehtodCheckSameObject() throws Exception {
		assertTrue(user.equals(user));
	}
	
	@Test
	public void equalsMehtodCheckIdField() throws Exception {
		assertFalse(user.equals(anotherUser));
	}

	@Test
	public void equalsMehtodCheckIdFieldEquals() throws Exception {
		assertTrue(user.equals(cloneUser));
	}

	@Test
	public void hashproductMethodBasedInTheIDField() throws Exception {
		assertNotSame(user.hashCode(), anotherUser.hashCode());
	}

	@Test
	public void shouldHaveADescriptiveToStringMethod() {
		assertNotSame(-1, user.toString().indexOf(User.class.getSimpleName()));
		assertNotSame(-1,
				user.toString().indexOf("id=".concat(UserConstant.TEST_ID.toString())));
	}

	@Test
	public void shouldHasMethodAccessors() {
		assertNotNull(user.getId());
		assertNotNull(user.getName());
		assertNotNull(user.getPassword());
	}

}
