package com.acme.example.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import com.acme.example.entity.User;
import com.acme.example.factory.UserDataFactory;
import com.acme.example.repository.UserDao;
import com.acme.example.service.impl.UserServiceImpl;


public class UserServiceTest {
	
	private UserServiceImpl service;
	
	private UserDao userDao;
	
	private User userTest;

	@Before
	public void initTests() {
		userTest = UserDataFactory.createSampleUserDefault();
				
		service = new UserServiceImpl();
		userDao = mock(UserDao.class);
		
		when(userDao.findByPK(anyLong())).thenReturn(userTest);
		
		service.setUserDao(userDao);
	}
	
	@Test
	public void whenCallInsertThenInvokeTheDaoMethod() {
		service.saveUser(userTest);
		verify(userDao).update(userTest);
	}
	
	@Test
	public void whenCallUpdateThenInvokeTheDaoMethod() {
		service.updateUser(userTest);
		verify(userDao).update(userTest);
	}
	
	@Test
	public void whenCallFindAllElementsThenInvokeTheDaoMethod() {
		service.findAllUsers();
		verify(userDao).findAll();
	}
	
	@Test
	public void whenCallFindThenInvokeTheDaoMethod() {
		service.findUser(userTest.getId());
		verify(userDao).findByPK(userTest.getId());
	}
	
	@Test
	public void whenCallRemoveThenInvokeTheDaoMethod() {
		service.deleteUser(userTest);
		verify(userDao).remove(userTest);
	}

	@Test
	public void shouldHaveAccessors() {
		assertNotNull(service.getUserDao());
	}

}
