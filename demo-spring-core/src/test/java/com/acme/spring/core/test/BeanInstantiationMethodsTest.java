package com.acme.spring.core.test;



import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.acme.example.common.constant.AccountConstant;
import com.acme.example.entity.Account;

public class BeanInstantiationMethodsTest {
	
	private final String XML_BEAN_CONFIGURATION_PATH = "/spring-configuration/example-BeanInstantiationMethods-test.xml";
	
	private ClassPathXmlApplicationContext applicationContext;
	
	@Before
	public final void setUp() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext(XML_BEAN_CONFIGURATION_PATH);
	}
	
	@Test
    public final void shouldLoadBeanAccount1() {
		final Account account = applicationContext.getBean("account1", Account.class);
		assertEquals(AccountConstant.TEST_COUNT_1_ID, account.getId());
		assertEquals(AccountConstant.TEST_COUNT_1_OWNER, account.getOwner());
    }
	
	@Test
    public final void shouldLoadBeanAccount2() {
		final Account account = applicationContext.getBean("account2", Account.class);
		assertEquals(AccountConstant.TEST_COUNT_2_ID, account.getId());
		assertEquals(AccountConstant.TEST_COUNT_2_OWNER, account.getOwner());
    }
	
	
}
