package com.acme.example.spring.testing.initializer;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.mock.env.MockPropertySource;

public class MockPropertyInitializer implements ApplicationContextInitializer <ConfigurableApplicationContext> {
		
//	@Override
//	public void initialize(ConfigurableApplicationContext applicationContext) {
//		MockEnvironment mock = new MockEnvironment();
//		mock.setProperty("application.context", "acme modificado");
//		applicationContext.setEnvironment(mock);
//	}
	
	@Override
	public void initialize(ConfigurableApplicationContext applicationContext) {
		MutablePropertySources propertySources = applicationContext.getEnvironment().getPropertySources();
		MockPropertySource mockEnvVars = new MockPropertySource().withProperty("application.context", "acme modificado");
		propertySources.replace(StandardEnvironment.SYSTEM_ENVIRONMENT_PROPERTY_SOURCE_NAME,mockEnvVars);
	}
	
}

