package com.acme.spring.core.hello;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.acme.spring.core.entity.HelloWorld;

public class HelloWorldTest {
	
	private final String XML_BEAN_CONFIGURATION_PATH = "/spring-configuration/example-HelloWorld-test.xml";
	
	private ClassPathXmlApplicationContext applicationContext;
	
	private HelloWorld helloWorld;
	
	@Before
	public final void setUp() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext(XML_BEAN_CONFIGURATION_PATH);
		
		helloWorld = applicationContext.getBean("helloWorld", HelloWorld.class);
	}
	
	@Test
    public final void shouldBeInjected() {
		assertNotNull(helloWorld);
		assertEquals("Hello World!",helloWorld.getMessage());
	}
	
}
