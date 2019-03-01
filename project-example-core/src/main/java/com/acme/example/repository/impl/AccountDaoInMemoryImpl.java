package com.acme.example.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.acme.architecture.persistence.repository.test.impl.GenericMapInMemoryRepositoryImpl;
import com.acme.example.entity.Account;
import com.acme.example.factory.AccountDataFactory;
import com.acme.example.repository.AccountDao;

@Repository ("accountDaoInMemory")
public class AccountDaoInMemoryImpl extends GenericMapInMemoryRepositoryImpl<Account, Long> implements AccountDao {

	@PostConstruct
    public void setup() {
		setEntityMap(AccountDataFactory.createSampleAccountMap());
    }
	
	public List<Account> findAll() {
		return new ArrayList<Account>(getEntityMap().values());
	}

	public Account findByPK(Long accountId) {
		return getEntityMap().get(accountId);
	}

	public List<Account> findByQuery(String query) {
		return new ArrayList<Account>(getEntityMap().values());
	}

	public List<Account> findByQueryParameters(String query,
			Map<String, Object> parameters) {
		return new ArrayList<Account>(getEntityMap().values());
	}

	public void insert(Account account) {
		getEntityMap().put(account.getId(), account);
	}

	public void remove(Account account) {
		getEntityMap().remove(account.getId());
	}

	public void update(Account account) {
		getEntityMap().put(account.getId(), account);
	}

}
