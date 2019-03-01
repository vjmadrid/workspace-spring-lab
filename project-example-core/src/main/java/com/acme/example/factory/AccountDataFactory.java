package com.acme.example.factory;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.acme.example.common.constant.AccountConstant;
import com.acme.example.common.enumerate.AccountTypeEnum;
import com.acme.example.entity.Account;

public final class AccountDataFactory {

	public static Account createSampleAccountWithId(long id, String owner, double balance) {
		final Account account = new Account();
		account.setId(id);
		account.setOwner(owner);
		account.setBalance(balance);
		account.setAccountType(AccountTypeEnum.BASIC);
		account.setLocked(Boolean.FALSE);
		account.setCreationDate(new Date());
		account.setAccessDate(null);
		account.setLockedDate(null);
		return account;
	}
	
	public static Account createAccount1() {
		return createSampleAccountWithId(AccountConstant.TEST_COUNT_1_ID, AccountConstant.TEST_COUNT_1_OWNER, AccountConstant.TEST_COUNT_1_BALANCE);
	}
	
	public Account createAccount2() {
		return createSampleAccountWithId(AccountConstant.TEST_COUNT_2_ID, AccountConstant.TEST_COUNT_2_OWNER, AccountConstant.TEST_COUNT_2_BALANCE);
	}
		
	public static Map<Long,Account> createSampleAccountMap() {
		final Map<Long,Account> accountsMap = new HashMap<Long, Account>(); 
		accountsMap.put(AccountConstant.TEST_COUNT_1_ID, AccountDataFactory.createSampleAccountWithId(AccountConstant.TEST_COUNT_1_ID, AccountConstant.TEST_COUNT_1_OWNER, AccountConstant.TEST_COUNT_1_BALANCE));
		accountsMap.put(AccountConstant.TEST_COUNT_2_ID, AccountDataFactory.createSampleAccountWithId(AccountConstant.TEST_COUNT_2_ID, AccountConstant.TEST_COUNT_2_OWNER, AccountConstant.TEST_COUNT_2_BALANCE));
		accountsMap.put(AccountConstant.TEST_COUNT_3_ID, AccountDataFactory.createSampleAccountWithId(AccountConstant.TEST_COUNT_3_ID, AccountConstant.TEST_COUNT_3_OWNER, AccountConstant.TEST_COUNT_3_BALANCE));
		return accountsMap;
	}
	
	public static Account createSampleAccountDefaultWithId(long id) {
		return createSampleAccountWithId(id, AccountConstant.TEST_COUNT_1_OWNER, AccountConstant.TEST_COUNT_1_BALANCE);
	}
	
	public static List<Account> createSampleAccountList() {
		final List<Account> list = new ArrayList<Account>();
		list.add(AccountDataFactory.createSampleAccountWithId(AccountConstant.TEST_COUNT_1_ID, AccountConstant.TEST_COUNT_1_OWNER, AccountConstant.TEST_COUNT_1_BALANCE));
		list.add(AccountDataFactory.createSampleAccountWithId(AccountConstant.TEST_COUNT_2_ID, AccountConstant.TEST_COUNT_2_OWNER, AccountConstant.TEST_COUNT_2_BALANCE));
		list.add(AccountDataFactory.createSampleAccountWithId(AccountConstant.TEST_COUNT_3_ID, AccountConstant.TEST_COUNT_3_OWNER, AccountConstant.TEST_COUNT_3_BALANCE));
		return list;
	}
	
}
