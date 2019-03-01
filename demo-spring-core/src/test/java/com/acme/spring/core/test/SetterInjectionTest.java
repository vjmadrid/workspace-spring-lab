package com.acme.spring.core.test;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.acme.example.common.constant.AccountConstant;
import com.acme.example.entity.Account;
import com.acme.example.service.AccountOperationService;


public class SetterInjectionTest {
	
	private ClassPathXmlApplicationContext applicationContext;
	
	private AccountOperationService accountOperationService;
	
	@Before
	public final void setUp() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext("/spring-configuration/example-SetterInjection-test.xml");
		
		accountOperationService = applicationContext.getBean("accountOperationService", AccountOperationService.class);
	}
	
	@Test
    public final void shouldBeInjected() {
		assertNotNull(accountOperationService);	
	}
	
	@Test
    public final void shouldLoadBeanAccount1() {
		final Account account = applicationContext.getBean("account1", Account.class);
		assertEquals(AccountConstant.TEST_COUNT_1_ID, account.getId());
		assertEquals(AccountConstant.TEST_COUNT_1_OWNER, account.getOwner());
		assertNotNull(account.getCreationDate());
    }
	
	@Test
    public final void shouldLoadBeanAccount2() {
		final Account account = applicationContext.getBean("account2", Account.class);
		assertEquals(AccountConstant.TEST_COUNT_2_ID, account.getId());
		assertEquals(AccountConstant.TEST_COUNT_2_OWNER, account.getOwner());
		assertNotNull(account.getCreationDate());
    }

}
