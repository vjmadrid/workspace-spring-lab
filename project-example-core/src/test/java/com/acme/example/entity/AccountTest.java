package com.acme.example.entity;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.acme.example.common.constant.AccountConstant;
import com.acme.example.factory.AccountDataFactory;

public class AccountTest {
	
	private Account account;

	private Account anotherAccount;

	private Account cloneAccount;
	
	@Before
	public void init() {
		account = AccountDataFactory.createSampleAccountDefaultWithId(AccountConstant.TEST_ID);
		cloneAccount =  AccountDataFactory.createSampleAccountDefaultWithId(AccountConstant.TEST_ID);
		anotherAccount = AccountDataFactory.createSampleAccountDefaultWithId(AccountConstant.TEST_ID);
		anotherAccount.setId(2L);
	}
	
	@Test
	public void equalsMethodCheckTheType() {
		assertFalse(account.equals("a string"));
	}

	@Test
	public void equalsMehtodCheckSameObject() throws Exception {
		assertTrue(account.equals(account));
	}
	
	@Test
	public void equalsMehtodCheckIdField() throws Exception {
		assertFalse(account.equals(anotherAccount));
	}

	@Test
	public void equalsMehtodCheckIdFieldEquals() throws Exception {
		assertTrue(account.equals(cloneAccount));
	}

	@Test
	public void hashproductMethodBasedInTheIDField() throws Exception {
		assertNotSame(account.hashCode(), anotherAccount.hashCode());
	}

	@Test
	public void shouldHaveADescriptiveToStringMethod() {
		assertNotSame(-1, account.toString().indexOf(Account.class.getSimpleName()));
		assertNotSame(-1,
				account.toString().indexOf("id=".concat(AccountConstant.TEST_ID.toString())));
	}

	@Test
	public void shouldHasMethodAccessors() {
		assertNotNull(account.getId());
		assertNotNull(account.getOwner());
		assertNotNull(account.getBalance());
		assertNotNull(account.isLocked());
		assertNotNull(account.getCreationDate());
		assertNull(account.getAccessDate());
		assertNull(account.getLockedDate());
	}

}
