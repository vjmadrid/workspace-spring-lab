package com.acme.example.repository;

import com.acme.architecture.persistence.repository.GenericRepository;
import com.acme.example.entity.Account;

public interface AccountDao extends GenericRepository<Account, Long> {
	   
}

