package com.acme.example.factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.acme.example.common.constant.AccountConstant;
import com.acme.example.entity.Account;

public class AccountDataFactoryTest {

	private final int NUM_ELEMENTS = 3;

	@Before
	public void init() {
	}

	@Test
	public void shouldCreateAccount1() {
		assertNotNull(AccountDataFactory.createAccount1());
	}
	
	@Test
	public void shouldCreateAccount2() {
		assertNotNull(new AccountDataFactory().createAccount2());
	}
	
	@Test
	public void shouldCreateSampleAccountDefaultWithId() {
		assertNotNull(AccountDataFactory.createSampleAccountDefaultWithId(1L));
	}
	
	@Test
	public void shouldCreateSampleAccountWithId() {
		assertNotNull(AccountDataFactory.createSampleAccountWithId(AccountConstant.TEST_COUNT_1_ID, AccountConstant.TEST_COUNT_1_OWNER, AccountConstant.TEST_COUNT_1_BALANCE));
	}


	@Test
	public void shouldCreateSampleAccountMap() {
		Map<Long, Account> result = AccountDataFactory.createSampleAccountMap();
		
		assertNotNull(result);
		assertEquals(NUM_ELEMENTS,result.size());
	}
	
	@Test
	public void shouldCreateSampleAccountList() {
		List<Account> result = AccountDataFactory.createSampleAccountList();
		
		assertNotNull(result);
		assertEquals(NUM_ELEMENTS,result.size());
	}

}