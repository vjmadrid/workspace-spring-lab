package com.acme.example.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.acme.example.common.exception.ExampleException;
import com.acme.example.common.exception.enumerate.AccountTypeExceptionEnum;
import com.acme.example.entity.Account;
import com.acme.example.repository.AccountDao;
import com.acme.example.service.AccountService;
import com.acme.example.validation.AccountValidation;

@Service("accountService")
public class AccountServiceImpl implements AccountService, Serializable {

	private static final long serialVersionUID = 3352742946434440020L;
	
	private final Logger LOG = LoggerFactory.getLogger(AccountServiceImpl.class);
	
	@Resource
	@Qualifier ("accountDaoInMemory")
	private AccountDao accountDao;

	public void insertAccount(Account account) {
		LOG.trace("Insert Account");
		accountDao.insert(account);	
	}
	
	public void updateAccount(Account account) {
		LOG.trace("Update Account with id : {}", account.getId());
		accountDao.update(account);
	}

	public List<Account> findAllAccounts() {
		LOG.trace("Find all Accounts");
		return accountDao.findAll();
	}
	
	private void generateNotFoundException(Account account) throws ExampleException {
		if (!AccountValidation.INSTANCE.isValid(account)) {
			throw new ExampleException(AccountTypeExceptionEnum.SOURCE_NOT_FOUND.name());
		}
	}
	
	public void lockAccount(Long id) throws ExampleException {
		LOG.trace("Locking Account with id : {}", id);
		
		final Account account = accountDao.findByPK(id);
		
		generateNotFoundException(account);
		
		if (AccountValidation.INSTANCE.isLocked(account)){
			throw new ExampleException(AccountTypeExceptionEnum.IS_LOCKED.name());
		} 
		
		account.setLocked(Boolean.TRUE);
		account.setLockedDate(new Date());
		
		accountDao.update(account);
		LOG.trace("Locked Account with id : {}", id);
	}

	public AccountDao getAccountDao() {
		return accountDao;
	}

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}
	
}
