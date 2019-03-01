package com.acme.spring.core.hello;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.acme.spring.core.entity.HelloWorldLifeCycle;

public class HelloWorldLifeCycleTest {
	
	private final String XML_BEAN_CONFIGURATION_PATH = "/spring-configuration/example-HelloWorldLifeCycle-test.xml";
	
	private ClassPathXmlApplicationContext applicationContext;
	
	private HelloWorldLifeCycle helloWorld;
	
	@Before
	public final void setUp() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext(XML_BEAN_CONFIGURATION_PATH);
		
		helloWorld = applicationContext.getBean("helloWorldLifeCycle", HelloWorldLifeCycle.class);
	}
	
	@Test
    public final void shouldBeInjected() {
		assertNotNull(helloWorld);
		assertEquals("Hello World! (Life Cycle)",helloWorld.getMessage());
		applicationContext.registerShutdownHook();
	}
	
}
