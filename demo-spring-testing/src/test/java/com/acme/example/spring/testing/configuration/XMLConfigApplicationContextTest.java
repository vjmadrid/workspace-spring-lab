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
@ContextConfiguration("classpath:spring-configuration/core-context-test.xml")
//@ContextConfiguration( { "classpath:spring-configuration/*.xml"})
//@ActiveProfiles(profiles={"test"})
public class XMLConfigApplicationContextTest {
	
	@Autowired
	protected AccountService accountService;
	
	@Autowired
	protected AccountOperationService accountOperationService;
	
	@Test
	public void shouldBeInjected() {
		assertNotNull(accountService);
		assertNotNull(accountOperationService);
	}
}
