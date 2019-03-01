package com.acme.example.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import com.acme.example.common.constant.AccountConstant;
import com.acme.example.common.exception.ExampleException;
import com.acme.example.entity.Account;
import com.acme.example.factory.AccountDataFactory;
import com.acme.example.repository.AccountDao;
import com.acme.example.service.impl.AccountOperationServiceImpl;


public class AccountOperationServiceTest {
	
	private final double TEST_AMOUNT = 10.0;
	
	private AccountOperationServiceImpl service;
	
	private AccountDao accountDao;
	
	private Account accountTest;

	@Before
	public void initTests() {
		accountTest = AccountDataFactory.createSampleAccountDefaultWithId(AccountConstant.TEST_ID);
				
		service = new AccountOperationServiceImpl();
		accountDao = mock(AccountDao.class);
		
		when(accountDao.findByPK(anyLong())).thenReturn(accountTest);
		
		service.setAccountDao(accountDao);
	}
	
	@Test
	public void whenCallConstructor() {
		service = new AccountOperationServiceImpl(accountDao);
	}
	
	@Test (expected=ExampleException.class)
	public void shouldDepositMoneyNullAccountAccountNotFoundException() throws ExampleException {
		when(accountDao.findByPK(anyLong())).thenReturn(null);
		
		service.depositMoney(AccountConstant.TEST_ID, TEST_AMOUNT);
	}
	
	@Test (expected=ExampleException.class)
	public void shouldDepositMoneyInvalidAccountAccountNotFoundException() throws ExampleException {
		accountTest.setId(null);
		
		service.depositMoney(AccountConstant.TEST_ID, TEST_AMOUNT);
	}
	
	@Test 
	public void shouldDepositMoney() throws ExampleException {
		
		final double balance = accountTest.getBalance();
		
		service.depositMoney(AccountConstant.TEST_ID, TEST_AMOUNT);
		
		final Account result = service.getAccount(AccountConstant.TEST_ID);
		assertNotNull(result);
		assertEquals(new Double(balance+TEST_AMOUNT),new Double(result.getBalance()));
	}
	
	@Test (expected=ExampleException.class)
	public void shouldTransferMoneyNullSourceAccountAccountNotFoundException() throws ExampleException {
		when(accountDao.findByPK(anyLong())).thenReturn(null);
		
		service.transferMoney(AccountConstant.TEST_COUNT_1_ID, AccountConstant.TEST_COUNT_2_ID, TEST_AMOUNT);
	}
	
	@Test (expected=ExampleException.class)
	public void shouldTransferMoneyNullTargetAccountAccountNotFoundException() throws ExampleException {
		when(accountDao.findByPK(anyLong())).thenReturn(accountTest);
		when(accountDao.findByPK(anyLong())).thenReturn(null);
		
		service.transferMoney(AccountConstant.TEST_COUNT_1_ID, AccountConstant.TEST_COUNT_2_ID, TEST_AMOUNT);
	}
	
	@Test
	public void shouldTransferMoneyAccount() throws ExampleException {
		when(accountDao.findByPK(anyLong())).thenReturn(accountTest);
		when(accountDao.findByPK(anyLong())).thenReturn(accountTest);
		
		service.transferMoney(AccountConstant.TEST_COUNT_1_ID, AccountConstant.TEST_COUNT_2_ID, TEST_AMOUNT);
	}
	
	@Test
	public void whenCallGetAccountThenInvokeTheDaoMethod() {
		service.getAccount(AccountConstant.TEST_ID);
		verify(accountDao).findByPK(AccountConstant.TEST_ID);
	}
	
}
