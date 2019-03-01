package com.acme.example.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.acme.example.common.constant.AccountConstant;
import com.acme.example.common.exception.ExampleException;
import com.acme.example.entity.Account;
import com.acme.example.factory.AccountDataFactory;
import com.acme.example.repository.AccountDao;
import com.acme.example.service.impl.AccountServiceImpl;


public class AccountServiceTest {
	
	private AccountServiceImpl service;
	
	private AccountDao accountDao;
	
	private Account AccountTest;

	@Before
	public void initTests() {
		AccountTest = AccountDataFactory.createSampleAccountDefaultWithId(AccountConstant.TEST_ID);
				
		service = new AccountServiceImpl();
		accountDao = mock(AccountDao.class);
		
		when(accountDao.findByPK(anyLong())).thenReturn(AccountTest);
		
		service.setAccountDao(accountDao);
	}
	
	@Test
	public void whenCallInsertThenInvokeTheDaoMethod() {
		service.insertAccount(AccountTest);
		verify(accountDao).insert(AccountTest);
	}
	
	@Test
	public void whenCallUpdateThenInvokeTheDaoMethod() {
		service.updateAccount(AccountTest);
		verify(accountDao).update(AccountTest);
	}
	
	@Test
	public void whenCallFindAllElementsThenInvokeTheDaoMethod() {
		service.findAllAccounts();
		verify(accountDao).findAll();
	}
	
	@Test (expected=ExampleException.class)
	public void shouldLockAccountNotFoundException() throws ExampleException {
		when(accountDao.findByPK(anyLong())).thenReturn(null);
		
		service.lockAccount(AccountConstant.TEST_ID);
	}
	
	@Test (expected=ExampleException.class)
	public void shouldLockAccountIsLockedException() throws ExampleException {
		AccountTest.setLockedDate(new Date());
		when(accountDao.findByPK(anyLong())).thenReturn(AccountTest);
		
		service.lockAccount(AccountConstant.TEST_ID);
	}
	
	@Test
	public void shouldLockAccount() throws ExampleException {
		when(accountDao.findByPK(anyLong())).thenReturn(AccountTest);
		
		service.lockAccount(AccountConstant.TEST_ID);
	}

	@Test
	public void shouldHaveAccessors() {
		assertNotNull(service.getAccountDao());
	}

}
