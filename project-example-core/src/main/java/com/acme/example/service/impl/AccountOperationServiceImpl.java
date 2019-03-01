package com.acme.example.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.acme.example.common.exception.ExampleException;
import com.acme.example.common.exception.enumerate.AccountTypeExceptionEnum;
import com.acme.example.entity.Account;
import com.acme.example.repository.AccountDao;
import com.acme.example.service.AccountOperationService;
import com.acme.example.validation.AccountValidation;

@Service("accountOperationService")
public class AccountOperationServiceImpl implements AccountOperationService {
	
	private final Logger LOG = LoggerFactory.getLogger(AccountOperationServiceImpl.class);
	
	@Resource
	@Qualifier ("accountDaoInMemory")
	private AccountDao accountDao;
	
	public AccountOperationServiceImpl() {
		super();
	}

	public AccountOperationServiceImpl(AccountDao accountDao) {
		super();
		this.accountDao = accountDao;
	}

	public Account getAccount(long accountId) {
		LOG.trace("Get Account with id : {}", accountId);
		return accountDao.findByPK(accountId);
	}	
	
	private void generateSourceNotFoundException(Account account, AccountTypeExceptionEnum typeException) throws ExampleException {
		if (!AccountValidation.INSTANCE.isValid(account)) {
			throw new ExampleException(typeException.name());
		}
	}
	
	public void depositMoney(long accountId, double amount) throws ExampleException {
		LOG.trace("Depositing Money Account with id : {} [Amount ::{}]", accountId,amount);
		
		Account account = accountDao.findByPK(accountId);
		
		generateSourceNotFoundException(account,AccountTypeExceptionEnum.SOURCE_NOT_FOUND);
		
		account.setBalance(account.getBalance() + amount);
		
		accountDao.update(account);
		
		LOG.trace("Deposit Money Account with id : {} [Amount ::{}]", accountId,amount);
		
	}
	
	public void transferMoney(long sourceAccountId, long targetAccountId, double amount) throws ExampleException {
		LOG.trace("Trasfering Money Source Account with id : {} to Target Account with id :  [Amount ::{}]", sourceAccountId, targetAccountId,amount);
		
		Account sourceAccount = accountDao.findByPK(sourceAccountId);
		Account targetAccount = accountDao.findByPK(targetAccountId);
		
		generateSourceNotFoundException(sourceAccount,AccountTypeExceptionEnum.SOURCE_NOT_FOUND);
		generateSourceNotFoundException(targetAccount,AccountTypeExceptionEnum.TARGET_NOT_FOUND);
		
		sourceAccount.setBalance( (sourceAccount.getBalance() - amount));
		targetAccount.setBalance( (targetAccount.getBalance() + amount));
		
		accountDao.update(sourceAccount);
		accountDao.update(targetAccount);
		
		LOG.trace("Trasfer Money Source Account with id : {} to Target Account with id :  [Amount ::{}]", sourceAccountId, targetAccountId,amount);	
	}
	
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}
}
