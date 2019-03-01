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
import com.acme.example.common.constant.AccountConstant;
import com.acme.example.entity.Account;
import com.acme.example.factory.AccountDataFactory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( { "classpath:spring-configuration/*.xml"})
public class AccountDaoTest {

	private int NUM_ELEMENTS = 3;
	
	@Resource
	@Qualifier ("accountDaoInMemory")
	AccountDao accountDao;
	
	private Account accountTest;
	
	@Before
	public void init() {
		accountTest = AccountDataFactory.createSampleAccountDefaultWithId(AccountConstant.TEST_ID);
	}

	@Test
	public void shouldRetrieveAllAccounts() {
		final List<Account> resultList = accountDao.findAll();
		
		assertNotNull(resultList);
		assertEquals(Integer.valueOf(NUM_ELEMENTS), Integer.valueOf(resultList.size()));
	}
	
	@Test
	public void shouldRetrieveAccountsFindByQuery() {
		final List<Account> resultList = accountDao.findByQuery(GlobalConstant.EMPTY_STRING);
		
		assertNotNull(resultList);
		assertEquals(Integer.valueOf(NUM_ELEMENTS), Integer.valueOf(resultList.size()));
	}

	@Test
	public void shouldRetrieveAccountsFindByQueryParameters() {
		final List<Account> resultList = accountDao.findByQueryParameters(GlobalConstant.EMPTY_STRING,null);
		
		assertNotNull(resultList);
		assertEquals(Integer.valueOf(NUM_ELEMENTS), Integer.valueOf(resultList.size()));
	}
	
	@Test
	public void shouldRetrieveAccountById() {
		final Account result = accountDao.findByPK(AccountConstant.TEST_ID);
		
		assertNotNull(result);
		assertEquals(AccountConstant.TEST_ID, result.getId());
	}
	
	@Test
	public void shouldInsertAccount() { 
		final Long newID = Long.valueOf((NUM_ELEMENTS+1));
	
		accountTest.setId(newID);
		accountDao.insert(accountTest);
		
		final Account result = accountDao.findByPK(newID);
		assertNotNull(result);
		assertEquals(newID, result.getId());	
		
		accountDao.remove(result);
	}
	
	@Test
	public void shouldUpdateAccount() {
		final Account origin = accountDao.findByPK(AccountConstant.TEST_ID);
		origin.setCreationDate(null);
		
		accountDao.update(origin);
		
		final Account result = accountDao.findByPK(AccountConstant.TEST_ID);
		assertNotNull(result);
		assertNull(result.getCreationDate());
	}
	
	@Test
	public void shouldDeleteAccount() {
		final Account origin = accountDao.findByPK(AccountConstant.TEST_ID);

		accountDao.remove(origin);
		
		final Account deleted = accountDao.findByPK(AccountConstant.TEST_ID);
		assertNull(deleted);
	}
	
	
}