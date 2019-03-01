package com.acme.example.spring.testing.configuration;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.acme.example.service.AccountOperationService;
import com.acme.example.service.AccountService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AcmeConfiguration.class})
public class JavaConfigApplicationContextTest {
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private AccountOperationService accountOperationService;
	
	@Test
	public void shouldBeInjected() {
		assertNotNull(accountService);
		assertNotNull(accountOperationService);
	}
}
