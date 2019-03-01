package com.acme.example.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.acme.architecture.common.constant.GlobalConstant;
import com.acme.example.common.constant.UserConstant;
import com.acme.example.entity.User;
import com.acme.example.factory.UserDataFactory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( { "classpath:spring-configuration/*.xml"})
public class UserDaoTest {

	private int NUM_ELEMENTS = 2;
	
	@Resource
	@Qualifier ("userDaoInMemory")
	UserDao userDao;
	
	private User userTest;
	
	@Before
	public void init() {
		userTest = UserDataFactory.createSampleUserDefault();
	}

	@Test
	public void shouldRetrieveAllUsers() {
		final List<User> resultList = userDao.findAll();
		
		assertNotNull(resultList);
		assertEquals(Integer.valueOf(NUM_ELEMENTS), Integer.valueOf(resultList.size()));
	}
	
	@Test
	public void shouldRetrieveUsersFindByQuery() {
		final List<User> resultList = userDao.findByQuery(GlobalConstant.EMPTY_STRING);
		
		assertNotNull(resultList);
		assertEquals(Integer.valueOf(NUM_ELEMENTS), Integer.valueOf(resultList.size()));
	}

	@Test
	public void shouldRetrieveUsersFindByQueryParameters() {
		final List<User> resultList = userDao.findByQueryParameters(GlobalConstant.EMPTY_STRING,null);
		
		assertNotNull(resultList);
		assertEquals(Integer.valueOf(NUM_ELEMENTS), Integer.valueOf(resultList.size()));
	}
	
	@Test
	public void shouldRetrieveUserById() {
		final User result = userDao.findByPK(UserConstant.TEST_USER_1_ID);
		
		assertNotNull(result);
		assertEquals(UserConstant.TEST_USER_1_ID, result.getId());
	}
	
	@Test
	public void shouldInsertUser() {
		final Long newID = Long.valueOf((NUM_ELEMENTS+1));
		
		userTest.setId(newID);
		userTest.setName(UserConstant.TEST_USERNAME);
		
		userDao.insert(userTest);
		
		final User result = userDao.findByPK(newID);
		assertNotNull(result);
		assertEquals(UserConstant.TEST_USERNAME, result.getName());	
		
		userDao.remove(result);
	}
	
	@Test
	public void shouldUpdateUser() {
		final User origin = userDao.findByPK(UserConstant.TEST_USER_1_ID);
		origin.setPassword(null);
		
		userDao.update(origin);
		
		final User result = userDao.findByPK(UserConstant.TEST_USER_1_ID);
		assertNotNull(result);
		assertNull(result.getPassword());
	}
	
	@Test
	public void shouldDeleteAccount() {
		final User origin = userDao.findByPK(UserConstant.TEST_USER_1_ID);

		userDao.remove(origin);
		
		final User deleted = userDao.findByPK(UserConstant.TEST_USER_1_ID);
		assertNull(deleted);
	}
	
}