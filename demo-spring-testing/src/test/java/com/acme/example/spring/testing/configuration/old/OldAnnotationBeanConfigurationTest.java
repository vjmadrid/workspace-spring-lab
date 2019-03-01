package com.acme.example.spring.testing.configuration.old;



import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.acme.example.service.AccountOperationService;
import com.acme.example.service.AccountService;

public class OldAnnotationBeanConfigurationTest {
	
	private final String XML_BEAN_CONFIGURATION_PATH = "/spring-configuration/core-annotation-context-test.xml";
	
	private ClassPathXmlApplicationContext applicationContext;
	
	private AccountService accountService;
	
	private AccountOperationService accountOperationService;
	
	@Before
	public final void setUp() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext(XML_BEAN_CONFIGURATION_PATH);
		
		accountService = applicationContext.getBean("accountService", AccountService.class);
		accountOperationService = applicationContext.getBean("accountOperationService", AccountOperationService.class);
	}
	
	@Test
    public final void shouldBeInjected() {
		assertNotNull(accountService);
		assertNotNull(accountOperationService);	
	}
	
}
