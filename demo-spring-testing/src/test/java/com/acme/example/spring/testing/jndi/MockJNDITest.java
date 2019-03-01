package com.acme.example.spring.testing.jndi;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.acme.example.spring.testing.initializer.MockJeeLookUpInitializer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations ="classpath:spring-configuration/jndi-context-test.xml", 
		initializers= {MockJeeLookUpInitializer.class})
public class MockJNDITest {
	
	@Autowired
	ApplicationContext context;
	
	@Test
	public void jndiResource() throws Exception {
		assertNotNull(context.getBean("common-Datasource"));
	}
	
	
}
