package com.acme.example.spring.testing.initializer;

import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.support.GenericApplicationContext;

public class ConfigInitializer implements ApplicationContextInitializer<GenericApplicationContext> {
	
	private static final String PATH_APPLICATION_CONTEXT = "classpath:spring-configuration/core-context.xml";

	@Override
	public void initialize(GenericApplicationContext applicationContext) {
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(applicationContext);
		reader.loadBeanDefinitions(PATH_APPLICATION_CONTEXT);
	}

}
