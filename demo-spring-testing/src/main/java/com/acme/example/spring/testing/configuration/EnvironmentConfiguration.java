package com.acme.example.spring.testing.configuration;


import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource({"classpath:properties/example.properties"})
public class EnvironmentConfiguration {
	
	@Resource
	private Environment environment;
	
	@Bean(name="message")
	public String getMessage() {
		return environment.getProperty("application.context");
	}

}
