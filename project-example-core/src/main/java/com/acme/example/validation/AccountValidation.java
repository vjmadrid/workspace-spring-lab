package com.acme.example.validation;

import com.acme.example.entity.Account;

public enum AccountValidation {

	INSTANCE;

	public boolean isNull(Account account) {
		return (account == null);
	}

	public boolean isNotNull(Account account) {
		return (account != null);
	}

	public boolean isValid(Account account) {
		return (isNotNull(account) && account.getId() != null);
	}

	public boolean isLocked(Account account) {
		return isValid(account) && (account.getLockedDate() != null);
	}
	
}
