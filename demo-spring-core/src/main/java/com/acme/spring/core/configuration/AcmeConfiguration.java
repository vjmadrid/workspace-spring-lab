package com.acme.spring.core.configuration;

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
		AccountDaoInMemoryImpl dao = new AccountDaoInMemoryImpl();
		//Incluir aqui las depedencias del DAO
		return dao;
	}
	
	@Bean
	public AccountService accountService() {
		AccountServiceImpl service = new AccountServiceImpl();
		//Incluir aqui las dependencias del Servicio
		service.setAccountDao(accountDao());
		return service;
	}
	
	@Bean
	public AccountOperationService accountOperationService() {
		AccountOperationServiceImpl service = new AccountOperationServiceImpl();
		//Incluir aqui las dependencias del Servicio
		service.setAccountDao(accountDao());
		return service;
	}

}
