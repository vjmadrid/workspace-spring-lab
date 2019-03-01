package com.acme.example.spring.testing.initializer;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.mockito.Mockito;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.mock.jndi.SimpleNamingContextBuilder;

public class MockJeeLookUpInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

	@Override
	public void initialize(
			ConfigurableApplicationContext applicationContext) {
			DataSource mockDataSource = (DataSource) Mockito.mock(DataSource.class);
			SimpleNamingContextBuilder builder = new SimpleNamingContextBuilder();
			builder.bind("java:comp/env/miDatasource",mockDataSource);
			
			try {
				builder.activate();
			} catch (IllegalStateException | NamingException e) {
				e.printStackTrace();
			}
	}
}

