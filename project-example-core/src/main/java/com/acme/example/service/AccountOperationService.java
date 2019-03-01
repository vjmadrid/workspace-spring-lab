package com.acme.example.service;

import com.acme.example.common.exception.ExampleException;
import com.acme.example.entity.Account;


public interface AccountOperationService {
	
	Account getAccount(long accountId);
	
	void transferMoney(long sourceAccountId, long targetAccountId, double amount) throws ExampleException;
	
	void depositMoney(long accountId, double amount) throws ExampleException;
	
}
