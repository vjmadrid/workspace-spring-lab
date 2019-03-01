package com.acme.example.spring.testing.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.acme.example.repository.AccountDao;
import com.acme.example.repository.impl.AccountDaoInMemoryImpl;
import com.acme.example.service.AccountOperationService;
import com.acme.example.service.AccountService;
import com.acme.example.service.impl.AccountOperationServiceImpl;
import com.acme.example.service.impl.AccountServiceImpl;

@Configuration
public class AcmeConfiguration {
	
	@Bean
	public AccountDao accountDao() {
		AccountDaoInMemoryImpl bean = new AccountDaoInMemoryImpl();
		//Incluir aqui las dependencias del DAO...
		return bean;
	}
	
	@Bean
	public AccountService accountService() {
		AccountServiceImpl bean = new AccountServiceImpl();
		//Incluir aqui las dependencias del Servicio
		bean.setAccountDao(accountDao());
		return bean;
	}
	
	@Bean
	public AccountOperationService accountOperationService() {
		AccountOperationServiceImpl service = new AccountOperationServiceImpl();
		//Incluir aqui las dependencias del Servicio
		service.setAccountDao(accountDao());
		return service;
	}
}
