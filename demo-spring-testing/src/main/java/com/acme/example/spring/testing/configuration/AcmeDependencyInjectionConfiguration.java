package com.acme.example.spring.testing.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.acme.example.repository.AccountDao;
import com.acme.example.repository.impl.AccountDaoInMemoryImpl;

@Configuration
public class AcmeDependencyInjectionConfiguration {
	
	@Bean
	public AccountDao accountDao() {
		AccountDaoInMemoryImpl bean = new AccountDaoInMemoryImpl();
		//Incluir aqui las dependencias del DAO...
		return bean;
	}
	
	@Bean
	public AccountDao otherAccountDao() {
		AccountDaoInMemoryImpl bean = new AccountDaoInMemoryImpl();
		//Incluir aqui las dependencias del DAO...
		return bean;
	}
}
