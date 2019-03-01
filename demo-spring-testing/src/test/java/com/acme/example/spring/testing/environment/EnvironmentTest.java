package com.acme.example.spring.testing.environment;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.acme.example.spring.testing.configuration.EnvironmentConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={EnvironmentConfiguration.class})
public class EnvironmentTest {
	
	@Autowired
	ApplicationContext context;
	
	@Test
	public void environment() throws Exception {
		assertEquals("acme", context.getBean("message"));
	}
}
