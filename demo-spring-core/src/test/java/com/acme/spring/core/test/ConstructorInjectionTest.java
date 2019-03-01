package com.acme.spring.core.test;



import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.acme.example.service.AccountOperationService;

public class ConstructorInjectionTest {
	
	private final String XML_BEAN_CONFIGURATION_PATH = "/spring-configuration/example-ConstructorInjection-test.xml";
	
	private ClassPathXmlApplicationContext applicationContext;
	
	private AccountOperationService accountOperationService;
	
	@Before
	public final void setUp() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext(XML_BEAN_CONFIGURATION_PATH);
		
		accountOperationService = applicationContext.getBean("accountOperationService", AccountOperationService.class);
	}
	
	@Test
    public final void shouldBeInjected() {
		assertNotNull(accountOperationService);	
	}
	
}
