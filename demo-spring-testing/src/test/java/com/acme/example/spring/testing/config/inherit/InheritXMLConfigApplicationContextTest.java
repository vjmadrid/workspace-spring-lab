package com.acme.example.spring.testing.config.inherit;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.acme.example.service.AccountOperationService;
import com.acme.example.spring.testing.configuration.XMLConfigApplicationContextTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-configuration/other-core-context-test.xml")
public class InheritXMLConfigApplicationContextTest extends XMLConfigApplicationContextTest {
	
	@Autowired
	private AccountOperationService anotherAccountOperationService;
	
	@Test
	public void shouldBeInjected() {
		assertNotNull(accountService);
		assertNotNull(accountOperationService);
		assertNotNull(anotherAccountOperationService);
	}
}
