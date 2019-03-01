package com.acme.example.service;

import java.util.List;

import com.acme.example.common.exception.ExampleException;
import com.acme.example.entity.Account;

public interface AccountService {

	void insertAccount(Account account);

	void updateAccount(Account account);
	
	List<Account> findAllAccounts();
	
	void lockAccount(Long id) throws ExampleException;

}
