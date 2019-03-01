package com.acme.example.spring.testing.config.dependency.injection;

import static org.junit.Assert.assertNotNull;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.acme.example.repository.AccountDao;
import com.acme.example.spring.testing.configuration.AcmeDependencyInjectionConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AcmeDependencyInjectionConfiguration.class)
public class DependencyInjectionTest {
	
	@Autowired
	@Qualifier("otherAccountDao")
	private AccountDao accountDao1;
	
	@Resource
	private AccountDao accountDao;
	
	@Test
	public void shouldBeInjected() {
		assertNotNull(accountDao1);
		assertNotNull(accountDao);
	}

}
