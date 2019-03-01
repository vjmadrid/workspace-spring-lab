package com.acme.example.spring.testing.configuration.old;



import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.acme.example.service.AccountOperationService;
import com.acme.example.service.AccountService;
import com.acme.example.spring.testing.configuration.AcmeConfiguration;

public class OldJavaBeanConfigurationTest {
	
	private AnnotationConfigApplicationContext applicationContext;
	
	private AccountService accountService;
	
	private AccountOperationService accountOperationService;
	
	@Before
	public final void setUp() throws Exception {
		applicationContext = new AnnotationConfigApplicationContext(AcmeConfiguration.class);
		
		accountService = applicationContext.getBean("accountService", AccountService.class);
		accountOperationService = applicationContext.getBean("accountOperationService", AccountOperationService.class);
	}
	
	@Test
    public final void shouldBeInjected() {
		assertNotNull(accountService);
		assertNotNull(accountOperationService);	
	}
	
}
