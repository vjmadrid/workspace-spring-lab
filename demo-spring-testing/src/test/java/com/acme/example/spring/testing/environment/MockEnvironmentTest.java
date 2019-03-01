package com.acme.example.spring.testing.environment;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.acme.example.spring.testing.configuration.EnvironmentConfiguration;
import com.acme.example.spring.testing.initializer.MockPropertyInitializer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		classes=EnvironmentConfiguration.class, 
		initializers= {MockPropertyInitializer.class})
public class MockEnvironmentTest {
	
	@Autowired
	ApplicationContext context;
	
	@Test
	public void environment() throws Exception {
		assertEquals("acme modificado", context.getBean("message"));
	}
	
	
}
