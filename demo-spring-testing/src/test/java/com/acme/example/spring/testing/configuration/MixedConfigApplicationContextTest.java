package com.acme.example.spring.testing.configuration;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.acme.example.service.AccountOperationService;
import com.acme.example.service.AccountService;
import com.acme.example.spring.testing.configuration.AcmeConfiguration;
import com.acme.example.spring.testing.configuration.MixedConfigApplicationContextTest.Config;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AcmeConfiguration.class,Config.class})
public class MixedConfigApplicationContextTest {

	@Configuration
	@ImportResource("classpath:spring-configuration/core-context-test.xml")
	static class Config {
	}
	
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
