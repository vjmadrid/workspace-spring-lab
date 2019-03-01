package com.acme.spring.core.configuration;



import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.acme.example.service.AccountOperationService;
import com.acme.example.service.AccountService;

public class AnnotationBeanConfigurationTest {
	
	private final String XML_BEAN_CONFIGURATION_PATH = "/spring-configuration/example-AnnotationBeanConfiguration-test.xml";
	
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
